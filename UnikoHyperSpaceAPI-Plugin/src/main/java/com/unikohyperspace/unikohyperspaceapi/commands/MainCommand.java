package com.unikohyperspace.unikohyperspaceapi.commands;

import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.unikohyperspaceapi.commands.args.CommandReload;
import com.unikohyperspace.unikohyperspaceapi.commands.args.CommandTest;
import org.jetbrains.annotations.NotNull;

public class MainCommand extends com.unikohyperspace.core.commands.MainCommand {
    public MainCommand(@NotNull UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("UnikoHyperSpaceAPI", unikoHyperSpacePluginBase);
        this.getCommandNods().addCommand(new CommandReload(getPlugin()));
        this.getCommandNods().addCommand(new CommandTest(getPlugin()));
    }
}
