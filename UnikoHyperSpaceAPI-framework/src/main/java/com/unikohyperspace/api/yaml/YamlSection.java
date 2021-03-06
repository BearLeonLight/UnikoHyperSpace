package com.unikohyperspace.api.yaml;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 該類可用於操作與獲取YAML物件資料
 *
 * @author UnikoHyperSpace
 */
public interface YamlSection
        extends FileSection {

    /**
     * 在指定路徑設定一個物件
     *
     * @param var1 路徑
     * @param var2 物件
     */
    void set(@NotNull String var1, @NotNull Object var2);

    /**
     * 在指定路徑獲取某樣物件
     *
     * @param var1 路徑
     * @return 物件
     */
    @Nullable Object get(@NotNull String var1);

    /**
     * 在指定路徑獲取 boolean
     *
     * @param var1 路徑
     * @return Boolean obj
     */
    boolean getBoolean(@NotNull String var1);

    /**
     * 在指定路徑獲取 int
     *
     * @param var1 路徑
     * @return Integer obj
     */
    int getInt(@NotNull String var1);

    /**
     * 在指定路徑獲取 double
     *
     * @param var1 路徑
     * @return Double obj
     */
    double getDouble(@NotNull String var1);

    /**
     * 在指定路徑獲取 String
     *
     * @param var1 路徑
     * @return String obj
     */
    @NotNull String getString(@NotNull String var1);

    /**
     * 在指定路徑獲取 String
     *
     * @param var1  路徑
     * @param isRgb 是否要解析RGB格式
     * @return String obj
     */
    @NotNull String getString(@NotNull String var1, boolean isRgb);

    /**
     * 在指定路徑獲取 ItemStack
     *
     * @param var1 路徑
     * @return ItemStack obj
     */
    @NotNull ItemStack getItemStack(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<Boolean>
     *
     * @param var1 路徑
     * @return List<Boolean> obj
     */
    @NotNull List<Boolean> getBooleanList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<Double>
     *
     * @param var1 路徑
     * @return List<Double> obj
     */
    @NotNull List<Double> getDoubleList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<Float>
     *
     * @param var1 路徑
     * @return List<Float> obj
     */
    @NotNull List<Float> getFloatList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<Byte>
     *
     * @param var1 路徑
     * @return List<Byte> obj
     */
    @NotNull List<Byte> getByteList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<Integer>
     *
     * @param var1 路徑
     * @return List<Integer> obj
     */
    @NotNull List<Integer> getIntegerList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<String>
     *
     * @param var1 路徑
     * @return List<String> obj
     */
    @NotNull List<String> getStringList(@NotNull String var1);

    /**
     * 在指定路徑獲取 List<String>
     *
     * @param var1  路徑
     * @param isRgb 是否要解析RGB格式
     * @return List<String> obj
     */
    @NotNull List<String> getStringList(@NotNull String var1, boolean isRgb);

}
