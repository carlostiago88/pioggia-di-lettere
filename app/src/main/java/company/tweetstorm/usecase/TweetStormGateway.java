package company.tweetstorm.usecase;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TweetStormGateway
{
    private static final TweetStormOptions tweetStormOptions = new TweetStormOptions();
    private static final TweetStormService tweetStormService = new TweetStormService();
    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);

    public void receiveArgs(String[] args){
        Options options = tweetStormOptions.tweetStormOptionsRegister();
        try{
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("help")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "tweetStorm", options);
            }
            else if(cmd.hasOption("text")) {
                String text = cmd.getOptionValue("text");
                String[] textSplited = tweetStormService.splitTextFor(text);
                LOGGER.info("parameter text was obtained");
                System.out.println("###### BEGIN TWEET STORM #########\n");
                Arrays.stream(textSplited).forEach(s -> System.out.println(" | " + s + "\n"));
                System.out.println("###### END TWEET STORM #########");
            }
           }catch (ParseException exception)
        {
            LOGGER.error("Parse Error: "+ exception.getMessage()+". Use -h to help");
        }
    }
}
