

package com.unikohyperspace.api.yaml;

/**
 * 代表一個最基礎的插件嵌入式檔案載入器介面
 * @author UnikoHyperSpace
 */
public interface PluginFileLoader
        extends FileLoader {

    /**
     * 用於將資料加載或重新加載
     */
    void reloadFile();

}
