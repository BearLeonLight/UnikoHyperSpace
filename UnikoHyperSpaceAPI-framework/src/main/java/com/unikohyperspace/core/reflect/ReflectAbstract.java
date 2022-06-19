package com.unikohyperspace.core.reflect;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 提供一些基本的反射機制代碼
 *
 * @author UnikoHyperSpace
 */
abstract class ReflectAbstract {

    /**
     * 根據路徑獲取一個 Class 類
     *
     * @param path 路徑
     * @return 類
     */
    @SuppressWarnings("all")
    public static Class<?> getClass(final @NotNull String path) {
        try {
            return Class.forName(path);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根據一個 Class 類獲取類的一個屬性
     *
     * @param clazz     類
     * @param fieldName 屬性名稱
     * @return 類屬性
     */
    @SuppressWarnings("all")
    public static Field getField(final @NotNull Class<?> clazz, final @NotNull String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (final NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根據一個屬性獲取一個對想屬性實例
     *
     * @param field  屬性
     * @param object 獲取對象
     * @return 對象屬性實例
     */
    @SuppressWarnings("all")
    public static Object getObject(final @NotNull Field field, final @NotNull Object object) {
        try {
            // 設定可強制訪問
            field.setAccessible(true);
            // 訪問
            return field.get(object);
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根據一個 Class 類獲取類的一個方法
     *
     * @param clazz      類
     * @param methodName 方法名稱
     * @param argsClass  方法參數對照表
     * @return 類方法
     */
    @SuppressWarnings("all")
    public static Method getMethod(final @NotNull Class<?> clazz, final @NotNull String methodName, final @NotNull Class<?>... argsClass) {
        try {
            return clazz.getMethod(methodName, argsClass);
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 調用一個類方法
     *
     * @param method      類方法
     * @param privateCall 是否強制繞過調用訪問
     * @param obj         在哪個實例上調用
     * @param args        類方法參數
     * @return
     */
    @SuppressWarnings("all")
    public static Object invoke(final @NotNull Method method, final @Nullable Object obj, final @Nullable Object... args) {
        try {
            // 設定可強制訪問
            method.setAccessible(true);
            // 調用
            return method.invoke(obj, args);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
