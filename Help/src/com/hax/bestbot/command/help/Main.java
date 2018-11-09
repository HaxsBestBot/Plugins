package com.hax.bestbot.command.help;

import com.hax.bestbot.bot.entities.PERMS;
import com.hax.bestbot.bot.entities.Plugin;
import com.hax.bestbot.bot.events.PluginEvent;
import com.hax.bestbot.bot.util.DescriptionBuilder;

import java.util.Arrays;

import static com.hax.bestbot.bot.util.Messages.sendMessage;

public class Main implements Plugin {

    @Override
    public void onCommand(PluginEvent pluginEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        pluginEvent.getPlugins().forEach(
                plugin -> {
                    stringBuilder.append("`");
                    stringBuilder.append(plugin.labels()[0]);
                    stringBuilder.append("` - `");
                    stringBuilder.append(plugin.description());
                    stringBuilder.append("`\n");
                }
        );
        sendMessage(pluginEvent.getExecutor(), "Help", stringBuilder.toString());
    }

    @Override
    public String[] labels() {
        return new String[]{"help"};
    }

    @Override
    public String description() {
        return "Shows all commands!";
    }

    @Override
    public DescriptionBuilder detailedDescription() {
        return new DescriptionBuilder(description(), Arrays.asList("help - Shows the commands"), labels());
    }

    @Override
    public PERMS perms() {
        return PERMS.USER;
    }
}
