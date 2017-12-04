package com.dse.reservoir.zlgl.wdzl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class DseLoadConfig extends Properties {
	private static final long serialVersionUID = 1L;
	private static Map<String, Properties> map = new HashMap<String, Properties>();
	private static Properties props = null;

	/*
	 * 根据key获取默认文件postgres.properties的key	
	 */
	public static Object getValueByKey(String key) {
		props = map.get(DseConstants.DEFAULT_FILE_NAME);
		if (props == null) {
			new DseLoadConfig().loadFile(DseConstants.DEFAULT_FILE_NAME);
			props = map.get(DseConstants.DEFAULT_FILE_NAME);
		}
		return props.get(key);
	}

	public static String getValueByKeyToString(String key) {
		Object obj = getValueByKey(key);
		return DseStringUtil.notEmpty(obj) ? obj.toString() : null;
	}
	
	/*
	 * 根据key获取默认文件fileName的key
	 */
	public static Object getValueByKey(String key, String fileName) {
		props = map.get(fileName);
		if (props == null) {
			new DseLoadConfig().loadFile(fileName);
			props = map.get(fileName);
		}
		return props.get(key);
	}

	/*
	 * 装载文件到properties对象中去，并存放在键值对象中
	 */
	private void loadFile(String filename) {
		props = new Properties();

		try {
			InputStream stream = DseLoadConfig.class.getClassLoader().getResourceAsStream(filename);
			//InputStream stream = DseLoadConfig.class.getClassLoader().getResource(filename).openStream();
			
			props.load(stream);
			map.put(filename, props);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件加载出错!" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出异常了");
		}
	}

	public static void main(String[] args) {
		//System.out.println(DseLoadConfig.getValueByKey("uploadDir"));
	}

}
