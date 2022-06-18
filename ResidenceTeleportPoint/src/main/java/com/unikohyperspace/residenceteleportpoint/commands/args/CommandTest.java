
package com.unikohyperspace.residenceteleportpoint.commands.args;

import com.unikohyperspace.api.commands.SenderType;
import com.unikohyperspace.core.commands.SubcommandAbstract;
import com.unikohyperspace.residenceteleportpoint.PlayerData;
import com.unikohyperspace.residenceteleportpoint.ResidenceTeleportPoint;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表插件的重讀指令
 */
public final class CommandTest
        extends SubcommandAbstract {

    /**
     * 建構子
     * @param name        子指令名
     * @param permission  指令權限
     * @param type        指令發送者
     * @param description 指令說明
     */
    public CommandTest(final @NotNull String name, final @Nullable Permission permission, final @NotNull SenderType type, final @NotNull String description) {
        super(name, permission, type, description);
    }

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    public boolean onCmd(final @NotNull CommandSender sender, final @NotNull String[] args) {

        if (args.length == 2) {
            PlayerData playerData = new PlayerData();
            try {
                switch (args[1]){
                    case "1":

                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            playerData.savePlayerData(player);
                            break;
                        }
                    case "2":
                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            playerData.getPlayerData(player);
                            break;
                        }
                        break;
                    case "3":
                        break;
                    default:
                        sender.sendMessage(ResidenceTeleportPoint.PLUGIN_TITLE + "§2執行測試編號 §6" + args[1] + " §2不存在！");
                        return false;
                }
                sender.sendMessage(ResidenceTeleportPoint.PLUGIN_TITLE + "§2執行測試編號 §6" + args[1] + " §2完成！");
                return true;
            }catch (Exception e){
                sender.sendMessage(ResidenceTeleportPoint.PLUGIN_TITLE + "§2執行測試編號 §6" + args[1] + " §2錯誤！");
                return false;

            }



        }
        sender.sendMessage(ResidenceTeleportPoint.PLUGIN_TITLE + "§2請輸入要執行的測試編號");
        return true;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final List<String> list = new ArrayList<>();

        if (args.length == 2) {
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
        }

        return list;
    }

}
