package company.tweetstorm.usecase;

public class TweetStormService {

    public String[] splitTextFor(String text){
        String[] textSplited = text.split("(?<=\\G.{138})");
        Integer count = textSplited.length;
        Integer part =1;
        for (Integer i = 0; i < count; i++) {
            textSplited[i] = part.toString()+"/"+count.toString()+" "+textSplited[i];
            part++;
        }
        return textSplited;
    }
}
