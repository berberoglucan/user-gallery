package io.can.usergallery.service;

import java.util.List;

import io.can.usergallery.dto.UserDTO;

public interface UserService {

	List<UserDTO> findAllUsers();
	
	List<UserDTO> findAllUsers(int pageNo, int pageSize, String sortBy);
	
	
}
