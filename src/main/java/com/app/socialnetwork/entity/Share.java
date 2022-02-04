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
@Component("share")
@Scope("prototype")
@Entity
@Table(name = "SHARE_MASTER")
public class Share {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shareId;
	
    private String shareDescription;
	
	
    private String shareName;
    {/* @Autowired
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="postId")
	
	 private String postId;*/}

	public int getShareId() {
		return shareId;
	}


	public void setShareId(int shareId) {
		this.shareId = shareId;
	}


	public String getShareDescription() {
		return shareDescription;
	}


	public void setShareDescription(String shareDescription) {
		this.shareDescription = shareDescription;
	}


	public String getShareName() {
		return shareName;
	}


	public void setShareName(String shareName) {
		this.shareName = shareName;
	}


	@Override
	public String toString() {
		return "Share [shareId=" + shareId + ", shareDescription=" + shareDescription + ", shareName=" + shareName
				+ "]";
	}
    

}
