package com.unikohyperspace.unikohyperspaceapi.commands.args;

import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.unikohyperspaceapi.commands.args.test.CommandTest2;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandTest extends SubCommand {
    public CommandTest(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("Test", 0, SenderType.ANY_SENDER, "Test", unikoHyperSpacePluginBase);
        this.getCommandNods().addCommand(new CommandTest2(getPlugin()));

    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        if (args.length == getNextNode() + 1) {
            list.add("T1");
            list.add("T2");
            list.add("T3");
        }

        return list;
    }
}
