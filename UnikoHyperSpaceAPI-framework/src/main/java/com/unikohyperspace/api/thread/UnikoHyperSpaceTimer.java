

package com.unikohyperspace.api.thread;

/**
 * 代表一個計時器
 * @author UnikoHyperSpace
 */
public interface UnikoHyperSpaceTimer
        extends UnikoHyperSpaceRunnable {

    /**
     * 獲取計時器最大秒數
     * @return 最大秒數
     */
    int getMaxCount();

    /**
     * 獲取計時器目前秒數
     * @return 目前秒數
     */
    int getNowCount();

}
