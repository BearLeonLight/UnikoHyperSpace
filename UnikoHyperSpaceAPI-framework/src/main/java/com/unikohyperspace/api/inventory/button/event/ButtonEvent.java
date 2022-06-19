package com.unikohyperspace.api.inventory.button.event;

import com.unikohyperspace.api.inventory.button.Button;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表按鈕事件
 *
 * @author UnikoHyperSpace
 */
public abstract class ButtonEvent<B extends Button> {

    // 介面
    @NotNull
    private final GUI gui;

    // 玩家
    @NotNull
    private final Player player;

    // 按鈕
    @NotNull
    private final B button;

    // 點擊方法
    @NotNull
    private final ClickType clickType;

    /**
     * 建構子
     *
     * @param gui       介面
     * @param player    玩家
     * @param button    按鈕
     * @param clickType 點擊方法
     */
    public ButtonEvent(final @NotNull GUI gui,
                       final @NotNull Player player,
                       final @NotNull B button,
                       final @NotNull ClickType clickType) {
        this.gui = gui;
        this.player = player;
        this.button = button;
        this.clickType = clickType;
    }

    /**
     * 獲取事件中的介面
     *
     * @return 介面
     */
    @NotNull
    public final GUI getGUI() {
        return this.gui;
    }

    /**
     * 獲取事件中的玩家
     *
     * @return 玩家
     */
    @NotNull
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * 獲取事件中的按鈕
     *
     * @return 按鈕
     */
    @NotNull
    public final B getButton() {
        return this.button;
    }

    /**
     * 獲取事件點擊方法
     *
     * @return 點擊方法
     */
    @NotNull
    public final ClickType getClickType() {
        return this.clickType;
    }

}
