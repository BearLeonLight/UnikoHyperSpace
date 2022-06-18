

package com.unikohyperspace.core.yaml.utils;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.yaml.PlayerLoader;
import com.unikohyperspace.core.yaml.DataLoaderAbstract;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個玩家的資料基礎載入器
 * @author UnikoHyperSpace
 */
public abstract class PlayerDataLoaderAbstract<P extends OfflinePlayer>
        extends DataLoaderAbstract
        implements PlayerLoader<P> {

    // 玩家
    @NotNull
    protected final P owner;

    /**
     * 建構子
     * @param plugin    插件
     * @param path      檔案路徑
     * @param player    玩家
     */
    public PlayerDataLoaderAbstract(final @NotNull UnikoHyperSpacePlugin plugin, final @NotNull String path, final @NotNull P player) {
        super(plugin, path, player.getUniqueId() + ".yml");
        this.owner = player;
        this.initPlayerLoader(player);
    }

    /**
     * 獲取該資料載入器的玩家
     * @return 玩家
     */
    @NotNull
    public final P getPlayer() {
        return this.owner;
    }

    /**
     * 初始化相關動作
     * @param owner 紀錄擁有者
     */
    protected abstract void initPlayerLoader(final @NotNull P owner);

    /**
     * 初始化相關動作
     */
    @Override
    protected final void initDataLoader() {
        this.save();
    }

}
