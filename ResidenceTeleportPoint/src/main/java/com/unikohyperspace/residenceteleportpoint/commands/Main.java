package com.unikohyperspace.residenceteleportpoint.commands;

import com.unikohyperspace.core.commands.MainCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.residenceteleportpoint.commands.rtp.MoveWorldGuard;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Main extends MainCommand {
    public Main(@NotNull UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("rtp", unikoHyperSpacePluginBase);
        this.getCommandNods().addCommand(new MoveWorldGuard(unikoHyperSpacePluginBase));
    }

    @Override
    public boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {

        return true;
    }
}
