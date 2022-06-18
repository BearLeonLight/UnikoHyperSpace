

package com.unikohyperspace.core.inventory;

import com.unikohyperspace.api.inventory.button.Button;
import com.unikohyperspace.api.inventory.button.ClickButton;
import com.unikohyperspace.api.inventory.button.event.ClickButtonEvent;
import com.unikohyperspace.api.inventory.gui.*;
import com.unikohyperspace.core.reflect.CraftBukkitReflect;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 代表使用者介面處理程序
 * @author UnikoHyperSpace
 */
public final class UInventoryListenerHandler
        implements GUIHandler {

    // 處理介面
    @NotNull
    private final GUI handler;

    // 運行操作管理器
    @NotNull
    private final Map<Class<? extends InventoryEvent>, List<Method>> eventMethods = new LinkedHashMap<>();

    // 點擊按鈕集合
    @NotNull
    private final Map<UUID, Button> buttons = new LinkedHashMap<>();

    /**
     * 建構子
     * @param gui 處理介面
     */
    public UInventoryListenerHandler(final @NotNull GUI gui) {
        this.handler = gui;

        // 初始化
        this.sortedListener(InventoryOpenEvent.class);
        this.sortedListener(InventoryClickEvent.class);
        this.sortedListener(InventoryCloseEvent.class);
    }

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    public void executeListener(final @NotNull InventoryEvent event) {
        // 處理按鈕事件
        if (event instanceof InventoryClickEvent clickEvent)
            if (this.executeInventoryClickEvent0(clickEvent))
                return;

        // 處理類函數事件
        final List<Method> methods = this.eventMethods.get(event.getClass());
        if (methods != null) {
            for (final Method method : methods)
                CraftBukkitReflect.invoke(method, this.handler, event);
        }
    }

    /**
     * 處理按鈕事件
     * @param event 事件
     * @return 是否已經運行過按鈕
     */
    private boolean executeInventoryClickEvent0(final @NotNull InventoryClickEvent event) {
        // 獲取點擊按鈕ID
        final @Nullable Button button = this.buttons.get(
                ButtonBuilder.getButtonId(event.getCurrentItem())
        );

        if (button == null)
            return false;

        event.setCancelled(true); // 取消事件
        // 如果按鈕可點擊
        if (button instanceof ClickButton clickButton) {
            clickButton.executeButtonClick(
                    new ClickButtonEvent(
                            this.handler, (Player) event.getWhoClicked(), clickButton, event.getClick()
                    ));

            // 重新繪製按鈕
            this.handler.drawButtons(button);
        }

        return true;
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param eventClass 事件類
     */
    private void sortedListener(final @NotNull Class<? extends InventoryEvent> eventClass) {
        final List<Method> methods = new LinkedList<>();

        for (final Method method : this.handler.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(GUIRegister.class) && method.getParameterCount() == 1) {
                final Class<?> parameter = method.getParameterTypes()[0];

                if (parameter.equals(eventClass))
                    methods.add(method);
            }
        }

        if (methods.size() > 0) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(GUIRegister.class).priority())
            ).toList();

            this.eventMethods.put(eventClass, sortedMethods);
        }
    }

    /**
     * 註冊點擊按鈕
     * @param buttons 按鈕
     */
    public void registerButton(final @NotNull Button... buttons) {
        for (final Button button : buttons)
            this.buttons.put(button.getButtonUUID(), button);
    }

    /**
     * 獲取正在處理的介面
     * @return 介面
     */
    @NotNull
    public GUI getHandler() {
        return this.handler;
    }

    /**
     * 定義一些介面處理操作
     * @author UnikoHyperSpace
     */
    public static class Helper {
        /**
         * 判斷介面是否為同步觸發
         * @param gui 介面
         * @return 是否同步
         */
        public static boolean isSynchronous(final @NotNull GUI gui) {
            // 獲取介面類
            final Class<? extends @NotNull GUI> guiClass = gui.getClass();
            if (guiClass.isAnnotationPresent(GUIEventSynchronousRegister.class))
                return guiClass.getAnnotation(GUIEventSynchronousRegister.class).isSynchronous();

            return false;
        }

        /**
         * 該事件在介面是否被強制取消
         * @param gui 介面
         * @param eventClass 事件類
         * @return 是否被取消
         */
        public static boolean isCancelEvent(final @NotNull GUI gui, final @NotNull Class<? extends InventoryEvent> eventClass) {
            // 獲取介面類
            final Class<? extends @NotNull GUI> guiClass = gui.getClass();
            if (guiClass.isAnnotationPresent(GUIEventCancelRegister.class)) {
                final @NotNull Class<? extends InventoryEvent>[] cancels =
                        guiClass.getAnnotation(GUIEventCancelRegister.class).cancels();

                return Arrays.stream(cancels).toList().contains(eventClass);
            }

            return false;
        }
    }

}
