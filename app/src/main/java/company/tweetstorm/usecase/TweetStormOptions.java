package company.tweetstorm.usecase;

import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TweetStormOptions {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);
    private static final Options options = new Options();

    Options tweetStormOptionsRegister() {
        options.addOption( "h","help",false, "print this message" );
        options.addOption("t", "text", true, "full text to Twitter");
        return options;
    }
}
