package com.app.socialnetwork.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("permission")
@Scope("prototype")
@Entity
@Table(name = "PERMISSION_MASTER")
public class Permission {
	@Id
	@Column(name = "PERMISSION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;
	
	@Column(name = "PERMISSION_DESCRIPTION", length = 50)
    private String permissionDescription;
	
	@Column(name = "PERMISSION_TITLE", length = 50)
	@NotEmpty(message = "Please Enter TITLE Name")
    private String permissionTitle;


	public int getPermissionId() {
		return permissionId;
	}


	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}


	public String getPermissionDescription() {
		return permissionDescription;
	}


	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}


	public String getPermissionTitle() {
		return permissionTitle;
	}


	public void setPermissionTitle(String permissionTitle) {
		this.permissionTitle = permissionTitle;
	}


	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionDescription=" + permissionDescription
				+ ", permissionTitle=" + permissionTitle + "]";
	}


	
    
}
