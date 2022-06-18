

package com.unikohyperspace.api.inventory;

import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個具有返回介面的介面
 * @param <G> 有關 GUI 的類
 * @author UnikoHyperSpace
 */
public interface Returnable<G extends GUI> {

    /**
     * 獲取返回介面的實例
     * @return 上一層介面
     */
    @NotNull G getBacker();

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    void goBack(@NotNull Player player);

}
