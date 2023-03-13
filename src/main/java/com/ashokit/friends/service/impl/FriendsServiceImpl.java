package com.ashokit.friends.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.friends.entity.FriendsEntity;
import com.ashokit.friends.repository.FriendsEntityRepository;
import com.ashokit.friends.service.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	FriendsEntityRepository friendsRepo;
	
	@Override
	public String addFriendService(FriendsEntity friend) {
		Integer count=friendsRepo.checkFriendContact(friend.getPhoneNumber(), friend.getFriendNumber());
		if(count==0)
		{
			friendsRepo.saveAndFlush(friend);
			return "Friend Contact is added";
		}
		else
		{
			return "Friend Contact already exists";
		}
	}

	@Override
	public List<Long> readFriendsContacts(Long phoneNumber) {
		return friendsRepo.findFriendsContactNumbers(phoneNumber);
	}

}
