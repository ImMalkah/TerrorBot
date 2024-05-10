package events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Map;

public class EmojiReaction extends ListenerAdapter {
    Guild guild;

    final String reactionChannel = "1237574837287784479";
    final String regionRoleMessageId = "1237596333796229172";
    final String colourRoleMessageId = "1238536535813652573";

    final String na = "na:1237593843566776360";
    final String eu = "eu:1237594261646741514";
    final String asia = "asia:1237594377145028629";

    final String red = "❤️";
    final String green = "💚";
    final String yellow = "💛";
    final String pink = "🩷";
    final String blue = "💙";

    Map<String, String> regionMap = Map.of(
            na, "1238553198214643824",
            eu, "1238553244817424394",
            asia, "1238553280800620594"
    );

    Map<String, String> colorMap = Map.of(
            red, "1238531662971666542",
            green, "1238532022180380783",
            yellow, "1238532151956213821",
            pink, "1238532600881090654",
            blue, "1238532080116437094"
    );

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        guild = event.getGuild();

        if (event.getChannel().getId().equals(reactionChannel) && event.getMessageId().equals(regionRoleMessageId)) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case na:
                    System.out.println(STR."\{na} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(regionMap.get(na))).queue();
                    break;
                case eu:
                    System.out.println(STR."\{eu} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(regionMap.get(eu))).queue();
                    break;
                case asia:
                    System.out.println(STR."\{asia} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(regionMap.get(asia))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }

        if (event.getChannel().getId().equals(reactionChannel) && event.getMessageId().equals(colourRoleMessageId)) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case red:
                    System.out.println(STR."\{red} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(colorMap.get(red))).queue();
                    System.out.println(STR."Added \{event.getGuild().getRoleById(colorMap.get(red)).getName()} role to \{event.getMember().getUser().getName()}");
                    break;
                case green:
                    System.out.println(STR."\{green} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(colorMap.get(green))).queue();
                    System.out.println(STR."Added \{event.getGuild().getRoleById(colorMap.get(green)).getName()} role to \{event.getMember().getUser().getName()}");
                    break;
                case yellow:
                    System.out.println(STR."\{yellow} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(colorMap.get(yellow))).queue();
                    System.out.println(STR."Added \{event.getGuild().getRoleById(colorMap.get(yellow)).getName()} role to \{event.getMember().getUser().getName()}");
                    break;
                case pink:
                    System.out.println(STR."\{pink} reaction added");
                    System.out.println(event.getGuild().getRoleById(colorMap.get(pink)).getName());
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(colorMap.get(pink))).queue();
                    System.out.println(STR."Added \{event.getGuild().getRoleById(colorMap.get(pink)).getName()} role to \{event.getMember().getUser().getName()}");
                    break;
                case blue:
                    System.out.println(STR."\{blue} reaction added");
                    guild.addRoleToMember(event.getMember(), guild.getRoleById(colorMap.get(blue))).queue();
                    System.out.println(STR."Added \{event.getGuild().getRoleById(colorMap.get(blue)).getName()} role to \{event.getMember().getUser().getName()}");
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (event.getChannel().getId().equals(reactionChannel) && event.getMessageId().equals(regionRoleMessageId)) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case na:
                    System.out.println(STR."\{na} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(regionMap.get(na))).queue();
                    break;
                case eu:
                    System.out.println(STR."\{eu} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(regionMap.get(eu))).queue();
                    break;
                case asia:
                    System.out.println(STR."\{asia} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(regionMap.get(asia))).queue();
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }

        if (event.getChannel().getId().equals(reactionChannel) && event.getMessageId().equals(colourRoleMessageId)) {
            switch (event.getReaction().getEmoji().getAsReactionCode()) {
                case red:
                    System.out.println(STR."\{red} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(colorMap.get(red))).queue();
                    System.out.println(STR."Removed \{event.getGuild().getRoleById(colorMap.get(red)).getName()} role from \{event.getMember().getUser().getName()}");
                    break;
                case green:
                    System.out.println(STR."\{green} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(colorMap.get(green))).queue();
                    System.out.println(STR."Removed \{event.getGuild().getRoleById(colorMap.get(green)).getName()} role from \{event.getMember().getUser().getName()}");
                    break;
                case yellow:
                    System.out.println(STR."\{yellow} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(colorMap.get(yellow))).queue();
                    System.out.println(STR."Removed \{event.getGuild().getRoleById(colorMap.get(yellow)).getName()} role from \{event.getMember().getUser().getName()}");
                    break;
                case pink:
                    System.out.println(STR."\{pink} reaction removed");
                    System.out.println(event.getGuild().getRoleById(colorMap.get(pink)).getName());
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(colorMap.get(pink))).queue();
                    System.out.println(STR."Removed \{event.getGuild().getRoleById(colorMap.get(pink)).getName()} role from \{event.getMember().getUser().getName()}");
                    break;
                case blue:
                    System.out.println(STR."\{blue} reaction removed");
                    guild.removeRoleFromMember(event.getMember(), guild.getRoleById(colorMap.get(blue))).queue();
                    System.out.println(STR."Removed \{event.getGuild().getRoleById(colorMap.get(blue)).getName()} role from \{event.getMember().getUser().getName()}");
                    break;
                default:
                    event.getReaction().removeReaction().queue();
                    break;
            }
        }
    }
}
