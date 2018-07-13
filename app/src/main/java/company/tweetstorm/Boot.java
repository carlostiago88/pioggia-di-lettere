package company.tweetstorm.configuration;


import org.apache.commons.cli.*;

import java.util.Arrays;

public class Boot {

    private static final TweetStormOptions tweetStormOptions = new TweetStormOptions();
    private static final TweetStormService tweetStormService = new TweetStormService();

    public static void main(String[] args) {

        Options options = tweetStormOptions.tweetStormOptionsRegister();

        //args = new String[] {"--text=aaaaaaaaaaaaaaaaaaaaaaaaaaaaab" };
        args = new String[] {"-d" };
        /*+
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
               "aaaaaaaaaa aaaaaaaaaaaaaaaaaab"};
        */
        try{
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("text")) {
                String text = cmd.getOptionValue("text");
                if(!text.equals("")){
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



        /*
        CommandLine commandLine;
        TweetStormOptions option_A = TweetStormOptions.builder("A").argName("opt3").hasArg().desc("The A option").build();
        TweetStormOptions option_r = TweetStormOptions.builder("r").argName("opt1").hasArg().desc("The r option").build();
        TweetStormOptions option_S = TweetStormOptions.builder("S").argName("opt2").hasArg().desc("The S option").build();
        TweetStormOptions option_test = TweetStormOptions.builder().longOpt("test").desc("The test option").build();
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption(option_A);
        options.addOption(option_r);
        options.addOption(option_S);
        options.addOption(option_test);

        String header = "               [<arg1> [<arg2> [<arg3> ...\n       Options, flags and arguments may be in any order";
        String footer = "This is DwB's solution brought to Commons CLI 1.3.1 compliance (deprecated methods replaced)";
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CLIsample", header, options, footer, true);

        String[] testArgs =
                { "-r", "opt1", "-S", "opt2", "arg1", "arg2",
                        "arg3", "arg4", "--test", "-A", "opt3", };

        try
        {
            commandLine = parser.parse(options, testArgs);

            if (commandLine.hasOption("A"))
            {
                System.out.print("TweetStormOptions A is present.  The value is: ");
                System.out.println(commandLine.getOptionValue("A"));
            }

            if (commandLine.hasOption("r"))
            {
                System.out.print("TweetStormOptions r is present.  The value is: ");
                System.out.println(commandLine.getOptionValue("r"));
            }

            if (commandLine.hasOption("S"))
            {
                System.out.print("TweetStormOptions S is present.  The value is: ");
                System.out.println(commandLine.getOptionValue("S"));
            }

            if (commandLine.hasOption("test"))
            {
                System.out.println("TweetStormOptions test is present.  This is a flag option.");
            }

            {
                String[] remainder = commandLine.getArgs();
                System.out.print("Remaining arguments: ");
                for (String argument : remainder)
                {
                    System.out.print(argument);
                    System.out.print(" ");
                }

                System.out.println();
            }

        }
        catch (ParseException exception)
        {
            System.out.print("Parse error: ");
            System.out.println(exception.getMessage());
        }*/
    }
}
