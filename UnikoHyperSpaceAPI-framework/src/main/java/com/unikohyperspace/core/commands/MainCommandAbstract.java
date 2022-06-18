

package com.unikohyperspace.core.commands;

import com.unikohyperspace.api.commands.MainCommand;
import com.unikohyperspace.api.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 代表一個主指令
 * @author UnikoHyperSpace
 */
public class MainCommandAbstract
        implements MainCommand {

    // 子指令管理器
    @NotNull
    protected final Map<String, SubCommand> commandManager = new LinkedHashMap<>();

    /**
     * 運行該指令
     * @param sender  發送者
     * @param command 指令
     * @param cmd     指令名
     * @param args    參數
     * @return 節點指令幫助列表
     */
    @Override
    public final boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String cmd, final @NotNull String[] args) {
        if (args.length >= 1) {
            final @Nullable SubCommand subCommand = this.commandManager.get(args[0]);

            if (subCommand != null) {
                if (subCommand.checkCommand(sender, args))
                    return subCommand.onCmd(sender, args);

                else {
                    sender.sendMessage("§dUnikoHyperSpace §7㇣ §c很抱歉，您沒有運行該指令參數的權限，或是該指令只可以由 §6" + subCommand.getSenderType().getName() + " §c使用。");
                    return false;
                }
            }
        }

        return this.onCmd(sender, args);
    }

    /**
     * 運行該指令幫助列表
     * @param sender  發送者
     * @param command 指令
     * @param cmd     指令名
     * @param args    參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public final List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String cmd, final @NotNull String[] args) {
        if (args.length >= 1) {
            final @Nullable SubCommand subCommand = this.commandManager.get(args[0]);

            if (subCommand != null && subCommand.checkTab(sender, args))
                return subCommand.onTab(sender, args);
        }

        return this.onTab(sender, args);
    }

    /**
     * 運行該節點指令
     * @param sender  發送者
     * @param args    參數
     * @return 是否成功運行
     */
    public boolean onCmd(final @NotNull CommandSender sender, final @NotNull String[] args) {
        //sender.sendMessage("§dUnikoHyperSpace §7㇣ §7歡迎使用Uniko依賴庫插件，如果有任何插件問題歡迎回報！");
        return true;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args 參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final Collection<SubCommand> commands = this.commandManager.values();
        return commands.stream().map(SubCommand::getName).toList();
    }

}
