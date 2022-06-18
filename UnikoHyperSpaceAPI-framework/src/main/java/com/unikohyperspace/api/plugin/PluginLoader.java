

package com.unikohyperspace.api.plugin;

/**
 * 用於將Uniko插件加載的載入器
 * @author UnikoHyperSpace
 */
public interface PluginLoader {

    /**
     * 執行加載插件動作
     */
    void executeLoadAction();

    /**
     * 執行啟用插件動作
     */
    void executeEnableAction();

    /**
     * 執行關閉插件動作
     */
    void executeDisableAction();

    /**
     * 執行重載插件動作
     */
    void executeReloadAction();

}
