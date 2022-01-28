package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class ServerJoin extends ListenerAdapter {
    String[] messages = {
            "Recruit [member] has joined the ranks, Allahu Akbar",
            "Hi team! [member] go team!",
            "Allahu Akbar, fellow terrorist [member] has arrived",
            "BOOM! [member] has landed",
            "[member] will await their suicide vest","Coooom here [member]",
            "Grab some cha3ch and chai for our newest addition [member]",
            "[member] has made an EXPLOSIVE entrance",
            "*Hamood voice* Alhamdulilah [member] is amongst the recruits",
            "Welcome haywan [member]",
            "Enta Eskot [member]",
            "Estoobid [member] is here!",
            "We look forward to bombing with [member]",
            "Strap up your vest [member] Welcome to Terror Squad!",
            "Grab your grenades [member] time to get to work!",
            "Pass a rocket launcher to our newest recruit [member]",
            "*Muslim Noises* [member] Welcome!",
            "ALLAHU AKBAR! BOOM! [member]",
            "Eid al ninelefen this year will be spent with our newest member [member] Allahu Akbar!",
            "MOLLY! [member]"
    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        EmbedBuilder info = new EmbedBuilder();
        info.setColor(Color.GREEN);
        info.setDescription(messages[number].replace("[member]", "@" + event.getUser().getAsMention()));
        Objects.requireNonNull(event.getGuild().getTextChannelById(757429616439853177L)).sendMessageEmbeds(info.build()).queue();
        // Add role
        event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(661532567362732043L))).queue();
        event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(661542770225446928L))).queue();

    }

}
