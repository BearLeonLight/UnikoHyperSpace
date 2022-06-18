

package com.unikohyperspace.core.thread;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個計時器
 * @author UnikoHyperSpace
 */
public abstract class UnikoHyperSpaceTimeRunnable
        extends UnikoHyperSpaceBukkitRunnable {

    private final int maxCount;

    private int nowCount;

    /**
     * 建構子
     * @param plugin 插件
     * @param period 璇還週期
     */
    public UnikoHyperSpaceTimeRunnable(final @NotNull UnikoHyperSpacePlugin plugin, final long period, final int count) {
        this(plugin, 0L, period, count);
    }

    /**
     * 建構子
     * @param plugin 插件
     * @param delay  開始延遲
     * @param period 璇還週期
     */
    public UnikoHyperSpaceTimeRunnable(final @NotNull UnikoHyperSpacePlugin plugin, final long delay, final long period, final int count) {
        super(plugin, delay, period);
        this.maxCount = count;
        this.nowCount = count;
    }

    @Override
    public final void run() {
        if (this.nowCount <= 0)
            this.stop();

        else {
            this.whenTimeRun();
            --nowCount;
        }
    }

    /**
     * 獲取計時器最大秒數
     * @return 最大秒數
     */
    public final int getMaxCount() {
        return this.maxCount;
    }

    /**
     * 獲取計時器目前秒數
     * @return 目前秒數
     */
    public final int getNowCount() {
        return this.nowCount;
    }

    /**
     * 當計時器被執行
     */
    protected abstract void whenTimeRun();

}
