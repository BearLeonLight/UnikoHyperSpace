
package com.unikohyperspace.unikohyperspaceapi.commands.args;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.core.commands.SubcommandAbstract;
import com.unikohyperspace.unikohyperspaceapi.UnikoHyperSpaceAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表插件的重讀指令
 */
public final class CommandReload
        extends SubcommandAbstract {

    /**
     * 建構子
     * @param name        子指令名
     * @param permission  指令權限
     * @param type        指令發送者
     * @param description 指令說明
     */
    public CommandReload(final @NotNull String name, final @Nullable Permission permission, final @NotNull SenderType type, final @NotNull String description) {
        super(name, permission, type, description);
    }

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    public boolean onCmd(final @NotNull CommandSender sender, final @NotNull String[] args) {

        if (args.length == 2) {
            if (Utils.reloadUnikoHyperSpacePlugin(args[1])&&args[1]!="UnikoHyperSpaceAPI") {
                sender.sendMessage(UnikoHyperSpaceAPI.PLUGIN_TITLE + "§2您成功對 §6" + args[1] + " §2插件進行了重讀！");
                return true;
            }

            sender.sendMessage(UnikoHyperSpaceAPI.PLUGIN_TITLE + "§c很抱歉，沒有找到名稱為 §6" + args[1] + " §c的插件。");
            return false;
        }

        sender.sendMessage(UnikoHyperSpaceAPI.PLUGIN_TITLE + "§c很抱歉，您所輸入的參數不足，請輸入一個插件名稱。");
        return false;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final List<String> list = new ArrayList<>();

        if (args.length == 2) {
            final List<UnikoHyperSpacePlugin> plugins = Utils.getMouBiePlugins();
            list.addAll(plugins.stream().map(UnikoHyperSpacePlugin::getName).toList());
        }

        return list;
    }

}
