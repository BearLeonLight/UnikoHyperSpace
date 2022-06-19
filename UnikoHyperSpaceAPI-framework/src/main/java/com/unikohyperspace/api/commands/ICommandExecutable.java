package com.unikohyperspace.api.commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表一個指令可運行介面
 *
 * @author UnikoHyperSpace
 */
public interface ICommandExecutable {

    /**
     * 運行該節點指令
     *
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    boolean onCmd(@NotNull CommandSender sender, @NotNull String[] args);

    /**
     * 運行該節點指令幫助列表
     *
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @Nullable List<String> onTab(@NotNull CommandSender sender, @NotNull String[] args);


    /**
     * 運行該節點指令
     *
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    @NotNull boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args);

    /**
     * 運行該節點指令幫助列表
     *
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args);


}
