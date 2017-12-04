package com.dse.reservoir.zlgl.wdzl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @Description:Json工具类
 * @Copyright: Copyright 2012 ShenZhen DSE Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @Author : jiangfl
 * @Date: 2013-12-27
 * @Version 1.0
 */
public class DseJsonUtil {

	private static Logger log = Logger.getLogger(DseJsonUtil.class);

	public static String getJsonString(String classPath) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream input = loader.getResourceAsStream(classPath);
		if (input == null) {
			System.out.println("资源不存在!" + classPath);
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = reader.readLine(); // 读取第一行
			while (line != null) { // 如果 line 为空说明读完了
				buffer.append(line); // 将读到的内容添加到 buffer 中
				line = reader.readLine(); // 读取下一行
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				reader = null;
			}
		}
		return null;
	}

	/***
	 * 将某个类属性转成Json格式字符串
	 *
	 * @param t
	 * @author jiangfl
	 */
	public static String toJsonString(Class t) {
		try {

			Object obj = t.newInstance();
			String str = JSONObject.toJSONString(obj);
			// str = str.replace("\"", "\\\"");
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 根据json字符串返回Map对象
	 *
	 * @param json
	 * @return
	 */
	public static Map<String, Object> parseToMap(String json) {
		return DseJsonUtil.toMap(DseJsonUtil.parseToJsonObject(json));
	}

//	/**
//	 * 根据json字符串返回List对象
//	 *
//	 * @param json
//	 * @return
//	 */
//	public static List<Object> parseToList(String json) {
//		return DseJsonUtil.toList(DseJsonUtil.parseToJsonArray(json));
//	}
//	/**
//	 * 根据json字符串返回数组对象
//	 *xiaoxf
//	 * @param json
//	 * @return
//	 */
//	public static Object[] parseToArray(String json) {
//		return DseJsonUtil.toArray(DseJsonUtil.parseToJsonArray(json));
//	}
//
//	/**
//	 * 获取JsonObject
//	 *
//	 * @param json
//	 * @return
//	 */
	public static JSONObject parseToJsonObject(String json) {
//		JsonParser parser = new JsonParser();
//      JsonObject jsonObj = parser.parse(json).getAsJsonObject();
        JSONObject jsonObject = JSONObject.parseObject(json);

		return jsonObject;
	}
//
//	/**
//	 * 获取JsonArray
//	 *
//	 * @param json
//	 * @return
//	 */
//	public static JsonArray parseToJsonArray(String json) {
//		JsonParser parser = new JsonParser();
//		JsonArray jsonObj = parser.parse(json).getAsJsonArray();
//		return jsonObj;
//	}
//
	/**
	 * 将JSONObjec对象转换成Map-List集合
	 *
	 * @param json
	 * @return
	 */
	private static Map<String, Object> toMap(JSONObject json) {
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		Set<Map.Entry<String, JsonElement>> entrySet = json.entrySet();
//
//		for (Iterator<Map.Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ) {
//			Map.Entry<String, JsonElement> entry = iter.next();
//			String key = entry.getKey();
//			Object value = entry.getValue();
//			if (value instanceof JsonArray) {
//				map.put(key, toList((JsonArray) value));
//			} else if (value instanceof JsonObject) {
//				map.put(key, toMap((JsonObject) value));
//			} else if (value instanceof JsonPrimitive) {
//				map.put(key, ((JsonPrimitive) value).getAsString());
//			} else {
//				map.put(key, value);
//			}
//		}
//		return map;
        HashMap<String, Object> map = new HashMap<String, Object>();
        Set<?> keys = json.keySet();
        for(Object key : keys){
            Object o = json.get(key);
            if(o instanceof JSONArray)
                map.put((String) key, reflect((JSONArray) o));
            else if(o instanceof JSONObject)
                map.put((String) key, reflect((JSONArray) o));
            else
                map.put((String) key, o);
        }
        return map;
	}

    public static Object reflect(JSONArray json){
        List<Object> list = new ArrayList<Object>();
        for(Object o : json){
            if(o instanceof JSONArray)
                list.add(reflect((JSONArray) o));
            else if(o instanceof JSONObject)
                list.add(reflect((JSONArray) o));
            else
                list.add(o);
        }
        return list;
    }

//
//	/**
//	 * 将JSONArray对象转换成List集合
//	 *
//	 * @param json
//	 * @return
//	 */
//	private static List<Object> toList(JsonArray json) {
//		List<Object> list = new ArrayList<Object>();
//		for (int i = 0; i < json.size(); i++) {
//			Object value = json.get(i);
//			if (value instanceof JsonArray) {
//				list.add(toList((JsonArray) value));
//			} else if (value instanceof JsonObject) {
//				list.add(toMap((JsonObject) value));
//			} else if (value instanceof JsonPrimitive) {
//				list.add(((JsonPrimitive) value).getAsString());
//			} else {
//				list.add(value);
//			}
//		}
//		return list;
//	}
//
//	/**
//	 * 将JSONArray对象转换成数组集合
//	 *xiaoxf
//	 * @param json
//	 * @return
//	 */
//	private static Object[] toArray(JsonArray json) {
//		Object[] array=new Object[json.size()];
//		for (int i = 0; i < json.size(); i++) {
//			Object value = json.get(i);
//			if (value instanceof JsonArray) {
//				array[i]=toArray((JsonArray) value);
//			} else if (value instanceof JsonObject) {
//				array[i]=toMap((JsonObject) value);
//			} else if (value instanceof JsonPrimitive) {
//				array[i]=((JsonPrimitive) value).getAsString();
//			} else {
//				array[i]=value;
//			}
//		}
//		return array;
//	}
//
//
	/**
	 * 将Object转化为json字符串
	 * @param obj
	 * @return
	 * @author:shaoxm
	 * @date 2016-5-8
	 */
	public static String toJson(Object obj) {
		String json = JSONObject.toJSONString(obj);
		log.info(json);
		return json;
	}
//
//	/**
//	 * 将Array List转化为json字符串
//	 * 此方法,空key不会被清除掉
//	 * @param obj
//	 * @return
//	 * @author:shaoxm
//	 * @date 2016-5-8
//	 */
//	public static String toJsonArraySf(Object obj) {
//		return JSONArray.fromObject(obj).toString();
//	}
//
//	/**
//	 * 将Array List转化为json字符串
//	 * @param obj
//	 * @return
//	 * @author:shaoxm
//	 * @date 2016-5-8
//	 */
//	public static String toJsonArray(Object obj) {
//		String json = JSONObject.toJSONString(obj);
//		log.info(json);
//		return json;
//	}
//
//	/***
//	 * 转换成json字符串
//	 *
//	 * @param page
//	 *            jfinal的page对象
//	 * @return
//	 * @time:2014-4-13
//	 * @author:jiangfl
//	 */
//	public static String toEasyuiGrid(DsePage page) {
//
//		return toEasyuiGrid(page, "yyyy-MM-dd");
//	}
//
//
//   public static String toEasyuiDzGrid(DsePage page, String Pattern) {
//		if(DseStringUtil.isEmpty(Pattern)){
//			return toEasyuiGrid(page, "yyyy-MM-dd");
//		}else{
//			return toEasyuiGrid(page, Pattern);
//		}
//
//	}
//
//	public static String toEasyuiGrid(DsePage page, String dateFormat, Object otherData) {
//		Map<String, Object> m = new HashMap<String, Object>();
//		// 总记录数
//		m.put("total", page.getTotalRecord());
//		// 查询到的数据
//		m.put("rows", page.getDataList());
//		// put("data", page.getDataList());
//		m.put("pageSize", page.getPageSize());
//		//其他数据
//		m.put("otherData",otherData);
//		String json = new GsonBuilder().setDateFormat(dateFormat).create().toJson(m).toString();
//		log.info(json);
//		return json;
//	}
//
//	/**
//	 * 采用 goole gson 进行转换
//	 *
//	 * @param page
//	 *            数据page对象
//	 * @param dateFormat
//	 *            里面的日期转化格式
//	 * @return
//	 * @author:jiangfl
//	 * @date 2015-7-21
//	 */
//	public static String toEasyuiGrid(DsePage page, String dateFormat) {
//		Map<String, Object> m = new HashMap<String, Object>();
//		// 总记录数
//		m.put("total", page.getTotalRecord());
//		// 查询到的数据
//		m.put("rows", page.getDataList());
//		// put("data", page.getDataList());
//		m.put("pageSize", page.getPageSize());
//		String json = new GsonBuilder().setDateFormat(dateFormat).create().toJson(m).toString();
//		log.info(json);
//		return json;
//	}

	public static JSONObject map2Json(Map<String,Object> map){
		JSONObject json = new JSONObject();
		Set<String> set = map.keySet();
		for (Iterator<String> it = set.iterator();it.hasNext();) {
			String key = it.next();
			json.put(key, map.get(key));
		}
		return json;
	}
}
