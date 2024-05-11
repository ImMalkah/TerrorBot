package events;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EmojiReaction extends ListenerAdapter {
    Guild guild;
    private final Dotenv config;

    public EmojiReaction(JDA jda) {
        config = Dotenv.load();
    }

    final String na = "na:1237593843566776360";
    final String eu = "eu:1237594261646741514";
    final String asia = "asia:1237594377145028629";

    final String red = "❤️";
    final String green = "💚";
    final String yellow = "💛";
    final String pink = "🩷";
    final String blue = "💙";

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        guild = event.getGuild();

        if (event.getChannel().getId().equals(config.get("REACTION_CHANNEL_ID")) && event.getMessageId().equals(config.get("REGION_MESSAGE_ID"))) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case na:
                    System.out.println(STR."\{na} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("NA"))).queue();
                    break;
                case eu:
                    System.out.println(STR."\{eu} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("EU"))).queue();
                    break;
                case asia:
                    System.out.println(STR."\{asia} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("ASIA"))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }

        if (event.getChannel().getId().equals(config.get("REACTION_CHANNEL_ID")) && event.getMessageId().equals(config.get("COLOR_MESSAGE_ID"))) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case red:
                    System.out.println(STR."\{red} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("RED"))).queue();
                    break;
                case green:
                    System.out.println(STR."\{green} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("GREEN"))).queue();
                    break;
                case yellow:
                    System.out.println(STR."\{yellow} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("YELLOW"))).queue();
                    break;
                case pink:
                    System.out.println(STR."\{pink} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("PINK"))).queue();
                    break;
                case blue:
                    System.out.println(STR."\{blue} role added to user: " + event.getUser().getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(config.get("BLUE"))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (event.getChannel().getId().equals(config.get("REACTION_CHANNEL_ID")) && event.getMessageId().equals(config.get("REGION_MESSAGE_ID"))) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case na:
                    System.out.println(STR."\{na} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("NA"))).queue();
                    break;
                case eu:
                    System.out.println(STR."\{eu} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("EU"))).queue();
                    break;
                case asia:
                    System.out.println(STR."\{asia} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("ASIA"))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }

        if (event.getChannel().getId().equals(config.get("REACTION_CHANNEL_ID")) && event.getMessageId().equals(config.get("COLOR_MESSAGE_ID"))) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case red:
                    System.out.println(STR."\{red} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("RED"))).queue();
                    break;
                case green:
                    System.out.println(STR."\{green} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("GREEN"))).queue();
                    break;
                case yellow:
                    System.out.println(STR."\{yellow} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("YELLOW"))).queue();
                    break;
                case pink:
                    System.out.println(STR."\{pink} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("PINK"))).queue();
                    break;
                case blue:
                    System.out.println(STR."\{blue} role removed from user: " + event.getUser().getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(config.get("BLUE"))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }
    }
}
