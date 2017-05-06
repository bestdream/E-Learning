package com.controller.file.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="file_attach")  //附件公共表file_attach
public class FileAttach {
	@Id
	@GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=36)
	private String id;                     //主键	string	36	UUID
	@Column(length=200)
	private String attachName;             //	附件名称	string	100
	@Column(columnDefinition="nvarchar2(100)")
	private String attachUrl;              //	附件路径	string	100
	@Column(length=10)
	private String attachExt;              //	附件扩展名	string	10
	@Column(length=36)
	private Date operDate;                 //	操作时间	date
	@Column(length=36)
	private String otherId;                //	其它表主键	string	36
	@Column(length=36)
	private String superOtherId;           //	其它表主键	string	36
	@Column(length=2)
	private String fileType;               //档案类别
	@Column(length=2)
	private String otherType;              //	其它表类型	string	10	01：产品 02文档管理
	private Integer gxStatus=0;            // 更新申请是用的字段  0:原信息，2.更新的新增
	private Integer status=0;              //用来判断是否删除 0未删除；1已删除 ；2预删除（更新时原附件的删除）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
	public String getAttachExt() {
		return attachExt;
	}
	public void setAttachExt(String attachExt) {
		this.attachExt = attachExt;
	}
	public Date getOperDate() {
		return operDate;
	}
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	public String getSuperOtherId() {
		return superOtherId;
	}
	public void setSuperOtherId(String superOtherId) {
		this.superOtherId = superOtherId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Integer getGxStatus() {
		return gxStatus;
	}
	public void setGxStatus(Integer gxStatus) {
		this.gxStatus = gxStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
