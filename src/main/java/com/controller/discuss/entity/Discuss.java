package com.controller.discuss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.controller.user.entity.User;

/**
 * 评论.
 * @author scarecrow
 *
 */
@Entity
@Table(name="discuss")
public class Discuss implements Serializable {

	//TODO
	/**
	 * 评论内容
	 * 文章id
	 * 评论时间
	 * 
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(columnDefinition="varchar(36)")
	private String id;
	@Column(name="discuss_content",columnDefinition="varchar(10000)")
	private String discussContent;               //评论内容
	@Column(name="discuss_time")
	private Date discussTime;                    //评论时间
	@Column(name="other_id",columnDefinition="varchar(36)")
	private String otherId;                      //被评论资源
	@ManyToOne
	private User user;                           //评论人员
	private Discuss pid;                         //回复id
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiscussContent() {
		return discussContent;
	}
	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}
	public Date getDiscussTime() {
		return discussTime;
	}
	public void setDiscussTime(Date discussTime) {
		this.discussTime = discussTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Discuss getPid() {
		return pid;
	}
	public void setPid(Discuss pid) {
		this.pid = pid;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	
	
}
