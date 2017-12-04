package com.dse.reservoir.zlgl.wdzl.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;


/**
 * 一个将map对象的属性复制到某个对象中去的工具类
 * 
 * @author jiangfulong
 * 
 */
public class DseBeanUtils {
	
	/**
	 * 拷贝属性，将源req参数的属性值，拷贝到t对象中属性中去,为了性能不负责进行内置对象数据的拷贝
	 * 
	 * @param req
	 *            源
	 * @param obj
	 *            目标
	 * @param args
	 *            忽略拷贝的字段名称
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static void copyProperties(HttpServletRequest req, Object t, String... args) {
		Class cls = t.getClass();
		Field fields[] = cls.getDeclaredFields();
		String fullName = null;
		String shortName = null;
		Method method = null;
		Object sourceValue = null;
		Object params[] = null;
		Map reqMap = req.getParameterMap();
		for (Field f : fields) {
			try {
				shortName = f.getName();
				// 当前字段是否忽略
				if (ignore(args, shortName)) {
					continue;
				}
				// 如果在map中没有包含该属性键，则跳过，不进行复制
				if (!reqMap.containsKey(shortName)) {
					continue;
				}
				sourceValue = req.getParameter(shortName);
				params = getClass(f.getType(), sourceValue);
				if (params[0] != null) {// params[0]为null的话，说明该属性为对象属性，忽略注入
					fullName = "set" + DseStringUtil.capitalize(shortName);
					method = cls.getDeclaredMethod(fullName, (Class) params[0]);
					method.invoke(t, params[1]);
				}
			} catch (Exception e) {
				if (params[1] == null) {
					System.out.println(shortName + "参数注入出错!请确保" + shortName + "参数为封装数据类型,否则无法将null注入到值类型变量中!");
				}
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将源对象source中的属性拷贝到目标对象target中，为了性能不负责进行内置对象数据的拷贝
	 * 
	 * @param source
	 * @param target
	 * @param args
	 *            忽略拷贝的字段名称
	 * @author jiangfl
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static void copyProperties(Object source, Object target, String... args) {
		Class cls = target.getClass();
		Field fields[] = cls.getDeclaredFields();
		String fullName = null;
		String shortName = null;
		Method method = null;
		Object sourceValue = null;
		Object params[] = null;

		Class sourceCls = source.getClass();

		for (Field f : fields) {
			try {
				shortName = f.getName();
				// 当前字段是否忽略
				if (ignore(args, shortName)) {
					continue;
				}

				// 如果在map中没有包含该属性键，则跳过，不进行复制
				if (sourceCls.getDeclaredField(shortName) == null) {
					continue;
				}
				method = sourceCls.getDeclaredMethod("get" + DseStringUtil.capitalize(shortName));
				sourceValue = method.invoke(source);

				params = getClass(f.getType(), sourceValue);
				if (params[0] != null) {// params[0]为null的话，说明该属性为对象属性，忽略注入
					fullName = "set" + DseStringUtil.capitalize(shortName);
					method = cls.getDeclaredMethod(fullName, (Class) params[0]);
					method.invoke(target, params[1]);
				}
			} catch (Exception e) {
				if (params[1] == null) {
					System.out.println(shortName + "参数注入出错!请确保" + shortName + "参数为封装数据类型,否则无法将null注入到值类型变量中!");
				}
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 拷贝属性，将源map里面的属性值，拷贝到obj对象中属性中去,为了性能不负责进行内置对象数据的拷贝
	 * 
	 * @param map
	 *            源
	 * @param obj
	 *            目标
	 * @param upperCase
	 *            是否转换成大写
	 * @param args
	 *            忽略拷贝的字段名称
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void copyProperties(Map map, Object t, boolean upperCase, String... args) {
		Class cls = t.getClass();
		Field fields[] = cls.getDeclaredFields();
		String fullName = null;
		String shortName = null;
		Method method = null;
		Object sourceValue = null;
		Object params[] = null;

		for (Field f : fields) {
			try {
				shortName = f.getName();
				// 当前字段是否忽略
				if (ignore(args, upperCase ? shortName.toUpperCase() : shortName)) {
					continue;
				}
				// 如果在map中没有包含该属性键，则跳过，不进行复制
				if (!map.containsKey(upperCase ? shortName.toUpperCase() : shortName)) {
					continue;
				}
				sourceValue = map.get(upperCase ? shortName.toUpperCase() : shortName);

				params = getClass(f.getType(), sourceValue);
				if (params[0] != null) {// params[0]为null的话，说明该属性为对象属性，忽略注入
					fullName = "set" + DseStringUtil.capitalize(shortName);
					params = getClass(f.getType(), sourceValue);
					method = cls.getDeclaredMethod(fullName, (Class) params[0]);
					method.invoke(t, params[1]);
				}

			} catch (Exception e) {
				if (params[1] == null) {
					System.out.println(shortName + "参数注入出错!请确保" + shortName + "参数为封装数据类型,否则无法将null注入到值类型变量中!");
				}
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 如果查询的结果集为一个List对象，且list对象保存的值不是实体， 则在flex页面取值时通过索引取值 如data[0]，这样很不利于开发
	 * 如果需求一变，需要增加字段，则索引可能整体会发生变化，这里保存为Map对象 这样在flex里面就可以通过key去取值如 data.id
	 * 
	 * @param list
	 * @param keys
	 */
	public static List<Map<String, Object>> listFillMap(List<Object[]> list, String... keys) {
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
		if (list.size() == 0) {
			System.out.println("数据为0条记录");
			return newList;
		}

		if (keys.length != list.get(0).length) {
			System.out.println("键的个数不匹配子集合List<Object> 的个数，无法一一将数据和key对应");
			return newList;
		}

		Map<String, Object> map = null;
		for (Object[] array : list) {

			map = new HashMap<String, Object>();
			for (int i = 0; i < array.length; i++) {
				map.put(keys[i], array[i]);
			}
			newList.add(map);
		}

		return newList;

	}

	/**
	 * 拷贝属性，将源map里面的属性值，拷贝到obj对象中属性中去
	 * 
	 * @param map
	 *            源
	 * @param obj
	 *            目标
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void copyProperties(Map map, Object t, String... args) {

		Class cls = t.getClass();
		Field fields[] = cls.getDeclaredFields();
		String fullName = null;
		String shortName = null;
		Method method = null;
		Object sourceValue = null;
		Object params[] = null;

		for (Field f : fields) {
			try {
				shortName = f.getName();
				// 当前字段是否忽略
				if (ignore(args, shortName)) {
					continue;
				}
				sourceValue = map.get(shortName);

				String tempName = shortName;
				if (sourceValue == null) {
					tempName = shortName.toUpperCase();
					sourceValue = map.get(tempName);

				}
				if (sourceValue == null) {
					tempName = shortName.toLowerCase();
					sourceValue = map.get(tempName);
				}

				// 如果在map中没有包含该属性键，则跳过，不进行复制
				if (!map.containsKey(tempName)) {
					continue;
				}

				fullName = "set" + shortName.substring(0, 1).toUpperCase() + shortName.substring(1);

				params = getClass(f.getType(), sourceValue);
				// 如果值不等于null,则不注入
				//if (params[1] != null) { 2013-10-18  zouwei xiaoxiangfeng  
					method = cls.getMethod(fullName, (Class) params[0]);
					method.invoke(t, params[1]);
				//}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 忽略字段
	 * 
	 * @param args
	 * @param item
	 * @return
	 */
	private static boolean ignore(String args[], String item) {
		for (String o : args) {
			if (item.equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param type
	 * @param data
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object[] getClass(Class type, Object data) throws Exception {
		Object obj[] = new Object[] { null, null };
		try {

			if (Byte.class == type) {
				obj[0] = Byte.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Byte.valueOf(data.toString());
				}
				return obj;
			} else if (byte.class == type) {
				obj[0] = byte.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Byte.parseByte(data.toString());
				}
				return obj;
			} else if (Short.class == type) {
				obj[0] = Short.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Short.valueOf(data.toString());
				}
				return obj;
			} else if (short.class == type) {
				obj[0] = short.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Short.parseShort(data.toString());
				} else {
					obj[1] = 0;
				}
				return obj;
			} else if (Integer.class == type) {
				obj[0] = Integer.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Integer.valueOf(data.toString());
				}
				return obj;
			} else if (int.class == type) {
				obj[0] = int.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Integer.parseInt(data.toString());
				} else {
					obj[1] = 0;
				}
				return obj;
			} else if (Float.class == type) {
				obj[0] = Float.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Float.valueOf(data.toString());
				}
				return obj;
			} else if (float.class == type) {
				obj[0] = float.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Float.parseFloat(data.toString());
				} else {
					obj[1] = 0;
				}
				return obj;
			} else if (Double.class == type) {
				obj[0] = Double.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Double.valueOf(data.toString());
				}
				return obj;
			} else if (double.class == type) {
				obj[0] = double.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Double.parseDouble(data.toString());
				} else {
					obj[1] = 0;
				}
				return obj;
			} else if (String.class == type) {
				obj[0] = String.class;
				if (data != null) {
					obj[1] = String.valueOf(data.toString());
				}
				return obj;
			} else if (Long.class == type) {
				obj[0] = Long.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Long.valueOf(data.toString());
				}
				return obj;
			} else if (long.class == type) {
				obj[0] = long.class;
				if (DseStringUtil.notEmpty(data)) {
					obj[1] = Long.parseLong(data.toString());
				} else {
					obj[1] = 0;
				}
				return obj;
			} else if (Date.class == type) {
				obj[0] = Date.class;
				if (data != null) {
					if (data.getClass() == Date.class || java.sql.Date.class == data.getClass()) {
						obj[1] = (Date) data;
					} else if (data.getClass() == String.class) {
						obj[1] = DseDateUtil.getDate(data.toString());
					}
				}
				return obj;
			} else if (Timestamp.class == type) {
				obj[0] = Timestamp.class;
				if (data != null) {
					if (data.getClass() == Date.class) {
						obj[1] = DseDateUtil.getTimestamp((Date) data);
					} else if (data.getClass() == String.class) {
						obj[1] = DseDateUtil.getTimestamp(data.toString());
					} else if (data.getClass() == Timestamp.class) {
						obj[1] = (Timestamp) data;
					}
				}
				return obj;
			}

		} catch (Exception e) {
			System.err.println("注入属性类型" + type + "值为：" + data + "出错");
			e.printStackTrace();
			throw e;
		}
		return obj;
	}

	/**
	 * 
	 * @param cls
	 *            类 class
	 * @param alias
	 *            别名
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getFieldsAsAlias(Class cls, String alias) {
		String str = "";
		Field fields[] = cls.getDeclaredFields();
		for (Field f : fields) {
			if (DseStringUtil.notEmpty(alias)) {
				str += alias + "." + f.getName() + " as " + f.getName() + ",";
			} else {
				str += f.getName() + " as " + f.getName() + ",";
			}
		}
		if (str.length() != 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * 
	 * @param cls
	 *            类 class
	 * @param alias
	 *            别名
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getFields(Class cls, String alias) {
		String str = "";
		Field fields[] = cls.getDeclaredFields();
		for (Field f : fields) {
			if (DseStringUtil.notEmpty(alias)) {
				str += alias + "." + f.getName() + ",";
			} else {
				str += f.getName() + ",";
			}
		}
		if (str.length() != 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	/**
	 * 将源对象中的属性值拷贝至目标MAP对象,只拷贝基本数据类型.
	 * 
	 * @param map
	 *            目标对象.
	 * @param origObj
	 *            源对象.
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("unchecked")
	public static void copyPropertiesToMap(Map<String, Object> map, Object origObj, String... args) throws NoSuchFieldException {

		Class cls = origObj.getClass();
		Field fields[] = cls.getDeclaredFields();
		String shortName = null;
		Object sourceValue = null;
		Object params[] = null;
		for (Field f : fields) {
			try {
				shortName = f.getName();
				// 当前字段是否忽略
				if (ignore(args, shortName)) {
					continue;
				}
				sourceValue = forceGetProperty(origObj, shortName);

				params = getClass(f.getType(), null);
				// 如果值不等于null,则不注入
				if (params[0] != null) {
					map.put(shortName, sourceValue);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Object forceGetProperty(Object object, String propertyName) throws NoSuchFieldException {
		Field field = object.getClass().getDeclaredField(propertyName);

		boolean accessible = field.isAccessible();
		field.setAccessible(true);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		field.setAccessible(accessible);
		return result;
	}
	public static void main(String[] args) {
		// System.out.println(BeanUtils.getFields(WrHdzdxzbB.class,""));

	}
}
