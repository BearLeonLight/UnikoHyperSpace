package com.unikohyperspace.core.commands;

import com.unikohyperspace.api.commands.ISubCommand;
import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class SubCommand implements ISubCommand {

    @NotNull
    private final String name;
    @Nullable
    private final Permission permission;

    @NotNull
    private final int nods;
    @NotNull
    private final SenderType senderType;
    @NotNull
    private final String description;

    @NotNull
    private final CommandNods commandNods;
    private final UnikoHyperSpacePluginBase Plugin;

    public SubCommand(final @NotNull String name, final @NotNull int nods, final @NotNull SenderType senderType, final @NotNull String description, UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        this(name, nods, senderType, description, null, unikoHyperSpacePluginBase);

    }

    public SubCommand(final @NotNull String name, final @NotNull int nods, final @NotNull SenderType senderType, final @NotNull String description, final @Nullable Permission permission, UnikoHyperSpacePluginBase UnikoHyperSpacePluginBase) {
        this.name = name;
        this.nods = nods;
        this.senderType = senderType;
        this.description = description;
        this.permission = permission;
        this.Plugin = UnikoHyperSpacePluginBase;
        this.commandNods = new CommandNods(this.Plugin);
    }

    public final @NotNull CommandNods getCommandNods() {
        return this.commandNods;
    }

    @Override
    public final boolean onCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        if (!checkCommand(sender, args)) {
            sender.sendMessage(this.Plugin.getPLUGIN_TITLE() + "§7㇣ §c很抱歉，您沒有運行該指令參數的權限，或是該指令只可以由 §6" + getSenderType().getName() + " §c使用。");
            return false;
        }
        if (args.length > getNextNode() && this.commandNods.exists(args[getNextNode()])) {
            return this.commandNods.getCommand(args[getNextNode()]).onCmd(sender, args);
        }
        return this.onExecutableCmd(sender, args);
    }

    @Override
    public final @Nullable List<String> onTab(@NotNull CommandSender sender, @NotNull String[] args) {
        if (!checkTab(sender, args)) {
            return null;
        }
        List<String> list = new ArrayList<>();
        if (args.length > getNextNode() && this.commandNods.exists(args[getNextNode()])) {
            return this.commandNods.getCommand(args[getNextNode()]).onTab(sender, args);
        } else if (args.length == getNextNode() + 1) {
            list.addAll(commandNods.getCommandsMap().keySet().stream().toList());
        }
        list.addAll(this.onExecutableTab(sender, args));
        return list;

    }

    @Override
    public @NotNull boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        sender.sendMessage(this.Plugin.getPLUGIN_TITLE() + "[Debug] ExecutableCmd" + "沒有任何動作" + "(" + this.getName() + ")");
        return false;
    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {
        return null;
    }

    @Override
    public final @NotNull String getName() {
        return this.name.toLowerCase();
    }

    @Override
    public final @Nullable Permission getPermission() {
        return this.permission;
    }

    @Override
    public final @NotNull int getNode() {
        return this.nods;
    }

    @Override
    public final @NotNull int getNextNode() {
        return (getNode() + 1);
    }

    @Override
    public final @NotNull SenderType getSenderType() {
        return this.senderType;
    }

    @Override
    public final @NotNull String getDescription() {
        return this.description;
    }

    @Override
    public boolean checkCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender);
    }

    @Override
    public boolean checkTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender);
    }

    @Override
    public boolean checkPermission(final @NotNull CommandSender sender) {
        if (this.permission == null)
            return true;

        return sender.hasPermission(this.permission);
    }

    @Override
    public boolean checkSenderType(final @NotNull CommandSender sender) {
        switch (this.senderType) {
            case PLAYER_SENDER -> {
                return (sender instanceof Player);
            }

            case CONSOLE_SENDER -> {
                return (sender instanceof ConsoleCommandSender);
            }

            case BLOCK_SENDER -> {
                return (sender instanceof BlockCommandSender);
            }

            case ANY_SENDER -> {
                return true;
            }
        }
        return false;
    }

    public final UnikoHyperSpacePluginBase getPlugin() {
        return this.Plugin;
    }

}
