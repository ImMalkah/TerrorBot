import javax.security.auth.login.LoginException;

import commands.Bing;
import commands.BoosterInfo;
import commands.Clear;
import commands.Online;
import events.EveryoneCooldown;
import events.ServerJoin;
import events.SpamTrap;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    public static String prefix = "~"; // command prefix
    public static void main(String[] args) throws InterruptedException, LoginException {
        JDABuilder builder = JDABuilder.create(Token.token,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_EMOJIS,
                GatewayIntent.GUILD_VOICE_STATES);
        JDA jda = builder.addEventListeners(new Online(), new Bing(), new Clear(), new ServerJoin(),
                new ServerJoin(), new BoosterInfo(), new SpamTrap(), new EveryoneCooldown()
        ).build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.playing("with bombs"));
    }
}
