package com.xls.zc.http.base;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**



 *
 * 序列化操作类
 *
 * @author dqw
 * Created 2017/4/17 13:39
 */
public class SerializeHelper {

    private static final Logger logger = Logger.getLogger(SerializeHelper.class);

    public static Object deserialize(byte[] bytes) {

        Object result = null;

        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
            result = objectInputStream.readObject();
        } catch (Exception e) {
            logger.error("Deserialize Error:" + e.toString());
        }
        return result;
    }

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {

       byte[] result = null;

        if (object == null) {
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            result = byteStream.toByteArray();
        } catch (Exception e) {
            logger.error("Serialize Error:" + e.toString());
        }
        return result;
    }
}
