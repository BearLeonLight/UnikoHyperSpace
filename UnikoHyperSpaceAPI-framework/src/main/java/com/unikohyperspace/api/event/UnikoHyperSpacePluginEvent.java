package com.unikohyperspace.api.event;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表Uniko插件的事件
 *
 * @author UnikoHyperSpace
 */
public abstract class UnikoHyperSpacePluginEvent
        extends UnikoHyperSpaceEvent {

    // 事件插件
    @NotNull
    private final UnikoHyperSpacePlugin plugin;

    /**
     * 建構子
     *
     * @param plugin 插件
     */
    public UnikoHyperSpacePluginEvent(@NotNull UnikoHyperSpacePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 獲取事件的插件
     *
     * @return 插件
     */
    @NotNull
    public UnikoHyperSpacePlugin getPlugin() {
        return this.plugin;
    }

}
