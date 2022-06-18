

package com.unikohyperspace.core.plugin;

import com.unikohyperspace.Utils;
import com.unikohyperspace.api.event.UnikoHyperSpacePluginDisableEvent;
import com.unikohyperspace.api.event.UnikoHyperSpacePluginEnableEvent;
import com.unikohyperspace.api.event.UnikoHyperSpacePluginReloadEvent;
import com.unikohyperspace.api.plugin.UnikoHyperSpacePlugin;
import com.unikohyperspace.api.plugin.PluginLoader;
import com.unikohyperspace.api.plugin.PluginRegister;
import com.unikohyperspace.core.reflect.CraftBukkitReflect;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 用於將Uniko插件加載的載入器
 * @author UnikoHyperSpace
 */
public final class UnikoHyperSpacePluginLoader
        implements PluginLoader {

    // 插件
    @NotNull
    private final UnikoHyperSpacePlugin plugin;

    // 運行操作管理器
    @NotNull
    private final Map<PluginRegister.ActionType, List<Method>> actionMethods = new LinkedHashMap<>();

    /**
     * 建構子
     * @param plugin 插件
     */
    public UnikoHyperSpacePluginLoader(final @NotNull UnikoHyperSpacePlugin plugin) {
        this.plugin = plugin;

        // 初始化一些東西.. ? (排序優先順序、添加動作至集合)
        this.sortedExecute(PluginRegister.ActionType.ACTION_LOAD);
        this.sortedExecute(PluginRegister.ActionType.ACTION_ENABLE);
        this.sortedExecute(PluginRegister.ActionType.ACTION_DISABLE);
        this.sortedExecute(PluginRegister.ActionType.ACTION_RELOAD);
    }

    /**
     * 執行加載插件動作
     */
    public void executeLoadAction() {
        this.execute(PluginRegister.ActionType.ACTION_LOAD);
    }

    /**
     * 執行啟用插件動作
     */
    public void executeEnableAction() {
        this.execute(PluginRegister.ActionType.ACTION_ENABLE);
        Utils.callEvent(new UnikoHyperSpacePluginEnableEvent(this.plugin));
    }

    /**
     * 執行關閉插件動作
     */
    public void executeDisableAction() {
        this.execute(PluginRegister.ActionType.ACTION_DISABLE);
        Utils.callEvent(new UnikoHyperSpacePluginDisableEvent(this.plugin));
    }

    /**
     * 執行重載插件動作
     */
    public void executeReloadAction() {
        this.execute(PluginRegister.ActionType.ACTION_RELOAD);
        Utils.callEvent(new UnikoHyperSpacePluginReloadEvent(this.plugin));
    }

    /**
     * 調用一個插件註冊動作方法
     * @param actionType 動作類型
     */
    private void execute(final @NotNull PluginRegister.ActionType actionType) {
        final List<Method> methods = this.actionMethods.get(actionType);

        if (methods != null)
            for (final Method method : methods)
                CraftBukkitReflect.invoke(method, this.plugin);
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param actionType 動作類型
     */
    private void sortedExecute(final @NotNull PluginRegister.ActionType actionType) {
        final List<Method> methods = new LinkedList<>();

        // 查找有關 Register.class 的類方法並且判斷方法示標動作類型
        for (final Method method : this.plugin.getClass().getDeclaredMethods())
            if (method.isAnnotationPresent(PluginRegister.class) && method.getAnnotation(PluginRegister.class).type().equals(actionType))
                methods.add(method);

        if (methods.size() > 1) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(PluginRegister.class).priority())
            ).toList();

            // 添加
            this.actionMethods.put(actionType, sortedMethods);
        }
    }

    /**
     * 獲取該紀錄器插件
     * @return 插件
     */
    @NotNull
    public UnikoHyperSpacePlugin getPlugin() {
        return this.plugin;
    }

}
