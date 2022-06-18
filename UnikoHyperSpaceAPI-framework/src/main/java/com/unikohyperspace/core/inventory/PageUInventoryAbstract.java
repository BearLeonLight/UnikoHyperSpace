

package com.unikohyperspace.core.inventory;

import com.unikohyperspace.api.inventory.gui.InventorySize;
import com.unikohyperspace.api.inventory.gui.PageGUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有頁數介面的類別
 * @author UnikoHyperSpace
 */
public abstract class PageUInventoryAbstract
        extends UInventoryAbstract
        implements PageGUI {

    // 當前頁數 (預設=0)
    private int nowPage = 0;

    /**
     * 建構子
     * @param title 介面標題
     * @param size  介面大小
     */
    public PageUInventoryAbstract(final @NotNull String title, final @NotNull InventorySize size) {
        super(title, size);
    }

    /**
     * 初始化介面介面
     * @param player 玩家
     */
    @Override
    @Deprecated
    protected final void initInventory(final @NotNull Player player) {
    }

    /**
     * 初始化介面頁數介面
     * @param player 玩家
     * @param page 頁數
     */
    protected abstract void initPageInventory(final @NotNull Player player, final int page);

    /**
     * 開啟一個介面
     * @param player 玩家
     */
    @Override
    public final void open(final @NotNull Player player) {
        this.open(player, 0);
    }

    /**
     * 開啟一個介面的頁數
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    public final void open(final @NotNull Player player, final int page) {
        super.open(player);
        this.initPageInventory(player, page);
        this.nowPage = page;
    }

    /**
     * 獲取當前頁數
     *
     * @return 頁數
     */
    @Override
    public final int getPage() {
        return this.nowPage;
    }

    /**
     * 開啟下一頁
     *
     * @param player 玩家
     */
    @Override
    public final void nextPage(final @NotNull Player player) {
        this.open(player, ++this.nowPage);
    }

    /**
     * 開啟上一頁
     *
     * @param player 玩家
     */
    @Override
    public final void previousPage(final @NotNull Player player) {
        this.open(player, --this.nowPage);
    }

    /**
     * 將頁數重製
     */
    protected final void restPage() {
        this.nowPage = 0;
    }

}
