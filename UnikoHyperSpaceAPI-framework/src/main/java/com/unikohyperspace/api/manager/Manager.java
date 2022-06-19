package com.unikohyperspace.api.manager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * 代表一個基礎的管理器介面
 *
 * @author UnikoHyperSpace
 */
public interface Manager<K, V> {

    /**
     * 添加資料到管理器中
     *
     * @param key   k
     * @param value v
     */
    void add(@NotNull K key, @NotNull V value);

    /**
     * 從管理器中刪除資料
     *
     * @param key k
     */
    void remove(@NotNull K key);

    /**
     * 從管理器中獲取資料
     *
     * @param key k
     * @return v
     */
    @Nullable V get(@NotNull K key);

    /**
     * 檢查該管理器中是否有資料
     *
     * @param key k
     * @return v
     */
    boolean hasKey(@NotNull K key);

    /**
     * 獲取管理器中所有的 value
     *
     * @return 集合
     */
    @NotNull Collection<V> getValues();

    /**
     * 清除所有紀錄
     */
    void clear();

}
