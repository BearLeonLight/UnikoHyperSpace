package com.unikohyperspace.residenceteleportpoint;

import com.unikohyperspace.residenceteleportpoint.yaml.utils.PlayerDataLoader;
import org.bukkit.OfflinePlayer;

public class PlayerData {
    public boolean getPlayerData(OfflinePlayer player){
        PlayerDataLoader playerDataLoader = new PlayerDataLoader(player);
        return playerDataLoader.getBoolean("test.asd");
    }
    public void savePlayerData(OfflinePlayer player){
        PlayerDataLoader playerDataLoader = new PlayerDataLoader(player);
        playerDataLoader.set("ttest.t",true);
        playerDataLoader.save();
    }

}
