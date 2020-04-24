package com.xls.zc.http.base;


import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;

import java.util.List;

public class XMLUtils {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(XMLUtils.class);
	private XMLUtils() {}

	/**
	 * 获取文件的xml对象，然后获取对应的根节点root
	 */
	public static String getRoot(final String xmlString, final String key) throws Exception {
		Document document = DocumentHelper.parseText(xmlString);
		final Element root = document.getRootElement();// 获取根节�?
		return getNodes(root, key);// 从根节点�?始遍历所有节�?
	}

	/**
	 * 从指定节点Element node�?�?,递归遍历其所有子节点
	 */
	@SuppressWarnings("unchecked")
	public static String getNodes(final Element node, final String key) {

		logger.info("-------�?始新节点-------------");
		// 当前节点的名称�?�文本内容和属�??
		logger.info("当前节点名称�?" + node.getName());// 当前节点名称
		logger.info("当前节点的内容：" + node.getTextTrim());// 当前节点内容
		if (key.equals(node.getName())) {
			return node.getTextTrim();
		}
		// 递归遍历当前节点�?有的子节�?
		final List<Element> listElement = node.elements();// �?有一级子节点的list
		for (final Element e : listElement) {// 遍历�?有一级子节点
			String retStr = getNodes(e, key);// 递归
			if (StringUtils.isNotBlank(retStr)) {
				return retStr;
			}
		}
		return null;
	}
}
