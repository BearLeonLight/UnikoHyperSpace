

package com.unikohyperspace.api.builder;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * 代表一個物品的建構介面
 * @author UnikoHyperSpace
 */
public interface ItemBuilder
        extends Builder<ItemStack> {

    /**
     * 設定物品類型
     * @param material 材質
     * @return 當前的建構器
     */
    @NotNull ItemBuilder type(@NotNull Material material);

    /**
     * 設定數量
     * @param amount 數量
     * @return 當前的建構器
     */
    @NotNull ItemBuilder amount(int amount);

    /**
     * 添加附魔
     * @param enchantment 附魔
     * @param level 水平
     * @return 當前的建構器
     */
    @NotNull ItemBuilder enchantment(@NotNull Enchantment enchantment, int level);

    /**
     * 集體附魔
     * @param enchantments 附魔集合
     * @return 當前的建構器
     */
    @NotNull ItemBuilder enchantments(@NotNull Map<Enchantment, Integer> enchantments);

    /**
     * 刪除一個附魔
     * @param enchantment 附魔
     * @return 當前的建構器
     */
    @NotNull ItemBuilder removeEnchantments(@NotNull Enchantment enchantment);

    /**
     * 設定本地化名稱
     * @param name 名稱
     * @return 當前的建構器
     */
    @NotNull ItemBuilder localizedName(@NotNull String name);

    /**
     * 物品是否為不可破壞
     * @param unbreakable 是或否
     * @return 當前的建構器
     */
    @NotNull ItemBuilder unbreakable(boolean unbreakable);

    /**
     * 沒有說明 (尚未之用途)
     * @param data ?
     * @return 當前的建構器
     */
    @NotNull ItemBuilder customModelData(int data);

    /**
     * 沒有說明 (尚未之用途)
     * @param attribute ?
     * @param attributeModifier ?
     * @return 當前的建構器
     */
    @NotNull ItemBuilder attributeModifier(@NotNull Attribute attribute, @NotNull AttributeModifier attributeModifier);

    /**
     * 設定物品的標題名稱
     * @param title 名稱
     * @return 當前的建構器
     */
    @NotNull ItemBuilder displayName(@NotNull String title);

    /**
     * 設定物品的敘述說明
     * @param lore 敘述
     * @return 當前的建構器
     */
    @NotNull ItemBuilder lore(@NotNull List<String> lore);

    /**
     * 對物品添加一些特殊標籤
     * @param itemFlag 標籤
     * @return 當前的建構器
     */
    @NotNull ItemBuilder flags(@NotNull ItemFlag... itemFlag);

    /**
     * 對物品刪除特殊標籤
     * @param itemFlag 標籤
     * @return 當前的建構器
     */
    @NotNull ItemBuilder removeFlags(@NotNull ItemFlag... itemFlag);

    /**
     * 將頭顱的 SKIN 換成某位玩家的頭顱 (該物品必須為 PLAYER_HEAD 才可生效)
     * @param player 玩家
     * @return 當前的建構器
     */
    @NotNull ItemBuilder skullMeta(@NotNull OfflinePlayer player);

}
