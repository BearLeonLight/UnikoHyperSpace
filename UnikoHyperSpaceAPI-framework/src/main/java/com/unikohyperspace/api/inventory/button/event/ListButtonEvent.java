

package com.unikohyperspace.api.inventory.button.event;

import com.unikohyperspace.api.inventory.button.ListButton;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表清單按鈕點擊事件
 * @author UnikoHyperSpace
 */
public class ListButtonEvent
        extends ButtonEvent<ListButton> {

    /**
     * 建構子
     * @param gui         介面
     * @param player      玩家
     * @param button      按鈕
     * @param clickType   點擊方法
     */
    public ListButtonEvent(final @NotNull GUI gui,
                           final @NotNull Player player,
                           final @NotNull ListButton button,
                           final @NotNull ClickType clickType) {
        super(gui, player, button, clickType);
    }

}
