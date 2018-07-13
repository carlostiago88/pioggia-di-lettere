package company.tweetstorm.configuration;

import org.apache.commons.cli.Options;

public class TweetStormOptions {

    private static final Options options = new Options();

    public Options tweetStormOptionsRegister() {
        options.addOption( "h","help",false, "print this message" );
        options.addOption( "v","version", false,"print the version information and exit" );
        options.addOption( "d", "debug",false,"print debugging information" );
        options.addOption("t", "text", true, "full text to Twitter");
        return options;
    }
}
