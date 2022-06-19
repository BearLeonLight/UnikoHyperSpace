package com.unikohyperspace.core.inventory;

import com.unikohyperspace.api.builder.ItemNBTBuilder;
import com.unikohyperspace.api.inventory.button.Button;
import com.unikohyperspace.api.inventory.gui.GUI;
import com.unikohyperspace.core.itemstack.ItemStackBuilder;
import com.unikohyperspace.core.nbttag.ItemStackNBTTagBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * 代表一個介面按鈕類別
 *
 * @author UnikoHyperSpace
 */
public abstract class ButtonBuilder
        extends ItemStackBuilder
        implements Button {

    @NotNull
    private static final String MOU_BIE_API_BUTTON_TAG = "mou_bie_api_button_tag";

    @NotNull
    private static final String BUTTON_UUID = "button_uuid_tag";

    // 按鈕UUID
    @NotNull
    protected final UUID buttonUUID = UUID.randomUUID();

    // 所屬介面
    @NotNull
    protected final GUI handler;

    // 介面位置
    protected int buttonSlot;

    /**
     * 建構子
     *
     * @param material 材質
     * @param slot     介面位置
     */
    public ButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int slot) {
        this(gui, material, 1, slot);
    }

    /**
     * 建構子
     *
     * @param material 材質
     * @param amount   數量
     * @param slot     介面位置
     */
    public ButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int amount, final int slot) {
        this(gui, new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     *
     * @param itemStack 物品實例
     * @param slot      介面位置
     */
    public ButtonBuilder(final @NotNull GUI gui, final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack);
        this.handler = gui;
        this.buttonSlot = slot;
        this.initButton();
    }

    /**
     * 獲取按鈕UUID
     *
     * @param itemStack 物品
     * @return UUID
     */
    @Nullable
    public static UUID getButtonId(final @Nullable ItemStack itemStack) {
        if (itemStack == null)
            return null;

        final String uuidString =
                ItemStackNBTTagBuilder.getString(itemStack, ButtonBuilder.MOU_BIE_API_BUTTON_TAG, ButtonBuilder.BUTTON_UUID);

        return uuidString.length() == 36 ? UUID.fromString(uuidString) : null;
    }

    /**
     * 獲取屬於按鈕的介面
     *
     * @return 介面
     */
    @NotNull
    public final GUI getHandler() {
        return this.handler;
    }

    /**
     * 獲取按鈕UUID
     *
     * @return UUID
     */
    @NotNull
    public final UUID getButtonUUID() {
        return this.buttonUUID;
    }

    /**
     * 獲取物品在介面上的位置
     *
     * @return 位置
     */
    public final int getButtonSlot() {
        return this.buttonSlot;
    }

    /**
     * 初始化按鈕
     */
    protected abstract void initButton();

    /**
     * 建構函數
     *
     * @return 對象
     */
    @Override
    @NotNull
    public ItemStack build() {
        // 寫入按鈕UUID
        final ItemNBTBuilder nbtBuilder = new ItemStackNBTTagBuilder(this.itemStack, ButtonBuilder.MOU_BIE_API_BUTTON_TAG);
        this.itemStack = nbtBuilder
                .setString(ButtonBuilder.BUTTON_UUID, this.buttonUUID.toString())
                .build();

        return super.build();
    }

}
