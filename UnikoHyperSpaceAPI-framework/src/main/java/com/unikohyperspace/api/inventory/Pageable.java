

package com.unikohyperspace.api.inventory;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有頁數的介面
 * @author UnikoHyperSpace
 */
public interface Pageable
        extends Openable {

    /**
     * 開啟一個介面的頁數
     * @param player 玩家
     * @param page 頁數
     */
    void open(@NotNull Player player, int page);

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    int getPage();

    /**
     * 開啟下一頁
     * @param player 玩家
     */
    void nextPage(@NotNull Player player);

    /**
     * 開啟上一頁
     * @param player 玩家
     */
    void previousPage(@NotNull Player player);

}
