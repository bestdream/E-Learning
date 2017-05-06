package com.controller.file;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.baidu.ueditor.define.State;
import com.controller.file.service.FileService;
import com.util.StringUtil;

/**
 * 附件管理
 * @author xbliu
 */
@Controller
@RequestMapping("/file")
public class FileController{
	@Resource(name = "fileService")
	private FileService fileService;
	/**
	 * 上传附件
	 * @return 
	 */
	@RequestMapping("/addAttach.html")
	public void addAttach(HttpServletRequest request,@RequestParam(required = true) MultipartFile[] upfile,
			HttpServletResponse response) throws Exception{
		String filePath="";
		String attachId="";
		String originalFilename = "";
		HttpSession session=request.getSession();
		String realPath = session.getServletContext().getRealPath("/"); 
		//由于1.可能到时候放到文件服务器;2.火狐session丢失;所以不能从session中获取
		String superId=request.getParameter("superId");
		String jobCode=request.getParameter("jobCode");
		String userName=request.getParameter("userName");
		String userDeptCode=request.getParameter("userDeptCode");
		String userDeptName=request.getParameter("userDeptName");
		String otherId=request.getParameter("otherId");
		String otherType=request.getParameter("otherType");
		String fileType=request.getParameter("fileType");
		String gxStatus=request.getParameter("gxStatus");
		if(StringUtil.isNull(gxStatus)){gxStatus="0";}
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		StringBuffer sb=new StringBuffer("{\"fileAttachs\":[");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", "SUCCESS");
		 params.put("url", "visitUrl");
		 params.put("size", "20000");
		 params.put("original", "fileName");
		 params.put("type", "upfile.getContentType()");
		 response.setHeader("Content-Type" , "application/json");
		 //return params;
		/*for(MultipartFile mf:filedata){
			if(mf.isEmpty())continue;
			originalFilename=mf.getOriginalFilename();
			String extName="";
			if(originalFilename.lastIndexOf(".")>-1){
				extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1).toLowerCase();
			}
			filePath="/upload"+"/"+otherType+"/"+superId+"/"+year+"/"+month+"/"+day+"/"+UUID.randomUUID().toString()+"."+extName;
			realPath+=filePath;
			FileUtil.loadFile(mf.getInputStream(),realPath,request);
			//保存到附件表中
			FileAttach fileAttach=new FileAttach();
			fileAttach.setAttachName(originalFilename);
			fileAttach.setAttachUrl(filePath);
			fileAttach.setAttachExt(extName);
			fileAttach.setOperDate(new Date());
			fileAttach.setOtherId(otherId);
			fileAttach.setOtherType(otherType);
			fileAttach.setSuperOtherId(superId);
			fileAttach.setFileType(fileType);
			fileAttach.setGxStatus(Integer.valueOf(gxStatus));
			
			attachId=fileService.addAttach(fileAttach);
			
			sb.append(",{\"url\":\""+request.getContextPath()+filePath+"\",\"id\":\""+attachId+"\",\"fileType\":\""+fileType+"\",\"fileName\":\""+originalFilename+"\"}");
		}
		sb.append("]}");*/
		//String  result= sb.toString().replaceFirst(",", "");
		// String result = ""; //= "{\"original\":\"demo.jpg\",\"name\":\"demo.jpg\",\"url\":\"\\server\\ueditor\\upload\\image\\demo.jpg\",\"size\":\"99697\",\"type\":\".jpg\",\"state\":\"SUCCESS\"}";
		String result = com.alibaba.fastjson.JSONObject.toJSONString(params);
		 PrintWriter out = null;
		response.setContentType("application/json");
		out = response.getWriter();
		out.write(result);
		out.close();
	}
	/**
	 *删除产品 
	 */
	@RequestMapping("/delete_{id}.html")
	public void deleteFile(@PathVariable String id,String gxTag,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String result=fileService.deleteFile(id,gxTag);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(result);
	}
}
