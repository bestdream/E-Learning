package com.util;

import java.lang.reflect.Field;

public class DataFormat {
    
	/**
	 * 
	* @Title: formatData
	* @Description: 返回页面中需要修改的 非null的值 自动填充页面中没有放隐藏域 不需要修改的值
	* @param @param poData 持久化对象 对应数据库中的值
	* @param @param voData 游离化对象 对应页面中的值
	* @param @return    
	* @return Object    
	 * @throws Exception 
	 * @throws Exception 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public static Object formatData(Object poData, Object voData) throws Exception {
		Field[] voFields = voData.getClass().getDeclaredFields();
		for (Field vo : voFields) {
			vo.setAccessible(true);//设置允许访问 
			String voFieldName = vo.getName();
			Object voVal = vo.get(voData);
			if(voVal==null){
				Field po = poData.getClass().getDeclaredField(voFieldName);
				po.setAccessible(true);//设置允许访问 
			    Object poVal = po.get(poData);
				if(poVal!=null){
					vo.set(voData, poVal);
				}
			}
		}
		return voData;
	}
	

}
