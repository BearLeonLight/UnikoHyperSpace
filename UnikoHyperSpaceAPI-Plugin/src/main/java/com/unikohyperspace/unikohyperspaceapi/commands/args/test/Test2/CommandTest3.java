package com.unikohyperspace.unikohyperspaceapi.commands.args.test.Test2;

import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandTest3 extends SubCommand {
    public CommandTest3(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("Test3", 2, SenderType.ANY_SENDER, "Test3", unikoHyperSpacePluginBase);

    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        if (args.length == getNextNode() + 1) {
            list.add("T3-1");
            list.add("T3-2");
            list.add("T3-3");
        }

        return list;
    }
}
