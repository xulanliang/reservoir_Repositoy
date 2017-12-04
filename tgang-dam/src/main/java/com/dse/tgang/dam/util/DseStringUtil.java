package com.dse.tgang.dam.util;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DseStringUtil extends StringUtils {

	public static boolean notEmpty(Object o) {
		return o != null && !o.toString().trim().equals("");
	}

	public static boolean empty(Object o) {
		return o == null || o.toString().trim().equals("");
	}

	/******
	 * 使用split连接count个c字符,返回连接后的字符串
	 * 
	 * @param c
	 *            字符
	 * @param split 分隔符
	 * @param count 个数
	 * @return 返回字符串
	 * @author jiangfl
	 */
	public static String getJoinSplitChar(String c, String split, Integer count) {
		String[] chars = new String[count];
		for (int i = 0; i < count; i++) {
			chars[i] = c;
		}
		return join(chars, split);
	}

	/***
	 * 把字符串str根据split字符分割，然后返回对应的cls类型数据
	 * 
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @param cls
	 *            被分割后的值的类型
	 * @return
	 * @author jiangfl
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object[] split(String str, String split, Class cls) {
		if (str != null) {
			try {
				Object[] splits = str.split(split);
				// 如果是字符串
				if (cls != String.class) {
					Object result[] = new Object[splits.length];
					Constructor constructor;
					constructor = cls.getConstructor(String.class);
					for (int i = 0; i < splits.length; i++) {
						result[i] = constructor.newInstance(splits[i]);
					}
					return result;
				} else {
					return splits;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/***
	 * 将数组 array 使用 split连接 成 字符串
	 * 
	 * @param array
	 * @param split
	 * @return
	 * @author jiangfl
	 */
	public static String join(Object[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for (Object o : array) {
			sb.append(o).append(split);
		}
		if (sb.length() > 1) {
			return sb.substring(0, sb.length() - 1);
		}
		return null;
	}

	/***
	 * 将数组 array 的内容添加到集合list中去
	 * 
	 * @param list
	 * @param array
	 * @author jiangfl
	 */
	public static void listAddArray(List<Object> list, Object array[]) {
		for (Object obj : array) {
			list.add(obj);
		}
	}

	/**
	 * 传入 val值 这个值于list对象中的model(或者Map)实体的field属性相比较 看是否已经存在
	 * 
	 * @param list
	 *            list集合保存的是model实体(或者Map)
	 * @param field
	 *            model实体的某字段
	 * @param val
	 *            值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean exists(List list, String field, Object val)
			throws Exception {
		Method m = null;
		Object result = null;
		Map map = null;
		for (Object o : list) {
			try {
				if (o instanceof Map) {
					map = (Map) o;
					result = map.get(field);
				} else {
					if (!field.startsWith("get")) {
						field = "get" + field.substring(0, 1).toUpperCase()
								+ field.substring(1);
					}
					m = o.getClass().getMethod(field);
					result = m.invoke(o);
				}
				if (result == null && val == null) {
					return true;
				}
				if (result == null || val == null) {
					continue;
				}
				if (val.toString().equals(result.toString())) {
					return true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;

			}
		}
		return false;
	}

	

	/**
	 * html特殊字符，转义
	 * 
	 * @param str
	 * @return
	 * @author jiangfl
	 */
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	/**
	 * 替换sql参数中的一些特殊字符，如"'",";"等
	 * 
	 * @param sql
	 *            native sql string
	 * @return escaped sql string
	 */
	public static String escapeSQL(String sql) {
		if (sql == null || sql.trim().length() == 0) {
			return "";
		} else {
			return sql.replaceAll("([';]+|(--)+)", "");
		}
	}

	/**
	 * 判断sql参数中的是否有特殊字符
	 * 
	 * @param sql
	 * @return 布尔值
	 */
	public static boolean escapeSQLByHint(String sql) {
		if (sql == null || sql.trim().length() == 0) {
			return false;
		} else {
			String temp = sql;
			return !temp.equals(sql.replaceAll("([';]+|(--)+)", ""));
		}
	}

	/**
	 * 字符串空值处理
	 * 
	 * @param str
	 *            String
	 * @param defaultValue
	 *            String
	 * @return String
	 */
	public static String getString(String str, String defaultValue) {
		if (str == null || str.equals("")) {
			str = defaultValue;
		}
		return str.trim();
	}

	/**
	 * 转换成UTF-8编码
	 * 
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0) {
						k += 256;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否有汉字
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isChinese(String str) {
		if (str.getBytes().length == str.length()) {
			return false;
		}
		return true;
	}

	/**
	 * 匹配字符串
	 * 
	 * @param initStr
	 *            原始字符串
	 * @param matchStr
	 *            匹配的字符串, 即规则
	 * @return boolean false为不存在, true为存在.
	 */
	public static boolean matchString(String initStr, String matchStr) {
		try {
			Pattern p = Pattern.compile(matchStr);
			Matcher m = p.matcher(initStr);
			boolean result = m.find();
			return result;
		} catch (Exception e) {
			return false;
		}
	}


}
