

package com.unikohyperspace.api.builder;

import org.jetbrains.annotations.NotNull;

/**
 * 代表具有建構函數的建構類介面
 * @param <T> 建構對象
 * @author UnikoHyperSpace
 */
@FunctionalInterface
public interface Builder<T> {

    /**
     * 建構函數
     * @return 對象
     */
    @NotNull T build();

}
