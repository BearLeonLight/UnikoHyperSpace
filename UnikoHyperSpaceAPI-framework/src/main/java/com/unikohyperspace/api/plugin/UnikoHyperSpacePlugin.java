package com.unikohyperspace.api.plugin;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個Uniko插件
 *
 * @author UnikoHyperSpace
 */
public interface UnikoHyperSpacePlugin
        extends Plugin {

    /**
     * 獲取插件加載器
     *
     * @return 加載器
     */
    @NotNull PluginLoader getLoader();

    /**
     * 獲取紀錄器
     *
     * @return 紀錄器
     */
    @NotNull PluginDebugger getDebugger();

}
