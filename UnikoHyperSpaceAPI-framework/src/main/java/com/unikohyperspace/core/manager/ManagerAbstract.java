package com.unikohyperspace.core.manager;

import com.unikohyperspace.api.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 代表一個管理器基礎類別
 *
 * @param <K> 任何類型
 * @param <V> 任何類型
 */
public abstract class ManagerAbstract<K, V>
        implements Manager<K, V> {

    // 管理器
    protected final Map<K, V> manager = new HashMap<>();

    /**
     * 添加資料到管理器中
     *
     * @param key   k
     * @param value v
     */
    public void add(final @NotNull K key, final @NotNull V value) {
        this.manager.put(key, value);
    }

    /**
     * 從管理器中刪除資料
     *
     * @param key k
     */
    public void remove(final @NotNull K key) {
        this.manager.remove(key);
    }

    /**
     * 從管理器中獲取資料
     *
     * @param key k
     * @return v
     */
    @Nullable
    public V get(final @NotNull K key) {
        return this.manager.get(key);
    }

    /**
     * 檢查該管理器中是否有資料
     *
     * @param key k
     * @return v
     */
    public final boolean hasKey(final @NotNull K key) {
        return this.manager.containsKey(key);
    }

    /**
     * 獲取管理器中所有的 value
     *
     * @return 集合
     */
    @NotNull
    public final Collection<V> getValues() {
        return this.manager.values();
    }

    /**
     * 清除所有紀錄
     */
    public final void clear() {
        this.manager.clear();
    }

}
