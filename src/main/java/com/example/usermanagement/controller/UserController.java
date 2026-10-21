package com.example.usermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.usermanagement.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.usermanagement.dto.UserDTO;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController		
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
	    this.userService = userService;
	}
	
	@GetMapping("/api/users")
	public List<UserDTO> getUsers() {
		 return userService.getAllUsers();	
	}
	
	@GetMapping("/api/users/{id}")
	public UserDTO getUserById(@PathVariable Long id) {
	    return userService.getUserById(id);
	}
	
	@PostMapping("/api/users")
	public ResponseEntity<UserDTO> createUser(
	        @Valid @RequestBody UserDTO userDTO) {

	    UserDTO createdUser = userService.createUser(userDTO);

	    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/api/users/{id}")
	public UserDTO updateUser(
	        @PathVariable Long id,
	        @Valid @RequestBody UserDTO userDTO) {

	    return userService.updateUser(id, userDTO);
	}
	
	@DeleteMapping("/api/users/{id}")
	public String deleteUser(@PathVariable Long id) {
	    userService.deleteUser(id);
	    return "User deleted successfully";
	}
	

}
