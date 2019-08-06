package io.can.usergallery.service.impl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.enums.EmailFilterPattern;
import io.can.usergallery.exception.IllegalFilterOption;
import io.can.usergallery.filter.specification.UserSpecifications;
import io.can.usergallery.model.User;
import io.can.usergallery.properties.FilterProperties;
import io.can.usergallery.repository.UserRepository;
import io.can.usergallery.service.FilterService;
import io.can.usergallery.util.ObjectMapperUtils;
import io.can.usergallery.util.ReflectUtil;

@Service("filterService")
public class FilterServiceImpl implements FilterService {

	Logger logger = LoggerFactory.getLogger(FilterServiceImpl.class);

	@Autowired
	private FilterProperties filterProperties;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapperUtils objectMapperUtils;

	@Autowired
	private ReflectUtil reflectUtil;

	@Override
	public List<UserDTO> findFilteredUsersByEmail(String filterParams, String filterPatternName) {
		EmailFilterPattern filterPattern;
		try {
			filterPattern = reflectUtil.getEnumFieldAsGivenString(filterPatternName.toUpperCase(Locale.ENGLISH),
					EmailFilterPattern.class);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			logger.error("Error", e);
			throw new IllegalFilterOption(filterPatternName + " pattern is not find in email filter patterns");
		}
		String seperator = filterProperties.getSeperator();
		String[] filterParamsArr = filterParams.replaceAll("[\\p{Punct}&&[^_-]]+", seperator).split(seperator);
		Set<String> filterParamsSet = Arrays.stream(filterParamsArr)
				.map(filterParam -> filterParam.toLowerCase(Locale.ENGLISH)).collect(Collectors.toCollection(LinkedHashSet::new));
		List<User> filteredUsers = userRepository
				.findAll(UserSpecifications.findFilteredUsersByEmail(filterParamsSet, filterPattern));
		return objectMapperUtils.mapAll(filteredUsers, UserDTO.class);
	}

}
