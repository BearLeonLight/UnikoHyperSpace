

package com.unikohyperspace.core.inventory;

import com.unikohyperspace.api.inventory.button.ClickButton;
import com.unikohyperspace.api.inventory.button.event.ClickButtonEvent;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 代表一個可點擊的按鈕建構器
 * @author UnikoHyperSpace
 */
public class ClickButtonBuilder
        extends ButtonBuilder
        implements ClickButton {

    // 點選方法
    @NotNull
    protected final List<ClickType> buttonClickType = new ArrayList<>();

    /**
     * 建構子
     * @param material 材質
     * @param slot     介面位置
     */
    public ClickButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int slot) {
        this(gui, material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount   數量
     * @param slot     介面位置
     */
    public ClickButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int amount, final int slot) {
        this(gui, new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot      介面位置
     */
    public ClickButtonBuilder(final @NotNull GUI gui, final @NotNull ItemStack itemStack, final int slot) {
        super(gui, itemStack, slot);
    }

    /**
     * 初始化按鈕
     */
    @Override
    protected void initButton() {
    }

    /**
     * 當被點擊時調用
     * @param event 事件
     */
    protected void onClick(final @NotNull ClickButtonEvent event) {
    }

    /**
     * 執行監聽事件
     * @param event 事件
     */
    public final void executeButtonClick(final @NotNull ClickButtonEvent event) {
        if (this.buttonClickType.contains(event.getClickType()))
            this.onClick(event);
    }

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull
    public final Collection<ClickType> getButtonClickType() {
        return this.buttonClickType;
    }

}
