

package com.unikohyperspace.api.inventory.gui;

import com.unikohyperspace.api.inventory.Openable;
import com.unikohyperspace.api.inventory.button.Button;
import com.unikohyperspace.core.inventory.UInventoryAbstract;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個使用者介面
 * @author UnikoHyperSpace
 */
public interface GUI
        extends Openable, InventoryHolder {

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull InventorySize getGUISize();

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull String getGUITitle();

    /**
     * 獲取事件處理程序
     * @return 事件處理程序
     */
    @NotNull GUIHandler getEventHandler();

    /**
     * 對該介面註冊按鈕
     * @param buttons 按鈕
     */
    @NotNull UInventoryAbstract addButtons(final @NotNull Button ... buttons);

    /**
     * 繪製按鈕
     * @param buttons 按鈕
     */
    @NotNull GUI drawButtons(@NotNull Button... buttons);

    /**
     * 繪製物品
     * @param itemStacks 物品
     */
    @NotNull GUI drawItemStack(int slotId, @NotNull ItemStack itemStacks);

}
