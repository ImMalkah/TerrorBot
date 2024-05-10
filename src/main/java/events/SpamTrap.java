package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SpamTrap extends ListenerAdapter {
    private Map<User, Integer> warned = new HashMap<>();

    public void onMessageReceived(MessageReceivedEvent event) {
        List<Message> history = event.getChannel().getIterableHistory().complete().stream().limit(7) // gets last 10 messages in channel
                .filter(msg -> !msg.equals(event.getMessage())).collect(Collectors.toList()); // filters out the last message sent (does not include it)
        int spam = history.stream()
                // gets the author of the previous message if it's the same author as the message sent and makes sure it's not a bot
                .filter(message -> message.getAuthor().equals(event.getAuthor()) && !message.getAuthor().isBot())
                // message time sent - last seen message time sent if it's less than 6 seconds
                .filter(msg -> (event.getMessage().getTimeCreated().toEpochSecond() - msg.getTimeCreated().toEpochSecond() < 6)).collect(Collectors.toList()).size();
        if (spam > 2 && !Objects.equals(event.getGuild().getOwner(), event.getMember()) && !Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
            int timesWarned = 0;
            if (warned.containsKey(event.getAuthor()))
                timesWarned = warned.get(event.getAuthor());
            warned.put(event.getAuthor(), timesWarned + 1);
            if (timesWarned == 3) {
                event.getMember().timeoutFor(5, TimeUnit.MINUTES).queue();
                EmbedBuilder info = new EmbedBuilder();
                info.setColor(Color.RED);
                info.setTitle("Moderation");
                info.setDescription(event.getAuthor().getAsMention() + " has been timed out for 5 minutes");
                info.addField("Reason","Repeated spamming",true);
                event.getChannel().sendMessageEmbeds(info.build()).queue();

            } else {
                System.out.println("hi");
            }
        }
    }
}

