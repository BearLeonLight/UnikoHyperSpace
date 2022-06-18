

package com.unikohyperspace.api.inventory.button;

import com.unikohyperspace.api.inventory.button.event.ClickButtonEvent;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * 代表一個可點擊的按鈕
 * @author UnikoHyperSpace
 */
public interface ClickButton
        extends Button {

    /**
     * 當被點擊時調用
     * @param event 點擊事件
     */
    void executeButtonClick(@NotNull ClickButtonEvent event);

    /**
     * 獲取點擊的方法
     *
     * @return 點擊方法
     */
    @NotNull Collection<ClickType> getButtonClickType();

}
