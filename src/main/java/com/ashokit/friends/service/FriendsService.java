package com.ashokit.friends.service;

import java.util.List;

import com.ashokit.friends.entity.FriendsEntity;

public interface FriendsService {

	String addFriendService(FriendsEntity friend);
	
	List<Long> readFriendsContacts(Long phoneNumber);
}
