package com.unikohyperspace.core.yaml.utils;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.PluginFileLoader;
import com.unikohyperspace.core.yaml.Loader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的插件嵌入式檔案載入器
 *
 * @author UnikoHyperSpace
 */
public abstract class PluginFileLoaderAbstract
        extends Loader
        implements PluginFileLoader {

    /**
     * 建構子
     *
     * @param plugin 插件
     * @param path   檔案路徑
     * @param name   檔案
     */
    public PluginFileLoaderAbstract(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path, final @NotNull String name) {
        super(plugin, path, name, false);
    }

    /**
     * 用於將資料加載或重新加載
     */
    public final void reloadFile() {
        super.load();
    }

}
