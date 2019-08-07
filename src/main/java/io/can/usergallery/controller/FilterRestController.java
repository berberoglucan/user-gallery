package io.can.usergallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.service.FilterService;

@RestController
@RequestMapping("/filter")
public class FilterRestController {

	@Autowired
	private FilterService filterService;
	
	// QUESTION 2 and 3
	@PostMapping("/email/{filterParam}")
	public ResponseEntity<List<UserDTO>> getFilteredUsersByEmail(@PathVariable("filterParam") String filterParam,
			@RequestParam(name = "pattern", defaultValue = "extension") String filterPatternName) {
		List<UserDTO> filteredUsers = filterService.findFilteredUsersByEmail(filterParam, filterPatternName);
		return ResponseEntity.ok(filteredUsers);
	}

}
