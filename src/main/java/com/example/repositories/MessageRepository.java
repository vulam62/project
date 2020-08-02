package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Message;

/**
 * @author Ramesh Fadatare
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
