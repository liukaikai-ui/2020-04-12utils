package com.kiki.comcom.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
    * @ClassName: CollectionUtil
    * @Description: 集合的处理类
    * @author lk
    * @date 2020年3月26日
    *
 */
public class CollectionUtil {

	public static boolean hasValue(Map<?, ?> map) {
		if(map.size()!=0 && null!=map) {
			return true;
		}else {
			return false;
		}
		
	}
	public static boolean hasValue(Collection<?> collection) {
		if(collection.size()!=0 && null!=collection) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 
	    * @Title: isEmpty
	    * @Description: 判断集合是否为空
	    * @param @param list
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isEmpty(Collection<?> collection) {
		
		return collection==null || collection.isEmpty();
		
	}
}
