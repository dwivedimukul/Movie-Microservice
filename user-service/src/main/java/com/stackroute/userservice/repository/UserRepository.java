package com.stackroute.userservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.userservice.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User getByUserId(int UserId);
//	@Query("SELECT * FROM User User WHERE User.UserTitle LIKE ?1")
	public User getByUserName(String userName);
	public List<User> getByUserRating(float userRating);
	

}
