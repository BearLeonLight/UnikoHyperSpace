

package com.unikohyperspace.api.inventory.gui;

/**
 * 代表一個介面大小的枚舉
 * @author UnikoHyperSpace
 */
public enum InventorySize {

    ONE(9),     // 一行
    TWO(18),    // 兩行
    THREE(27),  // 三行
    FOUR(36),   // 四行
    FIVE(45),   // 五行
    SIX(54);    // 六行

    // 大小
    private final int size;

    /**
     * 建構子
     * @param size 大小
     */
    InventorySize(int size) {
        this.size = size;
    }

    /**
     * 獲取大小
     * @return 大小
     */
    public final int getSize() {
        return this.size;
    }

    /**
     * 轉換成字串類型
     * @return 字串
     */
    @Override
    public final String toString() {
        return "InventorySize{" + "size=" + size + '}';
    }

}
