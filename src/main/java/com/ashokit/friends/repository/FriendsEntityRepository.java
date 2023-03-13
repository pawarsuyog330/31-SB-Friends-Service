package com.ashokit.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.friends.entity.FriendsEntity;

@Repository
public interface FriendsEntityRepository extends JpaRepository<FriendsEntity, Integer> {

	@Query(value="select count(*) from friend_contacts where phone_number=? and friend_number=?", nativeQuery = true)
	Integer checkFriendContact(Long phoneNumber, Long friendNumber);
	
	@Query(value="select friend_number from friend_contacts where phone_number=?", nativeQuery = true)
	List<Long> findFriendsContactNumbers(Long phoneNumber);
}
