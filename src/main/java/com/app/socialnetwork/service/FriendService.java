package com.app.socialnetwork.service;

import java.util.List;

import com.app.socialnetwork.entity.Friend;
import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchFriendException;
import com.app.socialnetwork.exceptions.NoSuchStudentException;

public interface FriendService {
	public boolean addFriend(Friend friend);
	public Friend findFriendById(int friendId)throws NoSuchFriendException;
	public Friend findFriendByName(String friendName);
	public boolean removeFriendById(int friendId)throws NoSuchFriendException ;
	public boolean updateFriend(Friend friend);
	public List<Friend> findAllFriends();
}
