package com.app.socialnetwork.service;

import java.util.List;

import com.app.socialnetwork.entity.Permission;
import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchPermissionException;
import com.app.socialnetwork.exceptions.NoSuchStudentException;

public interface PermissionService {
	public boolean addPermission(Permission permission);
	public Permission findPermissionById(int permissionId)throws NoSuchPermissionException;
	
	public boolean removePermissionById(int permissionId) throws NoSuchPermissionException;
	public boolean updatePermission(Permission permission);
	public List<Permission> findAllPermissions();
}
