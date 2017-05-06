package com.util;

import java.io.BufferedReader;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.engine.jdbc.SerializableClobProxy;


public class StringUtil {
	public static boolean isNull(String str) {
		return str == null || "".equals(str.trim()) ? true : false;
	}
	
	public static String checkIsNull(Object obj){
		 return obj==null?"":obj.toString();
	}
	
	public static boolean isNull(Object obj) {
		return obj!=null ? false : true;
	}

	public static boolean isNull(String[] str) {
		return str == null || str.length == 0 ? true : false;
	}

	public static Object[] reversed2Array(Object[] objs) {
		if (objs == null)
			return null;
		Object[] o = new Object[objs.length];
		int i = 0;
		for (int n = objs.length; n > -1; n--) {
			o[i] = objs[n];
			i++;
		}
		return o;
	}

	public static String reversed2String(Object[] objs) {
		if (objs == null)
			return null;
		String temp = "";
		for (int n = objs.length - 1; n > -1; n--) {
			temp += "," + objs[n];
		}
		return temp.replaceFirst(",", "");
	}

	public static String doneContent(String content, int maxNum) {
		if (isNull(content))
			return "";
		if (content.length() > maxNum) {
			content = content.substring(0, maxNum)
					+ "...";
		}
		return content;
	}

	public static boolean isContations(List<String> operateList, String uri) {
		boolean flag=false;
		for(String ss:operateList){
			if(ss.trim().equals(uri)||uri.matches(ss)){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 生成一个随机的字符串。
	 */
	public static String getPswd(int leng) {
		StringBuffer b = new StringBuffer();
		java.util.Date d = new Date();
		SimpleDateFormat  dateFormat=new SimpleDateFormat ("yyssMMHHdd");
		String asdf = dateFormat.format(d);
		StringBuffer buf = new StringBuffer(
		"a,b,c,d,e,f,g,h,g,k,m,n,p,q,r,s,t,u,v,w,x,y,2,3,4,5,6,7,8,9");
		String[] arr = buf.toString().split(",");
		java.util.Random r;
		int k;
		for (int i = 0; i < leng; i++) {
			r = new java.util.Random();
			k = r.nextInt();
			b.append(String.valueOf(arr[Math.abs(k % 30)]));
		}
		b.append(asdf);
		return b.toString();
	}
	/**
	 * 字符串截取和返回一个特定的字符串 例如：1,2,3 按照,截取前后都加' 最后返回'1','2','3'
	 */
	public static String getSplitStr(String str,String split,String firstAdd,String endAdd){
		if(str==null || str.equals(""))return "";
		String strs[] =str.split(split);
		StringBuffer sResult=new StringBuffer();
		for(String s:strs){
			if(!s.trim().equals(""))sResult.append(split).append(firstAdd).append(s).append(endAdd);
		}
		return sResult.toString().replaceFirst(split, "");
		
	}
	/**
	 * 数组截取和返回一个特定的字符串 例如：{1,2,3} 按照,截取前后都加' 最后返回'1','2','3'
	 */
	public static String getSplitStrFromStrings(String[] strs, String split, String firstAdd, String endAdd){
		String blank = "";
		if(strs == null || strs.length == 0 )return blank;
		StringBuffer sResult=new StringBuffer();
		for(String s:strs){
			if(!s.trim().equals(blank))sResult.append(split).append(firstAdd).append(s).append(endAdd);
		}
		return sResult.toString().replaceFirst(split, blank);
		
	}
	
	/**
	 * 获取UUID（不包含-）
	 * @Title: getUUID 
	 * @Description: 获取UUID（不包含-）
	 * @author caitou
	 * @createDate 2016-4-13 下午6:47:50
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	/**
	 * 将List返回String
	 * @return
	 */
	public static String getString(List<String> list){
		if(list==null||list.isEmpty())return "";
		String ss=list.toString().replaceAll(" ", "");
		return ss.substring(1, ss.length()-1);
	}
	
	//首字母转小写
    public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    public static String replaceAllCharacter(String str){
    	if(isNull(str)){return str;}
    	return str.replaceAll("\n\r", "<br/>")
    			.replaceAll("\r\n", "<br/>")
    			.replaceAll("\b", " ")
				.replaceAll("\t", " ")
				.replaceAll("\n", "<br/>")
				.replaceAll("\f", " ")
				.replaceAll("\r", "<br/>");
    }
    
    /*public static String ClobToString(Object obj) throws Exception { 
    	String reString = ""; 
    	if(StringUtil.isNull(obj)){return reString;}
    	if(!(obj instanceof Proxy)){
    		throw new Exception("it not's Proxy instanceof");
    	}
    	SerializableClobProxy  proxy = (SerializableClobProxy)Proxy.getInvocationHandler((Proxy)obj);
		 com.alibaba.druid.proxy.jdbc.ClobProxyImpl impl = (ClobProxyImpl) proxy.getWrappedClob();
//    	Reader is = clob.getCharacterStream();// 得到流 
    	Reader is = impl.getCharacterStream();// 得到流 
    	BufferedReader br = new BufferedReader(is); 
    	String s = br.readLine(); 
    	StringBuffer sb = new StringBuffer(); 
    	while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING 
    	sb.append(s); 
    	s = br.readLine(); 
    	} 
    	reString = sb.toString(); 
    	return reString; 
    	}*/
}
