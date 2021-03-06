package com.unikohyperspace.core.yaml;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 一個載入檔案最底層的類別
 *
 * @author UnikoHyperSpace
 */
public abstract class MemoryLoaderAbstract
        implements MemorySection {

    // 插件
    @NotNull
    private final UnikoHyperSpacePlugin plugin;

    // 檔案
    protected File file;

    // YAML
    protected YamlConfiguration configuration = new YamlConfiguration();

    /**
     * 建構子
     *
     * @param plugin 插件
     * @param path   路徑
     */
    public MemoryLoaderAbstract(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path) {
        this.plugin = plugin;
        final File pathFileObj = new File(plugin.getDataFolder(), path);
        if (!this.createPath(pathFileObj))
            plugin.getDebugger().warning("§c用於存放檔案路徑創建失敗，這是一個錯誤訊息。");
    }

    /**
     * 創建路徑
     *
     * @param path 檔案路徑
     * @return 是否成功創建
     */
    protected final boolean createPath(final @NotNull File path) {
        if (!path.exists())
            return path.mkdirs();

        return true;
    }

    /**
     * 獲取檔案實例
     *
     * @return 檔案
     */
    @NotNull
    public final File getFile() {
        return this.file;
    }

    /**
     * 獲取YAML實例
     *
     * @return YAML
     */
    @NotNull
    public final YamlConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * 獲取檔案所屬插件
     *
     * @return 插件
     */
    @NotNull
    public final UnikoHyperSpacePlugin getPlugin() {
        return plugin;
    }

}
