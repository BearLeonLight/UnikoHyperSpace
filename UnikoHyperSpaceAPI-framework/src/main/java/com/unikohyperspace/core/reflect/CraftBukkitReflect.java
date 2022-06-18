

package com.unikohyperspace.core.reflect;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * 加強針對 CraftBukkit 的反射機制
 * @author UnikoHyperSpace
 */
public class CraftBukkitReflect
        extends ReflectAbstract {

    // 獲取當前版本(用於將類用路徑做反射)
    @NotNull
    protected static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    // 類路徑
    @NotNull
    public static final String CRAFT_BUKKIT_CLASS_PATH = "org.bukkit.craftbukkit." + CraftBukkitReflect.version + ".";

    /**
     * 獲取 CraftBukkit 下的一個類
     * @param path org.bukkit.craftbukkit.version.路徑
     * @return 類
     */
    public static Class<?> getCraftBukkitClass(final @NotNull String path) {
        return ReflectAbstract.getClass(CraftBukkitReflect.CRAFT_BUKKIT_CLASS_PATH + path);
    }

}
