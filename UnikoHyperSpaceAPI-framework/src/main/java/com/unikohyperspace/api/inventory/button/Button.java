package com.unikohyperspace.api.inventory.button;

import com.unikohyperspace.api.builder.Builder;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * 代表一個介面上的按鈕
 *
 * @author UnikoHyperSpace
 */
public interface Button
        extends Builder<ItemStack> {

    /**
     * 獲取屬於按鈕的介面
     *
     * @return 介面
     */
    @NotNull GUI getHandler();

    /**
     * 獲取按鈕UUID
     *
     * @return UUID
     */
    @NotNull UUID getButtonUUID();

    /**
     * 獲取物品在介面上的位置
     *
     * @return 位置
     */
    int getButtonSlot();

}
