

package com.unikohyperspace;

import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 將一些實用應用程序定義在該類別
 * @author UnikoHyperSpace
 */
public final class Utils {

    /**
     * 將字串RGB解析成RGB物件
     * @param msg 十六進位RGB字串 (<#FF0000> Hello world !)
     * @return RGB字串
     */
    public static String forMessageToRGB(@NotNull String msg) {
        final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
        Matcher matcher = hexPattern.matcher(msg);

        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = msg.substring(0, matcher.start());
            final String after = msg.substring(matcher.end());
            msg = before + hexColor + after;
            matcher = hexPattern.matcher(msg);
        }

        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * 獲取Uniko插件集合
     * @return 插件集合
     */
    @NotNull
    public static List<UnikoHyperSpacePlugin> getMouBiePlugins() {
        final List<UnikoHyperSpacePlugin> plugins = new ArrayList<>();

        for (final Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (plugin instanceof UnikoHyperSpacePlugin unikoHyperSpacePlugin)
                plugins.add(unikoHyperSpacePlugin);
        }

        return plugins;
    }

    /**
     * 獲取Uniko插件
     * @param name 插件名稱
     * @return Uniko插件
     */
    @Nullable
    public static UnikoHyperSpacePlugin getUnikoHyperSpacePlugin(@NotNull String name) {
        final List<UnikoHyperSpacePlugin> plugins = Utils.getMouBiePlugins();

        for (final UnikoHyperSpacePlugin plugin : plugins) {
            if (plugin.getName().equalsIgnoreCase(name))
                return plugin;
        }

        return null;
    }

    /**
     * 重載Uniko的插件
     * @param name 插件名稱
     * @return 是否成功重載
     */
    public static boolean reloadUnikoHyperSpacePlugin(@NotNull String name) {
        final @Nullable UnikoHyperSpacePlugin plugin = Utils.getUnikoHyperSpacePlugin(name);
        if (plugin != null) {
            plugin.getLoader().executeReloadAction();
            return true;
        }

        return false;
    }

    /**
     * 呼叫事件並且返回事件呼叫結果
     * @param event 事件
     * @param <T> 事件類
     * @return 事件呼叫結果
     */
    @NotNull
    public static <T extends Event> T callEvent(@NotNull T event) {
        Bukkit.getPluginManager().callEvent(event);
        return event;
    }

}
