import javax.security.auth.login.LoginException;

import commands.*;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public static void main(String[] args) throws InterruptedException, LoginException {
    JDA jda = JDABuilder.create(Token.token,
        GatewayIntent.GUILD_MEMBERS,
        GatewayIntent.GUILD_MESSAGES,
        GatewayIntent.GUILD_PRESENCES,
        GatewayIntent.GUILD_VOICE_STATES,
        GatewayIntent.GUILD_MESSAGE_REACTIONS)
            .addEventListeners(
                    new SpamTrap(),
                    new EveryoneCooldown(),
                    new SlashCommandListener(),
                    new ModalListener(),
                    new EmojiReaction())
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
    );
    commands.queue();
}