package company.tweetstorm;


import company.tweetstorm.usecase.TweetStormGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boot {

    private static final TweetStormGateway tweetStormGateway = new TweetStormGateway();
    private static final Logger LOGGER = LoggerFactory.getLogger(Boot.class);

    public static void main(String[] args) {
        LOGGER.info("TweetStorm is running...");
        tweetStormGateway.receiveArgs(args);
    }
}
