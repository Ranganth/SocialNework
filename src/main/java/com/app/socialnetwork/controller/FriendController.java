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

import com.app.socialnetwork.entity.Friend;
import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchFriendException;
import com.app.socialnetwork.exceptions.NoSuchPermissionException;
import com.app.socialnetwork.service.FriendService;


@RestController
@CrossOrigin
@RequestMapping(path = "friends")

public class FriendController {
	@Autowired
	private FriendService service;
	
	private Logger logger = LoggerFactory.getLogger(FriendController.class);
	//register/add/create friend
	// http://localhost:8080/friends/ - Post
	@PostMapping(path = "/")
	public ResponseEntity<String> saveFriend(@RequestBody Friend friend) {
		ResponseEntity<String> response = null;
		boolean result = service.addFriend(friend);
		if (result)
			response = new ResponseEntity<String>("Friend with id " + friend.getFriendId() + " is added.",
					HttpStatus.CREATED);
		logger.info ( "addFriend API is called" + " friendId " );
		
		return response;
	}
	
	//Update friend
	// http://localhost:8080/friends/updateById - Put
	@PutMapping(path = "/updateById")
	public ResponseEntity<String> updateFriend(@RequestBody Friend friend) {
		ResponseEntity<String> response = null;
		boolean result = service.updateFriend(friend);
		if (result)
			response = new ResponseEntity<String>("Friend with id " + friend.getFriendId() + " is updated.",
					HttpStatus.OK);
		return response;
	}
// read/find friend by id
	// http://localhost:8080/friends/searchById/10
	@GetMapping(path = "searchById/{friendId}")
	public ResponseEntity<Friend> getStudentById(@PathVariable("friendId") int friendId) throws NoSuchFriendException{
		ResponseEntity<Friend> response = null;
		Friend friend = service.findFriendById(friendId);
		response = new ResponseEntity<Friend>(friend, HttpStatus.OK);
		logger.info ( "getStudentById API is called" + " studentId " + friendId );
		return response;
	}
	//delete friend
	// http://localhost:8080/friends/deleteById/1
		@DeleteMapping(path = "deleteById/{friendId}")
		public ResponseEntity<String> deleteStudentById(@PathVariable("friendId") int friendId)throws NoSuchFriendException
				 {
			ResponseEntity<String> response = null;
			boolean result = service.removeFriendById(friendId);
			if (result)
				response = new ResponseEntity<String>("Student with id " + friendId + " is deleted.", HttpStatus.OK);
			return response;
		}
		//find student by name
		//http://localhost:8080/friends/searchByName/
		@GetMapping(path = "/searchByName/{friendName}")
		public ResponseEntity <Friend> getAllFriendsByName(@PathVariable("friendName") String friendName) {
			ResponseEntity<Friend> response = null;
			Friend list =service.findFriendByName(friendName);
			response = new ResponseEntity<Friend>(list, HttpStatus.OK);
			
			return response;
		}
		//find all FRIENDS
		// http://machine-name:port-number/context-path/path-class/path-method
		// http://localhost:9090/friends/ - Get
		@GetMapping(path = "/")
		public ResponseEntity<List<Friend>> getAllFriends() {
			ResponseEntity<List<Friend>> response = null;
			List<Friend> list = service.findAllFriends();
			response = new ResponseEntity<List<Friend>>(list, HttpStatus.OK);
			return response;
		}


}
