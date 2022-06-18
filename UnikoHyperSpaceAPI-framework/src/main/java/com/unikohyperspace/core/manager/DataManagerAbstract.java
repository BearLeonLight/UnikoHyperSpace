

package com.unikohyperspace.core.manager;

import com.unikohyperspace.api.manager.DataManager;
import com.unikohyperspace.api.yaml.DataLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個資料管理器基礎類別
 * @param <P> 任何類型
 * @param <D> 資料類型
 * @author UnikoHyperSpace
 */
public abstract class DataManagerAbstract<P, D extends DataLoader>
        extends ManagerAbstract<P, D>
        implements DataManager<P, D> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull P key, final @NotNull D value) {
        if (!this.hasKey(key))
            super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull P key) {
        final @Nullable D data = this.get(key);
        if (data != null)
            data.saveData();

        super.remove(key);
    }

}
