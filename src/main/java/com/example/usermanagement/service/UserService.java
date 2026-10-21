package com.example.usermanagement.service;

import org.springframework.stereotype.Service;
import com.example.usermanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.UserNotFoundException;
import com.example.usermanagement.dto.UserDTO;



//"This class contains the business logic of my application. Manage this class as a Spring Bean."

@Service
public class UserService {
	
	private UserRepository userRepository;
	//constructor to store repo in userRepository
	public UserService(UserRepository userRepository) {
	    this.userRepository = userRepository;
	}
	
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();

		List<UserDTO> responseDTOs = new ArrayList<>();

		for (User user : users) {

		    UserDTO dto = new UserDTO();

		    dto.setId(user.getId());
		    dto.setName(user.getName());
		    dto.setEmail(user.getEmail());

		    responseDTOs.add(dto);
		}

		return responseDTOs;
	    }
	
	public UserDTO getUserById(Long id) {

	    User user = userRepository.findById(id)
	            .orElseThrow(() ->
	                new UserNotFoundException("User not found with id: " + id)
	            );

	    UserDTO responseDTO = new UserDTO();

	    responseDTO.setId(user.getId());
	    responseDTO.setName(user.getName());
	    responseDTO.setEmail(user.getEmail());

	    return responseDTO;
	}
	          
	
	
	
	public UserDTO createUser(UserDTO userDTO) {

	    User user = new User();

	    user.setName(userDTO.getName());
	    user.setEmail(userDTO.getEmail());

	    User savedUser = userRepository.save(user);

	    UserDTO responseDTO = new UserDTO();

	    responseDTO.setId(savedUser.getId());
	    responseDTO.setName(savedUser.getName());
	    responseDTO.setEmail(savedUser.getEmail());

	    return responseDTO;
	}
	
	
	
	public UserDTO updateUser(Long id, UserDTO userDTO) {

	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() ->
	                new UserNotFoundException("User not found with id: " + id)
	            );

	    existingUser.setName(userDTO.getName());
	    existingUser.setEmail(userDTO.getEmail());

	    User updatedUser = userRepository.save(existingUser);

	    UserDTO responseDTO = new UserDTO();

	    responseDTO.setId(updatedUser.getId());
	    responseDTO.setName(updatedUser.getName());
	    responseDTO.setEmail(updatedUser.getEmail());

	    return responseDTO;
	}
	
	
	public void deleteUser(Long id) {

	    User user = userRepository.findById(id)
	            .orElseThrow(() ->
	                new UserNotFoundException("User not found with id: " + id)
	            );

	    userRepository.delete(user);
	}
	
	
	}


