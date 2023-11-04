package com.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdp.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>
{
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User checkuserlogin(String email,String password);
}
