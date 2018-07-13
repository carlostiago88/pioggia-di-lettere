package company.tweetstorm.usecase;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class TweetStormGateway
{
    private static final TweetStormOptions tweetStormOptions = new TweetStormOptions();
    private static final TweetStormService tweetStormService = new TweetStormService();

    public void receiveArgs(String[] args){
        Options options = tweetStormOptions.tweetStormOptionsRegister();
        try{
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("text")) {
                String text = cmd.getOptionValue("text");
                if(text == null){
                    String [] textSplited = tweetStormService.splitTextFor(text);

                    System.out.println("###### BEGIN TWEET STORM #########\n");
                    Arrays.stream(textSplited).forEach(s ->System.out.println(" | "+s+"\n"));
                    System.out.println("###### END TWEET STORM #########");
                }
            }
            if(cmd.hasOption("help")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "tweetStorm", options);
            }
        }catch (ParseException exception)
        {
            System.out.print("Parse error: ");
            System.out.println(exception.getMessage());
        }
    }
}
