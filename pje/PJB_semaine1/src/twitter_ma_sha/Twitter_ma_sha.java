
package twitter_ma_sha;
import java.util.List;
import java.util.Map;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter_ma_sha {
    
    public static void main(String[] args) throws TwitterException {
    java.util.Map<String, RateLimitStatus> rateLimitStatusMap;
    String contenuTweet;
    ConfigurationBuilder  cb=new ConfigurationBuilder();
    cb.setDebugEnabled(true).setOAuthConsumerKey("hdoHDP9NqnnkWqb0sdgp6NqQ6")
            .setOAuthConsumerSecret("GNwSwlga7KtBakmzm7HrZNF7JwUBQVIurjqcs8xZpspHpNPxd9")
            .setOAuthAccessToken("850048760961019904-9ibSRksZl2LFba0ZgxbGGODBsfH0Qmg")
            .setOAuthAccessTokenSecret("F0iWOONiOTgCxKkAx0TWWbuNbAuEF2s2onR0TuAD9dEVU");
    TwitterFactory tf=new TwitterFactory(cb.build());
    twitter4j.Twitter twitter=tf.getInstance();
    List<Status> status=twitter.getHomeTimeline();
    for(Status st:status){System.out.println(st.getUser().getName()
            +"------------"+st.getText());}
   //-----------------------------------------------------------------
   //----------------------------------------------------------------
   //------------------------------------------------------------------
    rateLimitStatusMap = twitter.getRateLimitStatus();
     RateLimitStatus rateLimitStatus = rateLimitStatusMap.get("/application/rate_limit_status");
    if(rateLimitStatus.getRemaining() > 0) {

                            for (Status tweet : status) {
                                if (tweet.getRetweetedStatus() != null) // Si le tweet est un retweet
                                    contenuTweet = tweet.getRetweetedStatus().getText();
                                else // Sinon, c'est un tweet original
                                    contenuTweet = tweet.getText();
                                // Il faut enlever les retours à la ligne, car
                                // dans le fichier CSV, un retour à la ligne est
                                // interprété comme étant le tweet suivant.
                                contenuTweet = contenuTweet.replaceAll("\n", "");
                                // Il faut remplacer les ";" par des ",", car
                                // dans le fichier CSV, un ";" est interprété
                                // comme étant le séparateur des champs.
                                contenuTweet = contenuTweet.replaceAll(";", ",");
                System.out.println(tweet.getId() + ";" + tweet.getUser().getScreenName() + ";" + contenuTweet
                                        + ";" + tweet.getCreatedAt() + ";" + "\n" ) ;
                            }
                              
    
    }}
}
