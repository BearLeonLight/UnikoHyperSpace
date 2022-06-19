package com.unikohyperspace.api.commands;

import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個主指令
 *
 * @author UnikoHyperSpace
 */
public interface IMainCommand
        extends TabExecutor, ICommandExecutable {
    @NotNull String getName();
}
