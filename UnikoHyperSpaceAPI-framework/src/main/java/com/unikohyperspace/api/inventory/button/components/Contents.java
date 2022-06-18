

package com.unikohyperspace.api.inventory.button.components;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * 代表一個容器清單介面
 * @author UnikoHyperSpace
 */
public interface Contents {

    /**
     * 添加一個內容至清單
     * @param contents 內容
     */
    void addContents(@NotNull Content... contents);

    /**
     * 選取下一個項目
     */
    void nextContent();

    /**
     * 選取上一個項目
     */
    void previousContent();

    /**
     * 獲取當前選取的項目ID
     * @return ID
     */
    int getSelectedIndex();

    /**
     * 獲取當前選取的項目
     * @return 項目
     */
    @Nullable Content getSelected();

    /**
     * 獲取一個指定的內容
     * @param index 位置
     * @return 內容
     */
    @Nullable Content getContent(int index);

    /**
     * 獲取所有容器中的內容
     * @return 內容清單
     */
    @NotNull Collection<Content> getContents();

}
