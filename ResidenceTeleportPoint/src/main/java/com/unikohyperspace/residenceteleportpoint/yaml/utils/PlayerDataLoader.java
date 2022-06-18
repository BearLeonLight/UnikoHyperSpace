package com.unikohyperspace.residenceteleportpoint.yaml.utils;

import com.unikohyperspace.core.yaml.utils.PlayerDataLoaderAbstract;
import com.unikohyperspace.residenceteleportpoint.ResidenceTeleportPoint;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PlayerDataLoader extends PlayerDataLoaderAbstract {
    /**
     * 建構子
     *
     * @param player 玩家
     */
    public PlayerDataLoader(@NotNull OfflinePlayer player) {
        super(ResidenceTeleportPoint.getInstance(), "./Data/Player", player);
    }

    @Override
    protected void initPlayerLoader(@NotNull OfflinePlayer owner) {

    }

}
