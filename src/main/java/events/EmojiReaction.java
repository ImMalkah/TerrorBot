package events;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EmojiReaction extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getChannel().getId().equals("1237574837287784479")) {

            System.out.println("Reaction updated in #react-roles");
        }
    }
}
