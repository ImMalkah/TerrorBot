package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.Objects;


public class EveryoneCooldown extends ListenerAdapter
{
    public void onMessageReceived(MessageReceivedEvent event)
    {
        boolean oldUser = Objects.requireNonNull(event.getMember()).getTimeJoined().isBefore(event.getMessage().getTimeCreated().minusDays(7));
        List<Role> appliedRoles = event.getMember().getRoles();
        boolean hasRole = appliedRoles.stream().anyMatch(role -> event.getMember().getRoles().contains(role.getGuild().getRoleById(934667101669589032L)));

        if(!oldUser && !event.getMember().getUser().isBot() && event.getMessage().mentionsEveryone())
        {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Not allowed to mention everyone if you're a new member.").queue();
        }
        if(oldUser && !hasRole)
        {
            event.getGuild().addRoleToMember(
                    event.getMember(),
                    Objects.requireNonNull(event.getGuild().getRoleById(934667101669589032L))).queue();
            EmbedBuilder info = new EmbedBuilder();
            info.setColor(Color.GREEN);
            info.setTitle("Moderation");
            info.setDescription("Mention role has now been added, try that again");
            event.getChannel().sendMessageEmbeds(info.build()).queue();
        }
    }
}
