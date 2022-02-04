package com.app.socialnetwork.service;

import java.util.List;


import com.app.socialnetwork.entity.Message;
import com.app.socialnetwork.exceptions.NoSuchFriendException;
import com.app.socialnetwork.exceptions.NoSuchMessageException;

public interface MessageService {
	public boolean addMessage(Message message);
	public Message findMessageById(int MessageId)throws NoSuchMessageException;
	
	public boolean removeMessageById(int messageId)throws NoSuchMessageException ;
	public boolean updateMessage(Message message);
	public List<Message> findAllMessages();

}
