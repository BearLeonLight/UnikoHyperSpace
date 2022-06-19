package com.unikohyperspace.unikohyperspaceapi;

import com.unikohyperspace.api.plugin.PluginRegister;
import com.unikohyperspace.core.plugin.UnikoHyperSpacePluginBase;
import com.unikohyperspace.unikohyperspaceapi.commands.MainCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class UnikoHyperSpaceAPI extends UnikoHyperSpacePluginBase {
    // 插件標題

    public static final String PLUGIN_TITLE = "§7[§fUnikoHyperSpace§6API§7] §r";

    /**
     * 獲取當前插件實
     *
     * @return 插件本身
     */
    @NotNull
    public static UnikoHyperSpaceAPI getInstance() {

        return JavaPlugin.getPlugin(UnikoHyperSpaceAPI.class);
    }

    /**
     * @PluginRegister(name = "註冊插件事件", type = PluginRegister.ActionType.ACTION_ENABLE)
     * private void registerListener() {
     * Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
     * }
     **/


    @PluginRegister(name = "註冊插件指令", type = PluginRegister.ActionType.ACTION_ENABLE, priority = PluginRegister.ActionPriority.HIGH)
    private void registerCommands() {
        final PluginCommand command = this.getCommand("UnikoHyperSpaceAPI");
        MainCommand MainCommand = new MainCommand(this);
        if (command != null) command.setExecutor(MainCommand);
    }
}
