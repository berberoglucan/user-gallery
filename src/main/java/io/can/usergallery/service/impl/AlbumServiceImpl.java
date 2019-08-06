package io.can.usergallery.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.can.usergallery.dto.AlbumDTO;
import io.can.usergallery.dto.AlbumPhotosDTO;
import io.can.usergallery.exception.InvalidIdParameterException;
import io.can.usergallery.exception.UserNotFoundException;
import io.can.usergallery.model.Album;
import io.can.usergallery.repository.AlbumRepository;
import io.can.usergallery.repository.PhotoRepository;
import io.can.usergallery.repository.UserRepository;
import io.can.usergallery.service.AlbumService;
import io.can.usergallery.util.ObjectMapperUtils;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Override
	public List<AlbumDTO> findAlbumsByUserId(String userId) {
		if(StringUtils.isEmpty(userId.trim()) || !StringUtils.isNumeric(userId.trim())) {
			throw new InvalidIdParameterException("userId parameter is null or is not numeric: " + userId);
		}
		Long numericUserId = Long.valueOf(userId);
		if(!userRepository.existsById(numericUserId)) {
			throw new UserNotFoundException("User is not found with the given user id: " + userId);
		}
		List<Album> albums = albumRepository.findAlbumsByUserId(numericUserId);
		return objectMapperUtils.mapAll(albums, AlbumDTO.class);
	}

	@Override
	public List<AlbumPhotosDTO> findAlbumsWithDetailsByUserId(String userId) {
		if(StringUtils.isEmpty(userId.trim()) || !StringUtils.isNumeric(userId.trim())) {
			throw new InvalidIdParameterException("userId parameter is null or is not numeric: " + userId);
		}
		Long numericUserId = Long.valueOf(userId);
		if(!userRepository.existsById(numericUserId)) {
			throw new UserNotFoundException("User is not found with the given user id: " + userId);
		}
		List<Album> albums =  albumRepository.findAlbumsWithDetailsByUserId(numericUserId);
		
		return  objectMapperUtils.mapAll(albums, AlbumPhotosDTO.class);
	}

	
	
}
