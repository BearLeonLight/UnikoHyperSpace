

package com.unikohyperspace.api.inventory;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個可開啟的介面
 * @author UnikoHyperSpace
 */
@FunctionalInterface
public interface Openable {

    /**
     * 開啟一個介面
     * @param player 玩家
     */
    void open(@NotNull Player player);

}
