

package com.unikohyperspace.core.yaml;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.FileLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 一個最基礎功能的檔案加載器 可被其他類繼承功能
 * @author UnikoHyperSpace
 */
public class Loader
        extends YamlLoaderAbstract
        implements FileLoader {

    /**
     * 建構子
     * @param plugin 插件
     * @param path      檔案路徑
     * @param name      檔案
     * @param isNewFile 是否新創建
     */
    public Loader(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(plugin, path, name, isNewFile);
    }

}
