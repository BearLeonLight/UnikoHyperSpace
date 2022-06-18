

package com.unikohyperspace.api.plugin;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * 代表一個插件紀錄器
 * @author UnikoHyperSpace
 */
public interface PluginDebugger {

    /**
     * 紀錄資訊訊息
     * @param msg 訊息
     */
    void info(@NotNull String msg);

    /**
     * 紀錄警告訊息
     * @param msg 訊息
     */
    void warning(@NotNull String msg);

    /**
     * 紀錄訊息
     * @param level 級別
     * @param msg 訊息
     */
    void log(@NotNull Level level, @NotNull String msg);

}
