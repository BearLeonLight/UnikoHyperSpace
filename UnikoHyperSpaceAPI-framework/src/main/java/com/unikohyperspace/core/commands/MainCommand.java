package com.unikohyperspace.core.commands;

import com.unikohyperspace.api.commands.IMainCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class MainCommand implements IMainCommand {
    private final CommandNods commandNods;
    private final UnikoHyperSpacePluginBase Plugin;

    private final String name;

    public MainCommand(final @NotNull String name, final @NotNull UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        this.Plugin = unikoHyperSpacePluginBase;
        this.commandNods = new CommandNods(this.Plugin);
        this.name = name;

    }

    public final @NotNull CommandNods getCommandNods() {
        return this.commandNods;
    }

    @Override
    public final boolean onCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        if (args.length > 0 && this.commandNods.exists(args[0])) {
            return this.commandNods.getCommand(args[0]).onCmd(sender, args);
        }
        return this.onExecutableCmd(sender, args);
    }


    @Override
    public final @Nullable List<String> onTab(@NotNull CommandSender sender, @NotNull String[] args) {
        if (args.length > 0 && this.commandNods.exists(args[0])) {
            return this.commandNods.getCommand(args[0]).onTab(sender, args);
        }
        return this.onExecutableTab(sender, args);
    }

    @Override
    public boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        sender.sendMessage(this.Plugin.getPLUGIN_TITLE() + "[Debug] ExecutableCmd" + "沒有任何動作" + "(" + this.getName() + ")");
        return false;
    }

    @NotNull
    @Override
    public String getName() {
        return this.name.toLowerCase();
    }

    @Override
    public List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        return this.getCommandNods().getCommandsMap().keySet().stream().toList();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return onCmd(sender, args);
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return onTab(sender, args);
    }

    public final UnikoHyperSpacePluginBase getPlugin() {
        return this.Plugin;
    }

}
