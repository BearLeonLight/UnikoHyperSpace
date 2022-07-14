package com.unikohyperspace.residenceteleportpoint.listener;

import com.bekvon.bukkit.residence.containers.Flags;
import com.bekvon.bukkit.residence.event.ResidenceTPEvent;
import com.bekvon.bukkit.residence.protection.ResidencePermissions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class ResidenceTPEventListener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onResidenceTPEvent(ResidenceTPEvent e) {
        if (e.getPlayer().hasPermission("residenceteleportpoint.ignore")) return;
        if (e.getPlayer().getUniqueId() == e.getResidence().getOwnerUUID()) return;
        String playerName = e.getPlayer().getName();
        ResidencePermissions perms = e.getResidence().getPermissions();
        boolean defaultValue = true;

        boolean hasPermission = perms.playerHas(e.getRequestingPlayer(), Flags.valueOf("UnLockTP"), defaultValue);
        if (!hasPermission)
            e.setCancelled(true);

    }
}
