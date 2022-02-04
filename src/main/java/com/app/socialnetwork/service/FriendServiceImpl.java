package com.app.socialnetwork.service;

import java.util.List;

import com.app.socialnetwork.entity.Friend;
import com.app.socialnetwork.exceptions.NoSuchFriendException;
import com.app.socialnetwork.exceptions.NoSuchStudentException;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.socialnetwork.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService{
	@Autowired
	private FriendRepository repository;

	@Override
	public boolean addFriend(Friend friend) {
		boolean result = false;
		friend = repository.save(friend);
		if(friend.getFriendId() > 0)
			result = true;
		return result;
	}

	@Override
	public Friend findFriendById(int friendId)throws NoSuchFriendException {
		if(repository.existsById(friendId)) {
			
		}
	return repository.findById(friendId).get();
	}

	@Override
	public Friend findFriendByName(String friendName) {
		return repository.readByFriendName(friendName);
	}

	@Override
	public boolean removeFriendById(int friendId) {
		if(repository.existsById(friendId)) {
			repository.deleteById(friendId);
			
		}
		return true;
	}
	@Transactional
	@Override
	public boolean updateFriend(Friend friend) {
		repository.updateFriend(friend.getFriendName(), friend.getFriendId());
		return true;
	}

	@Override
	public List<Friend> findAllFriends() {
		return repository.findAll();
	}
	
}