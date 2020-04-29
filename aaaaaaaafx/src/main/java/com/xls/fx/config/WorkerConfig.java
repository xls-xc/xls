package com.xls.fx.config;

/**



 *
 * 亿美参数
 * 
 * @author 
 * Created 2017/4/13 14:26
 */
public class WorkerConfig {
    private static String emayUri;
    private static String emaySoftwareSerialNo;
    private static String emayKey;
    private static String searchDictPath;

    public static String getEmayUri() {
        return emayUri;
    }

    public static void setEmayUri(String emayUri) {
        WorkerConfig.emayUri = emayUri;
    }

    public static String getEmaySoftwareSerialNo() {
        return emaySoftwareSerialNo;
    }

    public static void setEmaySoftwareSerialNo(String emaySoftwareSerialNo) {
        WorkerConfig.emaySoftwareSerialNo = emaySoftwareSerialNo;
    }

    public static String getEmayKey() {
        return emayKey;
    }

    public static void setEmayKey(String emayKey) {
        WorkerConfig.emayKey = emayKey;
    }

    public static String getSearchDictPath() {
        return searchDictPath;
    }

    public static void setSearchDictPath(String searchDictPath) {
        WorkerConfig.searchDictPath = searchDictPath;
    }
}
