package io.can.usergallery.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.exception.InvalidPageRequstParameterException;
import io.can.usergallery.model.User;
import io.can.usergallery.repository.UserRepository;
import io.can.usergallery.service.UserService;
import io.can.usergallery.util.ObjectMapperUtils;
import io.can.usergallery.util.ReflectUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired 
	private ReflectUtil reflectUtil;
	
	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userRepository.findAll();
		return objectMapperUtils.mapAll(users, UserDTO.class);
	}

	@Override
	public List<UserDTO> findAllUsers(int pageNo, int pageSize, String sortBy) {
		
		if(pageNo < 1) {
			throw new InvalidPageRequstParameterException("pageNo parameter is not less 1");
		}
		
		if(!reflectUtil.isClassFieldGivenType(sortBy, User.class)) {
			throw new InvalidPageRequstParameterException(sortBy + " no found for type " + reflectUtil.getClassNameForGivenType(User.class));
		}
		
		PageRequest paging = PageRequest.of(pageNo - 1, pageSize, Sort.by(sortBy));
		Page<User> pagedUsers = userRepository.findAll(paging);
		if(pagedUsers.hasContent()) {
			return objectMapperUtils.mapAll(pagedUsers.getContent(), UserDTO.class);
		} else {
			return new ArrayList<>();
		}
	}
	
}
