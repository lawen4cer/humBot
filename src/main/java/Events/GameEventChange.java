package Events;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.managers.ChannelManager;

import java.util.ArrayList;
import java.util.List;

/*This class allows for twitch streamers that enable streamer mode have a link to there stream automatically post in a specific channel
* notifying guild members that they are live. Currently is hardcoded to notify @everyone*/

public class GameEventChange {
    private int gameType;
    private String url;
    private String userName;
    private TextChannel channel;
    private boolean isInList = false;
    List<Long> whitelist = new ArrayList<>();






    public void handleGameEventChange(User user, Game game, Guild guild) {
        whitelist.add(168857926201638913L);
        gameType= game.getType().getKey();
        userName = user.getName();
        channel = guild.getTextChannelById(402896140384731139L);

        if (whitelist.contains(user.getIdLong())){
            isInList = true;
        }else{
            return;
        }


        if (gameType == 1 && isInList) { //game type 1 == streaming and user is whitelisted
            url = game.getUrl();
            userName = user.getName();
            channel.sendMessage("Hey @everyone " + userName + " is live at " + url + " ! Come hang out and enjoy the stream!").queue();

        }

    }
}
