package com.unikohyperspace.api.inventory.gui;

import com.unikohyperspace.api.inventory.button.Button;
import org.bukkit.event.inventory.InventoryEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 代表使用者介面處理程序
 *
 * @author UnikoHyperSpace
 */
public interface GUIHandler {

    /**
     * 運行事件方法
     *
     * @param event 事件實例
     */
    void executeListener(@NotNull InventoryEvent event);

    /**
     * 註冊點擊按鈕
     *
     * @param buttons 按鈕
     */
    void registerButton(@NotNull Button... buttons);

    /**
     * 獲取正在處理的介面
     *
     * @return 介面
     */
    @NotNull GUI getHandler();

}
