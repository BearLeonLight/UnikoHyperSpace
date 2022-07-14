package com.unikohyperspace.unikohyperspaceapi.commands.args;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandReload extends SubCommand {
    public CommandReload(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("reload", 0, SenderType.ANY_SENDER, "重新讀取", unikoHyperSpacePluginBase);

    }

    @Override
    public @NotNull boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        if (args.length == 2) {
            if (Utils.reloadUnikoHyperSpacePlugin(args[1])) {
                sender.sendMessage(getPlugin().getPLUGIN_TITLE() + "§2您成功對 §6" + args[1] + " §2插件進行了重讀！");
                return true;
            }

            sender.sendMessage(getPlugin().getPLUGIN_TITLE() + "§c很抱歉，沒有找到名稱為 §6" + args[1] + " §c的插件。");
            return false;
        }

        sender.sendMessage(getPlugin().getPLUGIN_TITLE() + "§c很抱歉，您所輸入的參數不足，請輸入一個插件名稱。");
        return false;
    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        final List<String> list = new ArrayList<>();

        if (args.length == getNextNode() + 1) {
            final List<UnikoHyperSpacePlugin> plugins = Utils.getUnikoHyperSpacePlugins();
            list.addAll(plugins.stream().map(UnikoHyperSpacePlugin::getName).toList());
        }

        return list;
    }
}
