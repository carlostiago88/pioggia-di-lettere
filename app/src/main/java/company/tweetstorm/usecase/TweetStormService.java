package company.tweetstorm.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TweetStormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);

    public TweetStormService(){
        LOGGER.info("TweetStormService loaded with success");
    }

    public String[] splitTextFor(String text) {
        String[] textSplited = new String[]{};
        try {
            textSplited = text.split("(?<=\\G.{138})");
            Integer count = textSplited.length;
            Integer part = 1;
            for (Integer i = 0; i < count; i++) {
                textSplited[i] = part.toString() + "/" + count.toString() + " " + textSplited[i];
                part++;
            }
            LOGGER.info("text splited with success");
        } catch (RuntimeException e) {
            LOGGER.error("wrong to split text");
        }
        return textSplited;
    }
}
