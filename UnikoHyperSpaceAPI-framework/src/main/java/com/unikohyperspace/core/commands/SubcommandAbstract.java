

package com.unikohyperspace.core.commands;

import com.unikohyperspace.api.commands.SubCommand;
import com.unikohyperspace.api.commands.SenderType;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 代表一個子指令類
 * @author UnikoHyperSpace
 */
public abstract class SubcommandAbstract
        implements SubCommand {

    protected final Map<String, SubCommand> commandManager = new LinkedHashMap<>();
    // 子指令名
    @NotNull
    private final String name;

    // 指令權限
    @Nullable
    private final Permission permission;

    // 指令發送者
    @NotNull
    private final SenderType senderType;

    // 指令說明
    @NotNull
    private final String description;

    /**
     * 建構子
     * @param name 子指令名
     * @param senderType 指令發送者
     * @param description 指令說明
     */
    public SubcommandAbstract(final @NotNull String name, final @NotNull SenderType senderType, final @NotNull String description) {
        this(name, null, senderType, description);
    }

    /**
     * 建構子
     * @param name 子指令名
     * @param permission 指令權限
     * @param senderType 指令發送者
     * @param description 指令說明
     */
    public SubcommandAbstract(final @NotNull String name, final @Nullable Permission permission, final @NotNull SenderType senderType, final @NotNull String description) {
        this.name = name;
        this.permission = permission;
        this.senderType = senderType;
        this.description = description;
    }

    /**
     * 獲取指令名稱
     *
     * @return 名稱
     */
    @NotNull
    public final String getName() {
        return this.name;
    }

    /**
     * 獲取指令權限
     *
     * @return 權限
     */
    @Nullable
    public final Permission getPermission() {
        return this.permission;
    }

    /**
     * 獲取指令發送者
     *
     * @return 發送者
     */
    @NotNull
    public final SenderType getSenderType() {
        return this.senderType;
    }

    /**
     * 獲取指令說明
     *
     * @return 說明
     */
    @NotNull
    public final String getDescription() {
        return this.description;
    }

    /**
     * 檢查指令是否可以被該發送者運行
     *
     * @param sender 發送者
     * @param args   指令參數
     * @return 是否可以運行
     */
    public final boolean checkCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkPermission(sender);
    }

    /**
     * 檢查指令幫助訊息是否可以被使用者查看
     *
     * @param sender 發送者
     * @param args   指令參數
     * @return 是否可以查看
     */
    public final boolean checkTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender);
    }

    /**
     * 判斷是否為正確的指令發送者
     * @param sender 發送者
     * @return 是否為正確的
     */
    protected final boolean checkSenderType(final @NotNull CommandSender sender) {
        switch (this.senderType) {
            case PLAYER_SENDER -> { return (sender instanceof Player); }

            case CONSOLE_SENDER -> { return (sender instanceof ConsoleCommandSender); }

            case BLOCK_SENDER -> { return (sender instanceof BlockCommandSender); }

            case ANY_SENDER -> { return true; }
        }
        return false;
    }

    /**
     * 判斷使用者是否擁有該指令權限
     * @param sender 發送者
     * @return 是否擁有權限
     */
    protected final boolean checkPermission(final @NotNull CommandSender sender) {
        if (this.permission == null)
            return true;

        return sender.hasPermission(this.permission);
    }

}