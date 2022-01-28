import javax.security.auth.login.LoginException;

import commands.Bing;
import commands.BoosterInfo;
import commands.Clear;
import commands.Online;
import events.EveryoneCooldown;
import events.ServerJoin;
import events.ServerLeave;
import events.SpamTrap;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Calendar;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

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
                new ServerLeave(), new BoosterInfo(), new SpamTrap(), new EveryoneCooldown()
        ).build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.playing("with bombs"));

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Objects.requireNonNull(Objects.requireNonNull(jda.getGuildById(661503702397485057L))
                        .getTextChannelById(757429616439853177L))
                        .sendMessage("9:11PM... Allahu Akbar!").queue();
            }
        };
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR_OF_DAY, 21);
        date.set(Calendar.MINUTE, 11);
        date.set(Calendar.SECOND, 0);
        timer.scheduleAtFixedRate(task, date.getTime(), 86_400_000);
    }
}
