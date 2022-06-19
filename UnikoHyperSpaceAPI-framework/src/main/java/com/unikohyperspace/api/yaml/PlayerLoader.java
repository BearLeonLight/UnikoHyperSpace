package com.unikohyperspace.api.yaml;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個玩家的資料基礎載入器
 *
 * @author UnikoHyperSpace
 */
public interface PlayerLoader<P extends OfflinePlayer>
        extends DataLoader {

    /**
     * 獲取該資料載入器的玩家
     *
     * @return 玩家
     */
    @NotNull P getPlayer();

}
