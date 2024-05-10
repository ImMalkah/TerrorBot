package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ModalListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        try {
            if (event.getModalId().equals("createembed")) {
                String subject = event.getValues().get(0).getAsString();
                String body = event.getValues().get(1).getAsString();
                String image = event.getValues().get(2).getAsString();

                System.out.println(subject + body + image);

                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle(subject);
                embed.setDescription(body);
                embed.setImage(image);

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
