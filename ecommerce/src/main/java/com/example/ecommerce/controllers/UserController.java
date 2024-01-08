package com.example.ecommerce.controllers;

import com.example.ecommerce.models.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserRepository repo; 
	
	@GetMapping("/")
    public String getUsers(){
    return "users";
	}
	
	@GetMapping("/all") 
    public List<User> getAllUsers() 
    { 
        return repo.findAll(); 
    } 
	
	@GetMapping("/find/{id}")
	public User findId(@PathVariable int id){
		return repo.findById(id);
	}
	
	@GetMapping("/del/{id}")
	public String delId(@PathVariable int id){
		repo.deleteById(id);
		return "Id "+id+" Deleted";
	}
    
    
}
