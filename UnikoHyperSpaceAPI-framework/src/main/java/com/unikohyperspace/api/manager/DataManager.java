package com.unikohyperspace.api.manager;

import com.unikohyperspace.api.yaml.DataLoader;

/**
 * 用於紀錄相關資料的管理器介面
 *
 * @param <P> 玩家類型
 * @param <D> 資料類型
 * @author UnikoHyperSpace
 */
public interface DataManager<P, D extends DataLoader>
        extends Manager<P, D> {
}
