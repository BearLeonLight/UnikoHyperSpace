package com.unikohyperspace.core.commands;

import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommandNods {
    private final @NotNull UnikoHyperSpacePluginBase Plugin;

    private final @NotNull HashMap<String, SubCommand> CommandsMap = new LinkedHashMap<>();

    public CommandNods(final @NotNull UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        this.Plugin = unikoHyperSpacePluginBase;
    }

    public HashMap<String, SubCommand> getCommandsMap() {
        return CommandsMap;
    }

    public UnikoHyperSpacePluginBase getPlugin() {
        return Plugin;
    }

    public final @NotNull boolean exists(final @NotNull String name) {
        return this.CommandsMap.containsKey(name);
    }

    public final @NotNull void addCommand(final @NotNull SubCommand subCommand) {
        if (this.CommandsMap.containsKey(subCommand.getName())) return;
        this.CommandsMap.put(subCommand.getName(), subCommand);
    }

    public final @Nullable SubCommand getCommand(final @NotNull String name) {
        if (this.CommandsMap.containsKey(name)) return this.CommandsMap.get(name);
        return null;
    }
}
