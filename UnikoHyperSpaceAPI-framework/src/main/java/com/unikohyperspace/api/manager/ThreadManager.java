package com.unikohyperspace.api.manager;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * 用於紀錄相關線程的管理器介面
 *
 * @param <P> 玩家類型
 * @param <T> 任何類型
 * @author UnikoHyperSpace
 */
public interface ThreadManager<P, T extends BukkitRunnable>
        extends Manager<P, T> {
}
