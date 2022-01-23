package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class BoosterInfo extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase("~firstbooster")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setColor(Color.pink);
            info.setTitle("Booster Info");
            info.addField("Longest Booster", event.getGuild().getBoosters().get(0).getAsMention(), true);
            info.addField("# of Boosters", Integer.toString(event.getGuild().getBoosters().size()), true);
            event.getChannel().sendMessageEmbeds(info.build()).queue();
        }
    }
}
