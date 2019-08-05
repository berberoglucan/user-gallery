package io.can.usergallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> allUsers = userService.findAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
}
