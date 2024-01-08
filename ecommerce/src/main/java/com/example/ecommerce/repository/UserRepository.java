package com.example.ecommerce.repository;

import com.example.ecommerce.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findById(int id);
	List<User> findAll(); 
    void deleteById(int id);
    
}

