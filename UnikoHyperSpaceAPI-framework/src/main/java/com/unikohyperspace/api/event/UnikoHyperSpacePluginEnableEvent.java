

package com.unikohyperspace.api.event;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 代表插件啟動事件
 * @author UnikoHyperSpace
 */
public final class UnikoHyperSpacePluginEnableEvent
        extends UnikoHyperSpacePluginEvent {

    @NotNull
    private static final HandlerList handlers = new HandlerList();

    /**
     * 建構子
     * @param plugin 插件
     */
    public UnikoHyperSpacePluginEnableEvent(@NotNull UnikoHyperSpacePlugin plugin) {
        super(plugin);
    }

    @NotNull
    public HandlerList getHandlers() {
        return UnikoHyperSpacePluginEnableEvent.handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return UnikoHyperSpacePluginEnableEvent.handlers;
    }
}
