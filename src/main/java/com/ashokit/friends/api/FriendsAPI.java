package com.ashokit.friends.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.friends.entity.FriendsEntity;
import com.ashokit.friends.service.FriendsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/friends/")
@Slf4j
public class FriendsAPI {
	
	@Value("${server.port}")
	int serverPort;

	@Autowired
	FriendsService service;
	
	@PostMapping("/addfriend")
	public ResponseEntity<String> addFriend(@RequestBody FriendsEntity friend)
	{
		return new ResponseEntity<String>(service.addFriendService(friend), HttpStatus.OK);
	}
	
	@GetMapping("/{phoneNumber}")
	public ResponseEntity<List<Long>> getFriendsContacts(@PathVariable Long phoneNumber, @RequestHeader("myapp-tracing-id")String traceId)
	{
		log.info("myapp-tracing-id is found in Friends-Service :{}", traceId);
		log.info("getFriendsContacts method executed");
		return new ResponseEntity<List<Long>>(service.readFriendsContacts(phoneNumber), HttpStatus.OK);
	}
}
