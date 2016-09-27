package com.tiy.springchat;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Brett on 9/23/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

	List<Message> findAllByOrderByIdDesc();
}
