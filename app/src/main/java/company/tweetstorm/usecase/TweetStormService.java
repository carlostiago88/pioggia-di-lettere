package company.tweetstorm.usecase;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TweetStormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetStormGateway.class);

    public String[] splitTextFor(String text) {
        LOGGER.info("parameter text was obtained");
        String[] textSplited = new String[]{};
        try {
            textSplited = text.split("(?<=\\G.{137})");
            Integer count = textSplited.length;
            if(count == 0){
                throw new RuntimeException();
            }
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
