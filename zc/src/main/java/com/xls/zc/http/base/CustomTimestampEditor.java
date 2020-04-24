package com.xls.zc.http.base;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @copyright
 * @license    
 * @link       
 *
 * 过滤时间参数类
 * 
 * @author zxy
 * Created 2017/4/13 11:06
 */
public class CustomTimestampEditor extends PropertyEditorSupport {

    private final boolean allowEmpty;

    public CustomTimestampEditor(boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

    /**
     * 处理过滤值
     * @param text
     * @throws IllegalArgumentException
     */
    public void setAsText(String text) throws IllegalArgumentException {
        if ((this.allowEmpty) && (!(StringUtils.hasText(text)))) {
            setValue(null);
        } else {
            try {
                if (text.length()==10) {
                    SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd");
                    datetimeFormat.setLenient(false);
                    setValue(new Timestamp(datetimeFormat.parse(text).getTime()));
                }else if (text.length()==19){
                    SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    datetimeFormat.setLenient(false);
                    setValue(new Timestamp(datetimeFormat.parse(text).getTime()));
                }else{
                    setValue(null);
                }
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

    /*public String getAsText() {
        Timestamp value = (Timestamp) getValue();
        return ((value != null) ? this.dateFormat.format(value) : "");
    }*/
}