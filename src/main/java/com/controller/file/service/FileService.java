package com.controller.file.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.controller.file.entity.FileAttach;


public interface FileService {
	//保存到附件表中
	String addAttach(FileAttach fileAttach);
	/**
	 * 删除附件
	 */
	String deleteFile(String id,String gxTag);
	/**
	 * 根据fileType以及id得到相关的附件
	 */
	List<FileAttach> getFiles(String id);
	/**
	 * 查询所有附件（状态为0 未删除的附件）
	 * */
	List<FileAttach> getFilelist();
	/**
	 * 根据ID查找指定文件
	 * @Title: getFile 
	 * @Description: 根据ID查找指定文件
	 * @author caitou
	 * @createDate 2016-7-14 下午4:03:49
	 * @param fileId 文件ID
	 * @return 文件信息
	 * @throws Exception
	 */
	FileAttach getFile(String fileId)throws Exception;
	/**
	 * 根据流程id查询附件列表 （状态为0 未删除的附件）
	 * @param entryId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<FileAttach> getFileslist(String entryId,HttpServletRequest request) throws Exception;
	//修改附件表
	void updateAttach(FileAttach fileAttach);
}
