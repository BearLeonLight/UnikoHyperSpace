package com.unikohyperspace.residenceteleportpoint;


import com.bekvon.bukkit.residence.protection.FlagPermissions;
import com.unikohyperspace.api.plugin.PluginRegister;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.residenceteleportpoint.commands.Main;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ResidenceTeleportPoint extends UnikoHyperSpacePluginBase {
    public static final String PLUGIN_TITLE = "§7[§6ResidenceTeleportPoint§7] §r";

    @PluginRegister(name = "ResidenceTeleportPoint-Load", type = PluginRegister.ActionType.ACTION_LOAD)
    private void load() {
        this.setPLUGIN_TITLE("§7[§fUnikoHyperSpace§6API§7] §r");
    }

    @PluginRegister(name = "ResidenceTeleportPoint-enable", type = PluginRegister.ActionType.ACTION_ENABLE)
    private void enable() {
        FlagPermissions.addFlag("UnLockTP");
        final PluginCommand command = this.getCommand("ResidenceTeleportPoint");
        Main rc = new Main(this);
        if (command != null) command.setExecutor(rc);
    }

    @NotNull
    public static ResidenceTeleportPoint getInstance() {

        return JavaPlugin.getPlugin(ResidenceTeleportPoint.class);
    }

    @PluginRegister(name = "reload", type = PluginRegister.ActionType.ACTION_RELOAD)
    private void reload() {
        getDebugger().info(ResidenceTeleportPoint.PLUGIN_TITLE + "§2reload！");
    }
}
