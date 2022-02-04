package com.app.socialnetwork.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.socialnetwork.entity.Permission;
import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchPermissionException;
import com.app.socialnetwork.exceptions.NoSuchStudentException;
import com.app.socialnetwork.repository.PermissionRepository;
import com.app.socialnetwork.repository.StudentRepository;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionRepository repository;
	@Override
	public boolean addPermission(Permission permission) {
		boolean result = false;
		permission = repository.save(permission);
		if(permission.getPermissionId() > 0)
			result = true;
		return result;
	}

	@Override
	public Permission findPermissionById(int permissionId)throws NoSuchPermissionException {
		if(repository.existsById(permissionId)) {
			return repository.findById(permissionId).get();	
		}
		throw new NoSuchPermissionException("Permission with id "+permissionId+" not found.");
	}

	@Override
	public boolean removePermissionById(int permissionId)throws NoSuchPermissionException  {
		if(repository.existsById(permissionId)) {
			repository.deleteById(permissionId);
			return true;
		}
		
		throw new NoSuchPermissionException("Permission with id "+permissionId+" not found.");
	}
	@Transactional
	@Override
	
	public boolean updatePermission(Permission permission) {
		repository.updatePermission(permission.getPermissionTitle(), permission.getPermissionId());
		return true;
	}

	@Override
	public List<Permission> findAllPermissions() {
		return repository.findAll();
	}

	

}
