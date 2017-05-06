package com.controller.file.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.controller.base.BaseDao;
import com.controller.file.entity.FileAttach;

@SuppressWarnings("unchecked")
@Service("fileService")
public class FileServiceImpl implements FileService {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	/**
	 * 保存到附件表中
	 */
	@Override
	public String addAttach(FileAttach fileAttach) {
		baseDao.save(fileAttach);
		return fileAttach.getId();
	}
	/**
	 * 删除附件
	 */
	@Override
	public String deleteFile(String id,String gxTag) {
		FileAttach f = (FileAttach) baseDao.get(FileAttach.class, id);
		if(gxTag!=null && gxTag.equals("1")){//已上架信息
			//先判断此信息的状态
			if(f.getGxStatus().equals(0)){//原信息附件的删除   将状态改成2预删除状态
				f.setStatus(2);
				baseDao.update(f);
			}else{//新添加信息的删除    直接将状态改成1已删除状态
				f.setStatus(1);
				baseDao.update(f);
			}
		}else{//未上架信息的删除  直接将状态改成1已删除状态
			f.setStatus(1);
			baseDao.update(f);
		}
		return "scuess";
	}
	/**
	 * 根据fileType以及id得到相关的附件
	 */
	@Override
	public List<FileAttach> getFiles(String id) {
		return null;//baseDao.find("from FileAttach where otherType='"+fileType+"' and otherId='"+id+"' order by operDate desc ");
	}
	/**
	 *  查询所有附件
	 */
	@Override
	public List<FileAttach> getFilelist() {
		return baseDao.find("from FileAttach  where status = 0 order by operDate desc ");
	}
	@Override
	public FileAttach getFile(String fileId) throws Exception {
		return (FileAttach) baseDao.get(FileAttach.class, fileId);
	}
	@Override
	public List<FileAttach> getFileslist(String entryId,HttpServletRequest request) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("entryId",entryId);
		List<FileAttach> flist = baseDao.findByCache("from FileAttach f where (f.superOtherId=:entryId or f.otherId=:entryId) and f.status = 0",map);
		return flist;
	}
	@Override
	public void updateAttach(FileAttach fileAttach) {
		baseDao.update(fileAttach);
		
	}
}
