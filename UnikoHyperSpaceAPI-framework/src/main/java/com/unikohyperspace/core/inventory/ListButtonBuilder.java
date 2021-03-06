package com.unikohyperspace.core.inventory;

import com.unikohyperspace.api.inventory.button.ListButton;
import com.unikohyperspace.api.inventory.button.components.Content;
import com.unikohyperspace.api.inventory.button.components.Contents;
import com.unikohyperspace.api.inventory.button.event.ClickButtonEvent;
import com.unikohyperspace.api.inventory.button.event.ListButtonEvent;
import com.unikohyperspace.api.inventory.gui.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個有清單列表的按鈕建構器
 *
 * @author UnikoHyperSpace
 */
public class ListButtonBuilder
        extends ClickButtonBuilder
        implements ListButton {

    // 按鈕樣式
    @NotNull
    protected final ListButtonStyle buttonStyle = new ListButtonStyle();

    // 內容管理器
    @NotNull
    protected final Contents contents = new ContentManager();

    /**
     * 建構子
     *
     * @param gui  介面
     * @param slot 介面位置
     */
    public ListButtonBuilder(final @NotNull GUI gui, final int slot) {
        super(gui, new ItemStack(Material.ACACIA_BUTTON), slot);
        this.buttonClickType.add(ClickType.LEFT);
        this.buttonClickType.add(ClickType.RIGHT);
    }

    /**
     * 初始化按鈕
     */
    @Override
    protected void initButton() {
        this.buttonClickType.add(ClickType.LEFT);
        this.buttonClickType.add(ClickType.RIGHT);
        super.initButton();
    }

    /**
     * 選取下一個項目
     *
     * @param event 點擊事件
     */
    protected final void nextContent(final @NotNull ClickButtonEvent event) {
        this.contents.nextContent();
        // 調用選項改變事件
        this.onSelectChange(
                new ListButtonEvent(
                        event.getGUI(), event.getPlayer(), (ListButton) event.getButton(), event.getClickType()
                ));
    }

    /**
     * 選取上一個項目
     *
     * @param event 點擊事件
     */
    protected final void previousContent(final @NotNull ClickButtonEvent event) {
        this.contents.previousContent();
        // 調用選項改變事件
        this.onSelectChange(
                new ListButtonEvent(
                        event.getGUI(), event.getPlayer(), (ListButton) event.getButton(), event.getClickType()
                ));
    }

    /**
     * 當被點擊時調用
     *
     * @param event 事件
     */
    @Override
    protected final void onClick(final @NotNull ClickButtonEvent event) {
        switch (event.getClickType()) {
            case LEFT -> this.nextContent(event);
            case RIGHT -> this.previousContent(event);
        }
    }

    /**
     * 當選取項目改變時調用
     *
     * @param event 事件
     */
    protected void onSelectChange(final @NotNull ListButtonEvent event) {
    }

    /**
     * 建構物品
     * 警告：請勿再 ListButton 的建構子添加 Lore，否則會有不可預期的情況。
     * 正確做法應該是在繼承類中覆寫該方法，在該方法中添加 Lore
     * 例如：
     * {@code @Override}
     * {@code @NotNull}
     * public ItemStack build() {
     * this.lore(List.of( ... ));
     * return super.build();
     * }
     *
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        final List<String> lore = new ArrayList<>();

        final @Nullable ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null && itemMeta.getLore() != null)
            lore.addAll(itemMeta.getLore());

        for (final Content content : this.contents.getContents()) {
            lore.add(this.buttonStyle.replaceStyle(content));

            if (content.isSelected())
                this.type(content.getIcon());
        }

        this.lore(lore);
        return super.build();
    }

    /**
     * 獲取清單內容管理器
     *
     * @return 內容管理器
     */
    @NotNull
    public final Contents getButtonContents() {
        return this.contents;
    }

    /**
     * 代表清單按鈕樣式
     *
     * @author UnikoHyperSpace
     */
    protected static class ListButtonStyle {

        protected static final String CONTENT_REPLACE_STRING = "{content}";

        // 選取項目顯示樣式
        @NotNull
        public String selectItemDisplayStyle = " §f> {content}§r";

        // 未取項目顯示樣式
        @NotNull
        public String uncheckedItemDisplayStyle = " §8> {content}§r";

        /**
         * 轉換選取樣式
         *
         * @param content 內容
         * @return 樣式
         */
        public String replaceStyle(final @NotNull Content content) {
            final String msg = content.toString();

            return content.isSelected() ?
                    this.selectItemDisplayStyle.replace(ListButtonStyle.CONTENT_REPLACE_STRING, msg) :
                    this.uncheckedItemDisplayStyle.replace(ListButtonStyle.CONTENT_REPLACE_STRING, msg);
        }
    }

}
