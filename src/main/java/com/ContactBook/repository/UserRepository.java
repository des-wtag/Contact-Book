package com.ContactBook.repository;

import com.ContactBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	User save(UserDto registrationDto);
	User findByEmail(String email);

}
