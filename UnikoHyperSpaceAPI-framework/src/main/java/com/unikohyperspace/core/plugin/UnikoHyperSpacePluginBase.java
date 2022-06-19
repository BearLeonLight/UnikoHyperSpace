package com.unikohyperspace.core.plugin;

import com.unikohyperspace.api.plugin.PluginDebugger;
import com.unikohyperspace.api.plugin.PluginLoader;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的Uniko插件
 *
 * @author UnikoHyperSpace
 */
public abstract class UnikoHyperSpacePluginBase
        extends JavaPlugin
        implements UnikoHyperSpacePlugin {

    // 加載器
    @NotNull
    private final PluginLoader loader = new UnikoHyperSpacePluginLoader(this);
    // 紀錄器
    @NotNull
    private final PluginDebugger debugger = new UnikoHyperSpacePluginDebugger(this);
    private String PLUGIN_TITLE = "§7[§fUniko§6HyperSpace§7] §r";

    public String getPLUGIN_TITLE() {
        return PLUGIN_TITLE;
    }

    public void setPLUGIN_TITLE(String PLUGIN_TITLE) {
        this.PLUGIN_TITLE = PLUGIN_TITLE;
    }

    /**
     * 插件加載時調用
     */
    @Override
    public final void onLoad() {
        this.loader.executeLoadAction();
    }

    /**
     * 插件啟用時調用
     */
    @Override
    public final void onEnable() {
        this.loader.executeEnableAction();
    }

    /**
     * 插件關閉時調用
     */
    @Override
    public final void onDisable() {
        this.loader.executeDisableAction();
    }

    /**
     * 插件重讀時調用
     */
    public final void onReload() {
        this.loader.executeReloadAction();
    }

    /**
     * 獲取插件加載器
     *
     * @return 加載器
     */
    @NotNull
    public final PluginLoader getLoader() {
        return this.loader;
    }

    /**
     * 獲取紀錄器
     *
     * @return 紀錄器
     */
    @NotNull
    public final PluginDebugger getDebugger() {
        return this.debugger;
    }


}
