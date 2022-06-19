package com.unikohyperspace.core.yaml;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.DataLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 有關資料載入器相關介面
 *
 * @author MouBoeCat
 */
public abstract class DataLoaderAbstract
        extends Loader
        implements DataLoader {

    /**
     * 建構子
     *
     * @param plugin 插件
     * @param path   檔案路徑
     * @param name   檔案
     */
    public DataLoaderAbstract(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path, final @NotNull String name) {
        super(plugin, path, name, true);
        this.initDataLoader();
    }

    /**
     * 初始化相關動作
     */
    protected abstract void initDataLoader();

    /**
     * 用於保存檔案資料
     */
    public final void saveData() {
        super.save();
    }

}
