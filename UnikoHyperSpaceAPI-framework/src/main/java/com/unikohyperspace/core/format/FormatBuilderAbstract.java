package com.unikohyperspace.core.format;

import com.unikohyperspace.api.builder.FormatBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個格式的建構抽象類
 *
 * @param <T> 任何類型
 * @param <R> 任何類型
 * @author UnikoHyperSpace
 */
public abstract class FormatBuilderAbstract<T, R>
        implements FormatBuilder<T, R> {

    // 被轉換格式
    @NotNull
    private final T replaceObj;

    // 根據物件轉換格式
    @NotNull
    private final R replacer;

    /**
     * 建構子
     *
     * @param replaceObj 被轉換格式
     * @param replacer   根據什麼物件轉換
     */
    public FormatBuilderAbstract(final @NotNull T replaceObj, final @NotNull R replacer) {
        this.replaceObj = replaceObj;
        this.replacer = replacer;
    }

    /**
     * 建構出的對象實例
     *
     * @return 建構格式
     */
    @NotNull
    public final T build() {
        return this.replace(this.replaceObj, replacer);
    }

    /**
     * 轉換單一格式
     *
     * @param replace  被轉換格式
     * @param replacer 根據什麼物件轉換
     * @return 轉換完成格式
     */
    @NotNull
    public abstract T replace(final @NotNull T replace, final @NotNull R replacer);

    /**
     * 獲取被轉換的對象
     *
     * @return 轉換之對象
     */
    @NotNull
    public final R getReplacer() {
        return this.replacer;
    }

}
