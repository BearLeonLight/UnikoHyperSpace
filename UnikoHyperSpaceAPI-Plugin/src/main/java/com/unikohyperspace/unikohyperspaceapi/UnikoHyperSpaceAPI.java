package com.unikohyperspace.unikohyperspaceapi;

import com.unikohyperspace.api.plugin.PluginRegister;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.unikohyperspaceapi.commands.CommandMain;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class UnikoHyperSpaceAPI extends UnikoHyperSpacePluginBase {
    // 插件標題

    public static final String PLUGIN_TITLE = "§7[§fUnikoHyperSpace§6API§7] §r";

   /** @PluginRegister(name = "註冊插件事件", type = PluginRegister.ActionType.ACTION_ENABLE)
    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }**/


    @PluginRegister(name = "註冊插件指令", type = PluginRegister.ActionType.ACTION_ENABLE,priority = PluginRegister.ActionPriority.HIGH)
    private void registerCommands() {
        final PluginCommand command = this.getCommand("UnikoHyperSpaceAPI");
        if (command != null) command.setExecutor(new CommandMain());
    }


    @PluginRegister(name = "註冊插件指令", type = PluginRegister.ActionType.ACTION_ENABLE,priority = PluginRegister.ActionPriority.HIGH)
    private void registerCommands_2() {
        final PluginCommand command = this.getCommand("UnikoHyperSpaceAPI");
        if (command != null) command.setExecutor(new CommandMain());
    }
    @PluginRegister(name = "load", type = PluginRegister.ActionType.ACTION_LOAD,priority = PluginRegister.ActionPriority.HIGH)
    private void load() {
    }
    @PluginRegister(name = "reload", type = PluginRegister.ActionType.ACTION_RELOAD,priority = PluginRegister.ActionPriority.HIGH)
    private void reload() {
    }


    /**
     * 獲取當前插件實例
     * @return 插件本身
     */
    @NotNull
    public  static UnikoHyperSpaceAPI getInstance() {

        return JavaPlugin.getPlugin(UnikoHyperSpaceAPI.class);
    }
}
