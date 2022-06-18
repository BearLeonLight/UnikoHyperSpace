package com.unikohyperspace.residenceteleportpoint;


import com.unikohyperspace.api.plugin.PluginRegister;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.residenceteleportpoint.commands.CommandMain;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ResidenceTeleportPoint extends UnikoHyperSpacePluginBase {
    public static final String PLUGIN_TITLE = "§7[§6ResidenceTeleportPoint§7] §r";
    @PluginRegister(name = "ResidenceTeleportPoint-Load",type = PluginRegister.ActionType.ACTION_LOAD)
    private static void load(){


    }
    @PluginRegister(name = "註冊插件指令", type = PluginRegister.ActionType.ACTION_ENABLE,priority = PluginRegister.ActionPriority.HIGH)
    private void registerCommands() {
        final PluginCommand command = this.getCommand("ResidenceTeleportPoint");
        if (command != null) command.setExecutor(new CommandMain());
    }
    @PluginRegister(name = "註冊插件指令", type = PluginRegister.ActionType.ACTION_ENABLE,priority = PluginRegister.ActionPriority.HIGH)
    private void registerCommands2() {
    }
    @NotNull
    public  static ResidenceTeleportPoint getInstance() {

        return JavaPlugin.getPlugin(ResidenceTeleportPoint.class);
    }
    @PluginRegister(name = "reload",type = PluginRegister.ActionType.ACTION_RELOAD)
    private void reload(){
        System.out.println(ResidenceTeleportPoint.PLUGIN_TITLE + "§2reload！");
        getDebugger().info(ResidenceTeleportPoint.PLUGIN_TITLE + "§2reload！");
    }
}
