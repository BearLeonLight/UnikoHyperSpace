package com.unikohyperspace.unikohyperspaceapi.commands.args.test.Test2;

import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandChackPlayer extends SubCommand {
    public CommandChackPlayer(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("ChackPlayer", 2, SenderType.ANY_SENDER, "Test3", unikoHyperSpacePluginBase);

    }

    @Override
    public @NotNull boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        if (getPlugin().getServer().getPlayer(args[getNextNode()]) != null) {
            sender.sendMessage(getPlugin().getPLUGIN_TITLE() + "玩家存在");
            return true;
        }
        sender.sendMessage(getPlugin().getPLUGIN_TITLE() + "找不到該玩家");
        return false;
    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();
        if (args.length == getNextNode() + 1) {
            for (OfflinePlayer offlinePlayer : getPlugin().getServer().getOfflinePlayers()) {
                list.add(offlinePlayer.getName());
            }
            list.addAll(getPlugin().getServer().getOnlinePlayers().stream().map(Player::getName).toList());
        }

        return list;
    }
}
