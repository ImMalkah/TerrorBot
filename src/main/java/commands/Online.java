package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class Online extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(args[0].equalsIgnoreCase("~online")){
            List<Member> guildMembers = event.getGuild().getMembers(); // list of members
            int guildMembersCount = guildMembers.size(); // count of members
            long onlineGuildMembers = event.getGuild().getMemberCache().stream().filter(member -> !member.getUser().isBot())
                    .filter(member -> !member.getOnlineStatus().equals(OnlineStatus.OFFLINE)).count();
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Server Member Info");
            info.addField("Total", Long.toString(guildMembersCount), true);
            info.addField("Online", Long.toString(onlineGuildMembers), true);
            info.setColor(Color.PINK);
            event.getChannel().sendMessageEmbeds(info.build()).queue();

        }
    }

}