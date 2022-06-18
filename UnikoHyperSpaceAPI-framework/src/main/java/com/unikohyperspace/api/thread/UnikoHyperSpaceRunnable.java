

package com.unikohyperspace.api.thread;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個Uniko自訂程序
 * @author UnikoHyperSpace
 */
public interface UnikoHyperSpaceRunnable
        extends Runnable {

    /**
     * 獲取該程序的插件
     * @return 插件
     */
    @NotNull
    UnikoHyperSpacePlugin getPlugin();

    /**
     * 設定程序開始時延遲週期
     * @param delay 新延遲
     * @return 該實例
     */
    @NotNull UnikoHyperSpaceRunnable setDelay(long delay);

    /**
     * 設定程序環延遲週期
     * @param period 新週期
     * @return 該實例
     */
    @NotNull UnikoHyperSpaceRunnable setPeriod(long period);

    /**
     * 獲取程序開始時延遲時間
     * @return 延遲週期
     */
    long getDelay();

    /**
     * 獲取程序循環延遲週期
     * @return 延遲週期
     */
    long getPeriod();

    /**
     * 使程序開始
     */
    void start();

    /**
     * 使程序關閉
     */
    void stop();

    /**
     * 使程序重新開始
     */
    void restart();

}
