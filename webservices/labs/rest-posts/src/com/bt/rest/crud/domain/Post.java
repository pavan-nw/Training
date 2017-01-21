package com.bt.rest.crud.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Post {
	private Long id;
	private String message;
	private String userId;
	private Date timestamp;
	public Post() {
		super();
	}
	public Post(Long id, String message, String userId, Date timestamp) {
		super();
		this.id = id;
		this.message = message;
		this.userId = userId;
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", message=" + message + ", userId=" + userId
				+ ", timestamp=" + timestamp + "]";
	}
}
