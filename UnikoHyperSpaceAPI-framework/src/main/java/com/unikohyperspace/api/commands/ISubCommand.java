package com.unikohyperspace.api.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個子指令
 *
 * @author UnikoHyperSpace
 */
public interface ISubCommand
        extends ICommandExecutable {

    /**
     * 獲取指令名稱
     *
     * @return 名稱
     */
    @NotNull String getName();

    /**
     * 獲取指令權限
     *
     * @return 權限
     */
    @Nullable Permission getPermission();

    /**
     * 獲取節點位置
     *
     * @return 位置
     */
    @NotNull int getNode();


    /**
     * 獲取下個節點位置
     *
     * @return 位置
     */
    @NotNull int getNextNode();

    /**
     * 獲取指令發送者
     *
     * @return 發送者
     */
    @NotNull SenderType getSenderType();

    /**
     * 獲取指令說明
     *
     * @return 說明
     */
    @NotNull String getDescription();

    /**
     * 檢查指令是否可以被該發送者運行
     *
     * @param sender 發送者
     * @param args   指令參數
     * @return 是否可以運行
     */
    boolean checkCommand(@NotNull CommandSender sender, @NotNull String[] args);

    /**
     * 檢查指令幫助訊息是否可以被使用者查看
     *
     * @param sender 發送者
     * @param args   指令參數
     * @return 是否可以查看
     */
    boolean checkTab(@NotNull CommandSender sender, @NotNull String[] args);


    boolean checkPermission(CommandSender sender);

    boolean checkSenderType(CommandSender sender);

}
