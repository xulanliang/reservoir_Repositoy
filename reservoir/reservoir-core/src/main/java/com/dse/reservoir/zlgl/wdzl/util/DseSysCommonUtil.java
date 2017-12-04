package com.dse.reservoir.zlgl.wdzl.util;

import com.dse.common.helper.SpringContextHelper;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DseSysCommonUtil {

	private static SessionFactory sessionFactory = null;
	
	public static boolean isValidDate(String sDate) {
		//String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]((((0?[13578])|(1[02]))[\\-\\/\\s]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]((((0?[13578])|(1[02]))[\\-\\/\\s]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
			Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(sDate);
		boolean b = m.matches();	
		return b;
	}
	
	public static String getTrim(Object value){
		if(DseStringUtil.empty(value)||DseStringUtil.isNullOrBlank(value.toString().toLowerCase())){
			return "";
		}else{
			return value.toString();			
		}
	}
	/**
	 * 去除行政区划右边‘000’
	 */
	public static String getCode(String adcd) {
		String code = adcd.trim();
		if (DseStringUtil.notEmpty(code)) {
			while (code.length()>6 &&"000".equals(code.substring(code.length() - 3, code.length()))) {
				code = code.substring(0, code.length() - 3);
			}

			while (code.length() < 7&& "00".equals(code.substring(code.length() - 2,code.length()))) {
				code = code.substring(0, code.length() - 2);
			}
		}

		return code;
	}

	/**
	 * 获取所有上级行政区划如code:421281001006 返回'421281001000000','421281000000000'
	 */
	public static String getAllPadcd(String code) {
		String adcds="";
		if (DseStringUtil.notEmpty(code)) {
			while (code.length()-3>=6 ) {
				
				code = code.substring(0, code.length() - 3);
				adcds=adcds+"'"+getAdcd(code)+"',";
			}
          if(adcds.length()>0){
        	  adcds=adcds.substring(0,adcds.length()-1);
          }
			
		}
		return adcds;
	}
	
	
	/**
	 * 获取所有本级及上级行政区划如adcds:421281001006000,421281002002000 
	 * 返回'421281001006000','421281001000000','421281000000000',
	 * '421281002002000','421281002000000'
	 */
	@SuppressWarnings("rawtypes")
	public static String getASxadcdByAdcds(String adcds) {
		String sxadcds="";
		String[] arr= adcds.split(",");
		Map<String, String> map=new HashMap<String, String>();
		for(String str :arr){
			map.put(str, str);
			String code=getCode(str);
			while (code.length()-3>=6) {
				code = code.substring(0, code.length() - 3);
				map.put(getAdcd6(code), getAdcd6(code));
			}
			while (code.length()<=6&&code.length()-2>=2) {
				code = code.substring(0, code.length() - 2);
				map.put(getAdcd6(code), getAdcd6(code));
			}

		}

		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			sxadcds=sxadcds+"'"+map.get(iterator.next())+"',";
		}
		if(sxadcds.length()>0){
			sxadcds=sxadcds.substring(0,sxadcds.length()-1);
		}
		return sxadcds;
	}

	/**
	 * 行政区划右边补'000’
	 */
	public static String getAdcd6(String code) {
		String codes = code.trim();
		while (codes.length() < 6) {
			codes = codes + "0";
		}
		return codes;
	}


	/**
	 * 行政区划右边补'000’
	 */
	public static String getAdcd(String code) {
		String codes = code.trim();
		while (codes.length() < 15) {
			codes = codes + "0";
		}
		return codes;
	}
	/**
	 * 行政区划右边补'000’
	 */
	public static String getAdcd(String code, int len) {
		String codes = code.trim();
		while (codes.length() < len) {
			codes = codes + "0";
		}
		return codes;
	}
	/* 在一个字符串中出现子字符串的第num个位置 */
	public static int getSubStrIndex(String mainStr, String subStr, int num) {
		if ((subStr != null && mainStr != null)
				&& (subStr.length() > 0 && mainStr.length() > 0)
				&& (subStr.length() <= mainStr.length())) {
			String tmpStr;
			int pos = 0;
			int count;
			int fnum = 1;
			while (true) {
				count = mainStr.length() - pos;
				if (count < subStr.length()) {
					break;
				}
				tmpStr = String.copyValueOf(mainStr.toCharArray(), pos,
						subStr.length());
				if (tmpStr.equals(subStr)) {
					if (fnum == num) {
						return pos;
					}
					fnum++;

				}
				pos++;
			}
		}
		return -1;
	}

	public static boolean isExit(String field, String[] fields) {
		for (int j = 0; j < fields.length; j++) {
			if (fields[j].equalsIgnoreCase(field)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 如果字符串不以/结束，则默认添加一个斜杠
	 * 
	 * @param str
	 * @return
	 */
	public static String append(String str) {
		if (str == null) {
			return "";
		}
		return str.endsWith("/") || str.endsWith("\\\\") ? str : str + "/";
	}
	public static Long getNewId() {
		StringBuffer sb = new StringBuffer();// 字串对象
		sb.append(DseDateUtil.formatDate(new java.util.Date(), "yyMMddHHmmss")); // 格式化时间类型
		Random random = new Random();// 随机对象
		for (int i = 0; i < 4; i++) {// 循环产生随机数字串
			sb.append(random.nextInt(10));
		}
		return Long.parseLong(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(getNewId());
	}


	/**
	 * 获取sessionFactory
	 * @return sessionFactory
     */
	public static SessionFactory getSessionFactory(){
		if(DseStringUtil.notEmpty(sessionFactory)){
			return sessionFactory;
		}else {
			sessionFactory = (SessionFactory) SpringContextHelper.getBean("dse_common_sessionFactory");
			return sessionFactory;
		}

	}
}
