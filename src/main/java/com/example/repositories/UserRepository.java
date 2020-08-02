package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User;


/**
 * @author Ramesh Fadatare
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
