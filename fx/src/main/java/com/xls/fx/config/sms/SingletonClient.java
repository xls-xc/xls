package com.xls.fx.config.sms;

import com.xls.fx.config.WorkerConfig;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config.sms
 * @ClassName: SingletonClient
 * @Description: 单例连接对象
 * @Author: SkyChen
 * @Create: 2020-04-13 17:02
 * @Version: v1.0
 **/
public class SingletonClient {
    /**
     * 定义空的连接对象
     */
    private static Client client=null;

    /**
     * 无参构造函数
     */
    private SingletonClient(){}

    /**
     * 有参静态同步连接对象
     * @param softwareSerialNo  原件序列号
     * @param key key值
     * @return
     */
    public synchronized static Client getClient(String softwareSerialNo, String key){
        if(client==null){
            try {
                client=new Client(softwareSerialNo,key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    /**
     * 无参静态同步连接对象
     * @return
     */
    public synchronized static Client getClient(){
        if(client==null){
            try {
                client=new Client(WorkerConfig.getEmaySoftwareSerialNo(),WorkerConfig.getEmayKey());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
