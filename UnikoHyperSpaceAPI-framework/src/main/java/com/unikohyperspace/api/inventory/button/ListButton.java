package com.unikohyperspace.api.inventory.button;

import com.unikohyperspace.api.inventory.button.components.Contents;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有清單列表的按鈕
 *
 * @author UnikoHyperSpace
 */
public interface ListButton
        extends ClickButton {

    /**
     * 獲取清單內容管理器
     *
     * @return 內容管理器
     */
    @NotNull Contents getButtonContents();

}
