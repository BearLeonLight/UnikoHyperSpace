package com.unikohyperspace.core.manager;

import com.unikohyperspace.api.manager.ThreadManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

/**
 * 用於紀錄相關線程的管理器介面
 *
 * @param <P> 玩家類型
 * @param <T> 任何類型
 * @author UnikoHyperSpace
 */
public abstract class ThreadManagerAbstract<P, T extends BukkitRunnable>
        extends ManagerAbstract<P, T>
        implements ThreadManager<P, T> {

    /**
     * 添加資料到管理器中
     *
     * @param key   k
     * @param value v
     */
    @Override
    public final void add(final @NotNull P key, final @NotNull T value) {
        if (!this.hasKey(key))
            super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     *
     * @param key k
     */
    @Override
    public final void remove(final @NotNull P key) {
        final T thread = this.get(key);
        if (thread != null && !thread.isCancelled())
            thread.cancel();

        super.remove(key);
    }

}
