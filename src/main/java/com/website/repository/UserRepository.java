package com.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.website.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
