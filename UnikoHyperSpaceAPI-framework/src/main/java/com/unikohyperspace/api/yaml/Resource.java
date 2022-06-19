package com.unikohyperspace.api.yaml;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表一個插件生成的資源檔
 *
 * @author UnikoHyperSpace
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {

    /**
     * 代表來自哪個類的資源檔
     *
     * @return 類
     */
    @NotNull Class<? extends Resource> from();

    /**
     * 代表檔案名稱
     *
     * @return 檔案名稱
     */
    @NotNull String locate();

    /**
     * 代表一個可以獲取資源檔的類方法
     *
     * @author UnikoHyperSpace
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceMethod {

        /**
         * 代表函數名稱
         *
         * @return 函數名稱
         */
        @NotNull String name();

        /**
         * @return 獲取到的回傳類
         */
        @NotNull Class<?> returnType();

    }

}
