package io.can.usergallery.service;

import java.util.List;

import io.can.usergallery.dto.UserDTO;

public interface FilterService {
	
	List<UserDTO> findFilteredUsersByEmail(String filterParams, String filterPatternName);
	
}
