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

import com.app.socialnetwork.entity.Message;
import com.app.socialnetwork.exceptions.NoSuchMessageException;
import com.app.socialnetwork.service.MessageService;

@RestController
@CrossOrigin
@RequestMapping(path = "messages")

public class MessageController {
	@Autowired
	private MessageService service;
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	//register/add/create message
	// http://machine-name:port-number/path-class/path-method
	// http://localhost:8080/messages/ - Post
	@PostMapping(path = "/")
	public ResponseEntity<String> saveMessage(@RequestBody Message message) {
		ResponseEntity<String> response = null;
		boolean result = service.addMessage(message);
		if (result)
			response = new ResponseEntity<String>("Message with id " + message.getMessageId() + " is added.",
					HttpStatus.CREATED);
		logger.info ( "addMessage API is called" + " messageId " );
		
		return response;
	}
	// read/find message by id
		// http://localhost:8080/messages/searchById/10
		@GetMapping(path = "searchById/{messageId}")
		public ResponseEntity<Message> getPermissionById(@PathVariable("messageId") int messageId)throws NoSuchMessageException {
			ResponseEntity<Message> response = null;
			Message message = service.findMessageById(messageId);
			response = new ResponseEntity<Message>(message, HttpStatus.OK);
			logger.info ( "getMessageById API is called" + " messageId " + messageId );
			return response;
		}
		//delete message
		// http://localhost:8080/messages/deleteById/1
			@DeleteMapping(path = "deleteById/{messageId}")
			public ResponseEntity<String> deleteMessageById(@PathVariable("messageId") int messageId)throws NoSuchMessageException 
					 {
				ResponseEntity<String> response = null;
				boolean result = service.removeMessageById(messageId);
				if (result)
					response = new ResponseEntity<String>("Message with id " + messageId + " is deleted.", HttpStatus.OK);
				return response;
			}
		//find all messages
				// http://machine-name:port-number/context-path/path-class/path-method
				// http://localhost:8080/messages/ - Get
				@GetMapping(path = "/")
				public ResponseEntity<List<Message>> getAllMessages() {
					ResponseEntity<List<Message>> response = null;
					List<Message> list = service.findAllMessages();
					response = new ResponseEntity<List<Message>>(list, HttpStatus.OK);
					return response;
				}
				//Update message
				// http://localhost:8080/messages/ - Put
				@PutMapping(path = "/")
				public ResponseEntity<String> updateMessage(@RequestBody Message message) {
					ResponseEntity<String> response = null;
					boolean result = service.updateMessage(message);
					if (result)
						response = new ResponseEntity<String>("Message with id " + message.getMessageId() + " is updated.",
								HttpStatus.OK);
					return response;
				}


}
