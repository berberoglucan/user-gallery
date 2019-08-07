package io.can.usergallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	// QUESTION 1
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> allUsers = userService.findAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/allUsersWithPaging")
	public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "userId") String sortBy) {

		List<UserDTO> allUsers = userService.findAllUsers(pageNo, pageSize, sortBy);
		return ResponseEntity.ok(allUsers);

	}
	
}
