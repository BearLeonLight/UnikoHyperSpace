

package com.unikohyperspace.unikohyperspaceapi.commands;


import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.MainCommandAbstract;
import com.unikohyperspace.unikohyperspaceapi.commands.args.CommandReload;
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
                new Permission("UnikoHyperSpaceAPI.reload"),
                SenderType.ANY_SENDER,
                "用於重新讀取UnikoHyperSpace所開發的插件。")
        );
    }

}
