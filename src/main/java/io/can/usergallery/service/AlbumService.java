package io.can.usergallery.service;

import java.util.List;

import io.can.usergallery.dto.AlbumDTO;
import io.can.usergallery.dto.AlbumPhotosDTO;

public interface AlbumService {
	
	List<AlbumDTO> findAlbumsByUserId(String userId);
	
	List<AlbumPhotosDTO> findAlbumsWithDetailsByUserId(String userId);
	
}
