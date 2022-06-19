package com.unikohyperspace.api.inventory.gui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 迫使介面事件使用同步處理
 * 警告：
 * 如果介面為異步處理，請確保取消 InventoryClickEvent 的事件。除非您有其它想法。否則這是必須的！
 * {@code @GUIEventCancelRegister(}  cancels = { InventoryClickEvent.class } )
 * <p>
 * 或是在您的介面類中聲明
 * {@code @GUIEventSynchronousRegister}
 * 讓介面同步觸發。但您必須在適當的情況，自行處理取消事件，否則按鈕將會被意外拋出。
 *
 * @author UnikoHyperSpace
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GUIEventSynchronousRegister {

    /**
     * 獲取是否同步觸發
     *
     * @return 是否同步
     */
    boolean isSynchronous() default true;

}
