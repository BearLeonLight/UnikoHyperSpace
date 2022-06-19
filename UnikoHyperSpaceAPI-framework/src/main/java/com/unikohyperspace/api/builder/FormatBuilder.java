package com.unikohyperspace.api.builder;

import org.jetbrains.annotations.NotNull;

/**
 * 代表具有建構格式函數的建構類介面
 *
 * @param <T> 轉換格式
 * @param <R> 轉換對象
 * @author UnikoHyperSpace
 */
public interface FormatBuilder<T, R>
        extends Builder<T> {

    /**
     * 獲取轉換對象
     *
     * @return 轉換對象
     */
    @NotNull R getReplacer();

}
