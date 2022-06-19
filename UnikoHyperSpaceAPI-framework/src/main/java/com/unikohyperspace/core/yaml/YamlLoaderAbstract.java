package com.unikohyperspace.core.yaml;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.YamlSection;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 該類可用於操作與獲取YAML物件資料類別
 *
 * @author UnikoHyperSpace
 */
public abstract class YamlLoaderAbstract extends FileLoaderAbstract
        implements YamlSection {
    /**
     * 建構子
     *
     * @param plugin    插件
     * @param path      檔案路徑
     * @param name      檔案
     * @param isNewFile 是否新創建
     */
    public YamlLoaderAbstract(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(plugin, path, name, isNewFile);
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    /**
     * 在指定路徑設定一個物件
     *
     * @param var1 路徑
     * @param var2 物件
     */
    public final void set(final @NotNull String var1, final @NotNull Object var2) {
        this.configuration.set(var1, var2);
    }

    /**
     * 在指定路徑獲取某樣物件
     *
     * @param var1 路徑
     * @return 物件
     */
    @Nullable
    public final Object get(final @NotNull String var1) {
        return this.configuration.get(var1);
    }

    /**
     * 在指定路徑獲取 boolean
     *
     * @param var1 路徑
     * @return Boolean obj
     */
    public final boolean getBoolean(final @NotNull String var1) {
        return this.configuration.getBoolean(var1);
    }

    /**
     * 在指定路徑獲取 int
     *
     * @param var1 路徑
     * @return Integer obj
     */
    public final int getInt(final @NotNull String var1) {
        return this.configuration.getInt(var1);
    }

    /**
     * 在指定路徑獲取 double
     *
     * @param var1 路徑
     * @return Double obj
     */
    public final double getDouble(final @NotNull String var1) {
        return this.configuration.getDouble(var1);
    }

    /**
     * 在指定路徑獲取 String
     *
     * @param var1 路徑
     * @return String obj
     */
    @NotNull
    public final String getString(final @NotNull String var1) {
        return this.getString(var1, false);
    }

    /**
     * 在指定路徑獲取 String
     *
     * @param var1  路徑
     * @param isRgb 是否要解析RGB格式
     * @return String obj
     */
    @NotNull
    public final String getString(final @NotNull String var1, final boolean isRgb) {
        final String getString = this.configuration.getString(var1);
        return (getString != null) ? (isRgb) ?
                Utils.forMessageToRGB(getString) : getString : "§4ERROR";
    }

    /**
     * 在指定路徑獲取 ItemStack
     *
     * @param var1 路徑
     * @return ItemStack obj
     */
    @NotNull
    public final ItemStack getItemStack(final @NotNull String var1) {
        final ItemStack itemStack = this.configuration.getItemStack(var1);
        return itemStack != null ? itemStack : new ItemStack(Material.AIR);
    }

    /**
     * 在指定路徑獲取 List<Boolean>
     *
     * @param var1 路徑
     * @return List<Boolean> obj
     */
    @NotNull
    public final List<Boolean> getBooleanList(final @NotNull String var1) {
        return this.configuration.getBooleanList(var1);
    }

    /**
     * 在指定路徑獲取 List<Double>
     *
     * @param var1 路徑
     * @return List<Double> obj
     */
    @NotNull
    public final List<Double> getDoubleList(final @NotNull String var1) {
        return this.configuration.getDoubleList(var1);
    }

    /**
     * 在指定路徑獲取 List<Float>
     *
     * @param var1 路徑
     * @return List<Float> obj
     */
    @NotNull
    public final List<Float> getFloatList(final @NotNull String var1) {
        return this.configuration.getFloatList(var1);
    }

    /**
     * 在指定路徑獲取 List<Byte>
     *
     * @param var1 路徑
     * @return List<Byte> obj
     */
    @NotNull
    public final List<Byte> getByteList(final @NotNull String var1) {
        return this.configuration.getByteList(var1);
    }

    /**
     * 在指定路徑獲取 List<Integer>
     *
     * @param var1 路徑
     * @return List<Integer> obj
     */
    @NotNull
    public final List<Integer> getIntegerList(final @NotNull String var1) {
        return this.configuration.getIntegerList(var1);
    }

    /**
     * 在指定路徑獲取 List<String>
     *
     * @param var1 路徑
     * @return List<String> obj
     */
    @NotNull
    public final List<String> getStringList(final @NotNull String var1) {
        return this.getStringList(var1, false);
    }

    /**
     * 在指定路徑獲取 List<String>
     *
     * @param var1  路徑
     * @param isRgb 是否要解析RGB格式
     * @return List<String> obj
     */
    @NotNull
    public final List<String> getStringList(final @NotNull String var1, final boolean isRgb) {
        final List<String> stringList = this.configuration.getStringList(var1);
        if (isRgb) {
            final List<String> stringListRbg = new ArrayList<>();
            for (final String str : stringList)
                stringListRbg.add(Utils.forMessageToRGB(str));

            return stringListRbg;
        }

        return stringList;
    }

}
