
package com.unikohyperspace.residenceteleportpoint.commands.args;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubcommandAbstract;
import com.unikohyperspace.residenceteleportpoint.ResidenceTeleportPoint;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
        if(Utils.reloadUnikoHyperSpacePlugin(ResidenceTeleportPoint.getInstance().getName())){
            if (sender instanceof Player) sender.sendMessage(ResidenceTeleportPoint.PLUGIN_TITLE + "§2reload！");
            return true;
        }else {
            return false;
        }
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


        return list;
    }

}
