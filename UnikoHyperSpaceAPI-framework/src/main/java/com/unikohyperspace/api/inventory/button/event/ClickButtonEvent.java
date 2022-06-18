

package com.unikohyperspace.api.inventory.button.event;

import com.unikohyperspace.api.inventory.button.ClickButton;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 按表按鈕點擊事件
 * @author UnikoHyperSpace
 */
public class ClickButtonEvent
        extends ButtonEvent<ClickButton> {

    /**
     * 建構子
     * @param gui         介面
     * @param player      玩家
     * @param button      按鈕
     * @param clickType   點擊方法
     */
    public ClickButtonEvent(final @NotNull GUI gui,
                           final @NotNull Player player,
                           final @NotNull ClickButton button,
                           final @NotNull ClickType clickType) {
        super(gui, player, button, clickType);
    }

}
