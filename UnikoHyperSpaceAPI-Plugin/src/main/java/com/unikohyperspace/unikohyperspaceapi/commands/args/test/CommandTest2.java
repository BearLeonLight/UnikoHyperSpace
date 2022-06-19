package com.unikohyperspace.unikohyperspaceapi.commands.args.test;

import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.unikohyperspaceapi.commands.args.test.Test2.CommandChackPlayer;
import com.unikohyperspace.unikohyperspaceapi.commands.args.test.Test2.CommandTest3;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandTest2 extends SubCommand {
    public CommandTest2(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("Test2", 1, SenderType.ANY_SENDER, "Test2", unikoHyperSpacePluginBase);

    }

    @Override
    public boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        if (args.length > getNextNode() + 1) {
            System.out.println("[debug]" + " Node-[" + args[getNode()] + "]" + " NextNode-[" + args[getNextNode()] + "]");
            if (args[getNextNode()].equalsIgnoreCase("T2")) return new CommandTest3(getPlugin()).onCmd(sender, args);
            return new CommandChackPlayer(getPlugin()).onCmd(sender, args);
        }
        return super.onExecutableCmd(sender, args);
    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        if (args.length > getNextNode() + 1) {

            if (args[getNextNode()].equalsIgnoreCase("T2")) return new CommandTest3(getPlugin()).onTab(sender, args);

            return new CommandChackPlayer(getPlugin()).onTab(sender, args);
        }
        if (args.length == getNextNode() + 1) {
            list.add("T2-1");
            list.add("T2-2");
            list.add("T2-3");
        }

        return list;
    }
}
