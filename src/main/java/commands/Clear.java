package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Clear extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase("~clear")) {
            if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.MESSAGE_MANAGE)) {
                if (args.length < 2) {
                    EmbedBuilder info = new EmbedBuilder();
                    info.setColor(0xff3923);
                    info.setTitle("No Arguments Set");
                    info.setDescription("You must provide an argument for how many messages you would like to delete.");
                    event.getChannel().sendMessageEmbeds(info.build()).queue();
                } else if (args.length > 2) {
                    EmbedBuilder tooManyArgs = new EmbedBuilder();
                    tooManyArgs.setColor(0xff3923);
                    tooManyArgs.setTitle("Too Many Arguments Set");
                    tooManyArgs.setDescription("You must provide only 1 argument after the command.");
                    event.getChannel().sendMessageEmbeds(tooManyArgs.build()).queue();
                } else {
                    try {
                        List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                        event.getChannel().purgeMessages(messages);
                        EmbedBuilder delete = new EmbedBuilder();
                        delete.setColor(0xff3923);
                        delete.setTitle("Successfully deleted " + args[1] + " messages!");
                        event.getChannel().sendMessageEmbeds(delete.build()).queue();
                    } catch (java.lang.IllegalArgumentException e) {
                        if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit is between")) {
                            EmbedBuilder error = new EmbedBuilder();
                            error.setColor(0xff3923);
                            error.setTitle("Too many messages requested");
                            error.setDescription("Only 1-100 messages can be deleted at once");
                            event.getChannel().sendMessageEmbeds(error.build()).queue();
                        }
                    }

                }

            } else {
                EmbedBuilder info = new EmbedBuilder();
                info.setColor(Color.RED);
                info.setTitle("DENIED");
                info.setDescription("You don't have permission to do that!");
                event.getChannel().sendMessageEmbeds(info.build()).queue();
            }
        }
    }
}



