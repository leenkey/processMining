package com.tgb.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @version 1.0
 * @author linqi  华南理工大学软件学院
 * @desc 原始日志文件
 */

 @Entity
 @Table(name="T_ORIFILE")
public class OriFile {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid",strategy="uuid")
	@Column(length=32)
	private String id;  //文件ID
	
	@Column(length=64)
	private String orifileName;  //原始日志文件名称
	
	@Column(length=32)
	private String format;  //原始日志文件格式
	
	@Column(length=64)
	private String eventLog;  //原始日志关联的事件日志名称
	
	@Column(length=32)
	private String creationDate;  //原始日志创建时间
	
	@Column(length=32)
	private String creationBy;  //原始日志创建人
	
	@Column(length=128)
	private String orifilePath;  //原始日志的存储路径

	public String getOrifilePath() {
		return orifilePath;
	}

	public void setOrifilePath(String orifilePath) {
		this.orifilePath = orifilePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrifileName() {
		return orifileName;
	}

	public void setOrifileName(String orifileName) {
		this.orifileName = orifileName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getEventLog() {
		return eventLog;
	}

	public void setEventLog(String eventLog) {
		this.eventLog = eventLog;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationBy() {
		return creationBy;
	}

	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}

}
