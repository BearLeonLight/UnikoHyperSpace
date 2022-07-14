package com.unikohyperspace.residenceteleportpoint.commands.rtp;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.managers.storage.StorageException;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubCommand;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoveWorldGuard extends SubCommand {
    RegionManager regions;

    public MoveWorldGuard(UnikoHyperSpacePluginBase unikoHyperSpacePluginBase) {
        super("MoveWorldGuard", 0, SenderType.ANY_SENDER, "新增至WorldGuard", unikoHyperSpacePluginBase);
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        regions = container.get(BukkitAdapter.adapt(getPlugin().getServer().getWorld("world")));

    }

    @Override
    public @NotNull boolean onExecutableCmd(@NotNull CommandSender sender, @NotNull String[] args) {
        AtomicBoolean hsawg = new AtomicBoolean(false);
        Player p = (Player) sender;
        regions.getRegions().forEach((s, protectedRegion) -> {
//            if(hsawg.get())return;
            if (protectedRegion.getOwners().contains(p.getUniqueId())) {
                sender.sendMessage(p.getDisplayName() + " : " + protectedRegion.getId());
                hsawg.set(true);
            }
        });
        ClaimedResidence claimedResidence = Residence.getInstance().getResidenceManager().getByName(args[getNextNode()]);
        if (claimedResidence != null) {
            if (regions.getRegion(claimedResidence.getName()) == null) {
                sender.sendMessage("Create regions");
                BlockVector3 max = BlockVector3.at(claimedResidence.getMainArea().getHighLocation().getBlockX(), claimedResidence.getMainArea().getHighLocation().getBlockY(), claimedResidence.getMainArea().getHighLocation().getBlockZ());
                BlockVector3 min = BlockVector3.at(claimedResidence.getMainArea().getLowLocation().getBlockX(), claimedResidence.getMainArea().getLowLocation().getBlockY(), claimedResidence.getMainArea().getLowLocation().getBlockZ());
                ProtectedRegion Region = new ProtectedCuboidRegion(claimedResidence.getName(), max, min);
                Region.getOwners().addPlayer(claimedResidence.getOwnerUUID());
                claimedResidence.getTrustedPlayers().forEach(residencePlayer ->
                        Region.getMembers().addPlayer(residencePlayer.getUniqueId())
                );

                if (claimedResidence.getPermissions().getFlags().get(com.bekvon.bukkit.residence.containers.Flags.build)) {
                    Region.setFlag(Flags.BUILD, StateFlag.State.ALLOW);
                } else {
                    Region.setFlag(Flags.BUILD, StateFlag.State.DENY);
                }
                Region.setFlag(Flags.BUILD.getRegionGroupFlag(), RegionGroup.NON_MEMBERS);
                Region.setFlag(Flags.USE, StateFlag.State.ALLOW);
                Region.getMembers().addGroup("staff");
                sender.sendMessage("TeleportLocation: " + claimedResidence.getTeleportLocation(null).toString());
//            System.out.println(claimedResidence.getPermissions().getFlags().toString());
                regions.addRegion(Region);
                try {
                    regions.save();
                } catch (StorageException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onExecutableTab(@NotNull CommandSender sender, @NotNull String[] args) {

        final List<String> list = new ArrayList<>();
        if (args.length == getNextNode() + 1) {
            Residence residence = Residence.getInstance();
//          list.addAll(residence.getResidenceManager().getResidences().keySet());
            if (sender.isOp() || !(sender instanceof Player) || sender.hasPermission("Residence.all")) {
                list.addAll(Arrays.stream(residence.getResidenceManager().getResidenceList()).toList());
            } else {
                list.addAll(residence.getResidenceManager().getResidenceList(sender.getName(), true, false));
            }
        }
        return list;
    }
}
