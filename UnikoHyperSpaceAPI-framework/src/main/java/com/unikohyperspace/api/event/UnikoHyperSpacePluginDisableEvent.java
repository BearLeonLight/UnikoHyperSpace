package com.unikohyperspace.api.event;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 代表插件關閉事件
 *
 * @author UnikoHyperSpace
 */
public final class UnikoHyperSpacePluginDisableEvent
        extends UnikoHyperSpacePluginEvent {

    @NotNull
    private static final HandlerList handlers = new HandlerList();

    /**
     * 建構子
     *
     * @param plugin 插件
     */
    public UnikoHyperSpacePluginDisableEvent(@NotNull UnikoHyperSpacePlugin plugin) {
        super(plugin);
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return UnikoHyperSpacePluginDisableEvent.handlers;
    }

    @NotNull
    public HandlerList getHandlers() {
        return UnikoHyperSpacePluginDisableEvent.handlers;
    }

}
