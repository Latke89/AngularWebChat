package com.tiy.springchat;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Brett on 9/23/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
