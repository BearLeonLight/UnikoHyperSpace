

package com.unikohyperspace.residenceteleportpoint.commands;


import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.MainCommandAbstract;
import com.unikohyperspace.residenceteleportpoint.commands.args.CommandReload;
import com.unikohyperspace.residenceteleportpoint.commands.args.CommandTest;
import org.bukkit.permissions.Permission;

/**
 * 代表該插件的主命令
 */
public final class CommandMain
        extends MainCommandAbstract {

    /**
     * 建構子
     */
    public CommandMain() {
        this.commandManager.put("reload", new CommandReload(
                "reload",
                new Permission("ResidenceTeleportPoint.reload"),
                SenderType.ANY_SENDER,
                "ResidenceTeleportPoint reload。")
        );
        this.commandManager.put("test", new CommandTest(
                "test",
                new Permission("ResidenceTeleportPoint.test"),
                SenderType.ANY_SENDER,
                "測試用命令")
        );
    }

}
