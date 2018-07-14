package company.tweetstorm.usecase;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TweetStormResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);

    public TweetStormResponse(){
        System.out.println("################\n");
    }

    public TweetStormResponse(String message){
        System.out.println("######### "+message+" #######\n");
    }

    public TweetStormResponse(HelpFormatter formatter, Options options){
        LOGGER.info("parameter help was obtained");
        formatter.printHelp("Tweet Storm Helper", options);
    }

    public TweetStormResponse(String[] message){
        System.out.println("################\n");
        Arrays.stream(message).forEach(s -> System.out.println(" | " + s + "\n"));
        System.out.println("################\n");
    }
}
