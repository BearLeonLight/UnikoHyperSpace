package com.unikohyperspace.core.plugin;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.plugin.PluginDebugger;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 代表一個插件紀錄器
 *
 * @author UnikoHyperSpace
 */
public final class UnikoHyperSpacePluginDebugger
        implements PluginDebugger {

    // 插件
    @NotNull
    private final UnikoHyperSpacePlugin plugin;

    // 紀錄器
    @NotNull
    private final Logger logger;

    /**
     * 建構子
     *
     * @param plugin 插件
     */
    public UnikoHyperSpacePluginDebugger(final @NotNull UnikoHyperSpacePlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    /**
     * 紀錄資訊訊息
     *
     * @param msg 訊息
     */
    public void info(final @NotNull String msg) {
        this.logger.info(Utils.forMessageToRGB(msg));
    }

    /**
     * 紀錄警告訊息
     *
     * @param msg 訊息
     */
    public void warning(final @NotNull String msg) {
        this.logger.warning(Utils.forMessageToRGB(msg));
    }

    /**
     * 紀錄訊息
     *
     * @param level 級別
     * @param msg   訊息
     */
    public void log(final @NotNull Level level, final @NotNull String msg) {
        this.logger.log(level, Utils.forMessageToRGB(msg));
    }

    /**
     * 獲取該紀錄器插件
     *
     * @return 插件
     */
    @NotNull
    public UnikoHyperSpacePlugin getPlugin() {
        return this.plugin;
    }

}
