package runtime;

import javax.security.auth.login.LoginException;

import events.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class Bot {
    private static JDA jda;
    private static Dotenv config;

    public Bot() throws LoginException {
        config = Dotenv.configure().ignoreIfMissing().load();
        String token = config.get("TOKEN");

        jda = JDABuilder.create(token,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                        GatewayIntent.SCHEDULED_EVENTS)
                .addEventListeners(
                        new SpamTrap(),
                        new SlashCommandListener(),
                        new ModalListener(),
                        new EmojiReaction(jda))
                .setActivity(Activity.playing("with bombs"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("createembed", "Create an embed")
                        .addOption(OptionType.STRING, "title", "The title of the embed", false)
                        .addOption(OptionType.STRING, "body", "The body of the embed", false)
                        .addOption(OptionType.STRING, "image", "The image of the embed", false)
                        .setDefaultPermissions(DefaultMemberPermissions.ENABLED)
        ).queue();
    }

    public static void main(String[] args) {
        try {
            Bot bot = new Bot();
        } catch(LoginException exception) {
            exception.printStackTrace();
        }
    }

    public static JDA getJda() {
        return jda;
    }

    public static Dotenv getConfig() {
        return config;
    }
}

