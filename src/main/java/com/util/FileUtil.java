package com.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;


public class FileUtil {

	public static void loadFile(InputStream inputStream,String realPath,
			HttpServletRequest request) throws Exception{
        File file=new File(realPath);
        if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
        FileUtils.copyInputStreamToFile(inputStream, file);  
	}
	
	public static  void copyFile(String copyFilePaht,String becopyFilePaht) {
		File beF=new File(becopyFilePaht);
		if (!beF.getParentFile().exists())
			beF.getParentFile().mkdirs();
		if(beF.exists())
		{
           //return;
		   //beF.delete();
		}
		FileInputStream fi=null;
		FileOutputStream out=null;
		try{
			File f=new File(copyFilePaht);
			fi=new FileInputStream(f);
			out=new FileOutputStream(becopyFilePaht);
			byte bs[]=new byte[1024];
			int read=0;
			while((read=fi.read(bs))!=-1)
			{
				out.write(bs,0, read);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fi.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
	public static void downAttach(String filePath, String fileName, HttpServletResponse response,
			boolean isOnLine){
		File f = null;
		BufferedInputStream bufInStream = null;
		OutputStream outStream = null;
		byte[] buf  = null;
		try{
			f = new File(filePath);
			if (!f.exists()) {
				response.sendError(404, "File not found!");
				return;
			}
			bufInStream = new BufferedInputStream(new FileInputStream(f));
			buf = new byte[1024];
			int len = 0;
			String 	nameStr = new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "";
			response.reset();
			// 在线打开方式
			System.out.println("filePath:"+filePath);
			System.out.println("nameStr:"+nameStr);
			if (isOnLine) {
				
				URL u = new URL("file:///" + filePath);
				response.setContentType(u.openConnection().getContentType());
				response.setHeader("Content-Disposition", "inline; filename=" + nameStr);
			} else {// 纯下载方式
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition", "attachment; filename=" + nameStr);
			}
			outStream = response.getOutputStream();
			while ((len = bufInStream.read(buf)) > 0) {
				outStream.write(buf, 0, len);
			}
		} catch(IOException e){
		}finally{
			try {
				if(bufInStream!=null)bufInStream.close();
				if(outStream!=null)outStream.close();
			} catch (IOException e) {
			}
		}
	}

}
