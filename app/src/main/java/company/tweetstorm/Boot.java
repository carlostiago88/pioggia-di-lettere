package company.tweetstorm;


import company.tweetstorm.usecase.TweetStormOptions;
import company.tweetstorm.usecase.TweetStormService;
import org.apache.commons.cli.*;

import java.util.Arrays;

public class Boot {

    private static final TweetStormOptions tweetStormOptions = new TweetStormOptions();
    private static final TweetStormService tweetStormService = new TweetStormService();

    public static void main(String[] args) {

        //args = new String[] {"--text=aaaaaaaaaaaaaaaaaaaaaaaaaaaaab" };
        args = new String[] {"-d" };
        /*+
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
                "aaaaaaaaaa aaaaaaaaaaaaaaaaaab" +
               "aaaaaaaaaa aaaaaaaaaaaaaaaaaab"};
        */
    }
}
