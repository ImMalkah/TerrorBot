package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        try {
            if (event.getName().equals("createembed")) {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle(event.getOption("title").getAsString());
                embed.setDescription(event.getOption("body").getAsString());
                if (event.getOption("image") != null)
                {
                    embed.setImage(event.getOption("image").getAsString());
                }

                event.getChannel().sendMessageEmbeds(embed.build()).queue();
                event.reply("Embed Created")
                        .setEphemeral(true)
                        .queue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}