package com.app.socialnetwork.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.socialnetwork.entity.Permission;
import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchPermissionException;
import com.app.socialnetwork.exceptions.NoSuchStudentException;
import com.app.socialnetwork.service.PermissionService;



@RestController
@CrossOrigin
@RequestMapping(path = "permissions")
public class PermissionController {
	@Autowired
	private PermissionService service;
	
	private Logger logger = LoggerFactory.getLogger(PermissionController.class);
	//register/add/create Permission
	// http://machine-name:port-number/path-class/path-method
	// http://localhost:8080/permissions/ - Post
	@PostMapping(path = "/")
	public ResponseEntity<String> savePermission(@RequestBody Permission permission) {
		ResponseEntity<String> response = null;
		boolean result = service.addPermission(permission);
		if (result)
			response = new ResponseEntity<String>("Permission with id " + permission.getPermissionId() + " is added.",
					HttpStatus.CREATED);
		logger.info ( "addPermission API is called" + " permissionId " );
		
		return response;
	}
	// read/find permission by id
		// http://localhost:8080/permissions/searchById/10
		@GetMapping(path = "searchById/{permissionId}")
		public ResponseEntity<Permission> getPermissionById(@PathVariable("permissionId") int permissionId)throws NoSuchPermissionException {
			ResponseEntity<Permission> response = null;
			Permission permission = service.findPermissionById(permissionId);
			response = new ResponseEntity<Permission>(permission, HttpStatus.OK);
			logger.info ( "getPermissionById API is called" + " permissionId " + permissionId );
			return response;
		}
		//delete student
		// http://localhost:8080/permissions/deleteById/1
			@DeleteMapping(path = "deleteById/{permissionId}")
			public ResponseEntity<String> deletePermissionById(@PathVariable("permissionId") int permissionId)throws NoSuchPermissionException 
					 {
				ResponseEntity<String> response = null;
				boolean result = service.removePermissionById(permissionId);
				if (result)
					response = new ResponseEntity<String>("Permission with id " + permissionId + " is deleted.", HttpStatus.OK);
				return response;
			}
		//find all permissions
				// http://machine-name:port-number/context-path/path-class/path-method
				// http://localhost:8080/permissions/ - Get
				@GetMapping(path = "/")
				public ResponseEntity<List<Permission>> getAllPermissions() {
					ResponseEntity<List<Permission>> response = null;
					List<Permission> list = service.findAllPermissions();
					response = new ResponseEntity<List<Permission>>(list, HttpStatus.OK);
					return response;
				}
				//Update permission
				// http://localhost:8080/permissions/ - Put
				@PutMapping(path = "/")
				public ResponseEntity<String> updatePermission(@RequestBody Permission permission) {
					ResponseEntity<String> response = null;
					boolean result = service.updatePermission(permission);
					if (result)
						response = new ResponseEntity<String>("Permission with id " + permission.getPermissionId() + " is updated.",
								HttpStatus.OK);
					return response;
				}

}
