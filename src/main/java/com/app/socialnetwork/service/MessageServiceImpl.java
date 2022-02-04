package com.app.socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.socialnetwork.entity.Message;
import com.app.socialnetwork.exceptions.NoSuchMessageException;
import com.app.socialnetwork.exceptions.NoSuchPermissionException;
import com.app.socialnetwork.repository.MessageRepository;

@Service
public class MessageServiceImpl implements  MessageService{
	@Autowired
	private MessageRepository repository;
	@Override
	public boolean addMessage(Message message) {
		boolean result = false;
		message = repository.save(message);
		if(message.getMessageId() > 0)
			result = true;
		return result;
	}

	@Override
	public Message findMessageById(int messageId) throws NoSuchMessageException {
		if(repository.existsById(messageId)) {
			return repository.findById(messageId).get();	
		}
		throw new NoSuchMessageException("Message with id "+messageId+" not found.");
	}

	

	@Override
	public boolean removeMessageById(int messageId) throws NoSuchMessageException {
		if(repository.existsById(messageId)) {
			repository.deleteById(messageId);
			return true;
		}
		
		throw new NoSuchMessageException("Message  with id "+messageId+" not found.");
	}
	@Transactional
	@Override
	public boolean updateMessage(Message message) {
		repository.updateMessage(message.getMessageDescription(), message.getMessageId());
		return true;	
		}

	@Override
	public List<Message> findAllMessages() {
		return repository.findAll();
	}

}
