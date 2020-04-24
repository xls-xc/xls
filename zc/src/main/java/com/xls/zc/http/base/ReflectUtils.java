package com.xls.zc.http.base;

//import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils {
	/**
	 * map转对象
	 * 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}
		return obj;
	}

	/**
	 * 对象转map
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}

	/**
	 * map转对象
	 *
	 * @param map
	 * @param T
	 * @return
	 * @throws Exception
	 */
	public static <T> T convertMapBean(Map map, Class T) throws Exception {
		if (map == null || map.size() == 0) {
			return null;
		}
		BeanInfo beanInfo = Introspector.getBeanInfo(T);
		T bean = (T) T.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			String upperPropertyName = propertyName.toUpperCase();
			if (map.containsKey(upperPropertyName)) {
				Object value = map.get(upperPropertyName);
				//BeanUtils.copyProperty(bean, propertyName, value);
			}
		}
		return bean;
	}
}
