package com.app.socialnetwork.entity;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("post")
@Scope("prototype")
@Entity
@Table(name = "POST_MASTER")
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String postDescription;
	private String postTitle;
	 {/* @Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentName")
	
	 private String studentName;*/}
	

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", postDescription=" + postDescription + ", postTitle=" + postTitle
				+ " ]";
	}
	

}
