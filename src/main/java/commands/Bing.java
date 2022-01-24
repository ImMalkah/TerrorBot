package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class Bing extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(args[0].equalsIgnoreCase( "~bing")){
            event.getChannel().sendTyping().queue();
            String yo = event.getTextChannel().getName();
            Objects.requireNonNull(event.getChannel().getHistory().retrievePast(5)).queue();
            event.getChannel().sendMessage("bongggggooo " + yo).queue();
        }

    }
}
