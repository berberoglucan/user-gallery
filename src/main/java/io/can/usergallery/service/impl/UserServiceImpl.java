package io.can.usergallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.model.User;
import io.can.usergallery.repository.UserRepository;
import io.can.usergallery.service.UserService;
import io.can.usergallery.util.ObjectMapperUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userRepository.findAll();
		return objectMapperUtils.mapAll(users, UserDTO.class);
	}
	
}
