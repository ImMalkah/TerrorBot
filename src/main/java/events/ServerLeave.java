package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;

public class ServerLeave extends ListenerAdapter {
    public void onGuildMemberRemove(GuildMemberRemoveEvent event){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Leave Event");
        info.setDescription("Good riddance " + event.getUser().getAsMention() + " has left the server.");
        info.setColor(Color.RED);
        Objects.requireNonNull(event.getGuild().getTextChannelById(759111183860236339L)).sendMessageEmbeds(info.build()).queue();
    }
}
