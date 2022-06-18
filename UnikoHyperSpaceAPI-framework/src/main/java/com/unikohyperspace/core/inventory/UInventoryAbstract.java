

package com.unikohyperspace.core.inventory;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.inventory.button.Button;
import com.unikohyperspace.api.inventory.gui.GUI;
import com.unikohyperspace.api.inventory.gui.GUIHandler;
import com.unikohyperspace.api.inventory.gui.InventorySize;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個使用者介面類別
 * @author UnikoHyperSpace
 */
public abstract class UInventoryAbstract
        implements GUI {

    // 介面本身
    @NotNull
    protected final Inventory inventory;

    // 標題
    @NotNull
    protected final String inventory_title;

    // 大小
    @NotNull
    protected final InventorySize inventory_size;

    // 事件處理程序
    @NotNull
    protected final GUIHandler eventHandler = new UInventoryListenerHandler(this);

    /**
     * 建構子
     * @param title 介面標題
     * @param size 介面大小
     */
    public UInventoryAbstract(final @NotNull String title, final @NotNull InventorySize size) {
        this.inventory_title = Utils.forMessageToRGB(title);
        this.inventory_size = size;
        this.inventory = Bukkit.createInventory(this, this.inventory_size.getSize(), this.inventory_title);
    }

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull
    public final InventorySize getGUISize() {
        return this.inventory_size;
    }

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull
    public final String getGUITitle() {
        return this.inventory_title;
    }

    /**
     * Get the object's inventory.
     * @return The inventory.
     */
    @NotNull
    public final Inventory getInventory() {
        return this.inventory;
    }

    /**
     * 獲取事件處理程序
     * @return 事件處理程序
     */
    @NotNull
    public final GUIHandler getEventHandler() {
        return this.eventHandler;
    }

    /**
     * 繪製按鈕
     * @param buttons 按鈕
     */
    @NotNull
    public final UInventoryAbstract drawButtons(final @NotNull Button... buttons) {
        for (final HumanEntity entity : this.inventory.getViewers())
            for (final Button button : buttons)
                entity.getOpenInventory().setItem(button.getButtonSlot(), button.build());
        return this;
    }

    /**
     * 繪製物品
     * @param itemStacks 物品
     */
    @NotNull
    public final UInventoryAbstract drawItemStack(final int slotId, final @NotNull ItemStack itemStacks) {
        for (final HumanEntity entity : this.inventory.getViewers())
            entity.getOpenInventory().setItem(slotId, itemStacks);
        return this;
    }

    /**
     * 清除當前介面上的所有物品按鈕
     */
    protected final void clearInventory() {
        final ItemStack airItemStack = new ItemStack(Material.AIR);
        for (int slot = 0; slot < this.inventory_size.getSize(); slot++)
            this.inventory.setItem(slot, airItemStack);
    }

    /**
     * 對該介面註冊按鈕
     * @param buttons 按鈕
     */
    @NotNull
    public final UInventoryAbstract addButtons(final @NotNull Button ... buttons) {
        this.eventHandler.registerButton(buttons);
        return this;
    }

    /**
     * 開啟一個介面
     * @param player 玩家
     */
    @Override
    public void open(final @NotNull Player player) {
        player.openInventory(this.inventory);
        this.initInventory(player);
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    protected abstract void initInventory(final @NotNull Player player);

}
