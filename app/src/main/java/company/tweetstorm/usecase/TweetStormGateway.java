package company.tweetstorm.usecase;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TweetStormGateway {
    private static final TweetStormOptions tweetStormOptions = new TweetStormOptions();
    private static final TweetStormService tweetStormService = new TweetStormService();
    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);

    public TweetStormResponse receiveArgs(String[] args) {
        Options options = tweetStormOptions.tweetStormOptionsRegister();
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("help")) {
                return new TweetStormResponse(new HelpFormatter(),options);
            } else if (cmd.hasOption("text")) {
                String text = cmd.getOptionValue("text");
                String[] textSplited = tweetStormService.splitTextFor(text);
                return new TweetStormResponse(textSplited);
            }
        } catch (ParseException exception) {
            LOGGER.error("Parse Error: " + exception.getMessage());
            return new TweetStormResponse("Use -h to help");
        }
        return new TweetStormResponse("No parameters :(");
    }
}
