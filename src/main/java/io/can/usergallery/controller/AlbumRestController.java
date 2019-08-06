package io.can.usergallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.can.usergallery.dto.AlbumDTO;
import io.can.usergallery.dto.AlbumPhotosDTO;
import io.can.usergallery.service.AlbumService;


@RestController
@RequestMapping("/albums")
public class AlbumRestController {

	@Autowired
	private AlbumService albumService;
	
	@PutMapping(value="/userAlbums/{userId}")
	public ResponseEntity<List<AlbumDTO>> getAlbumsByUserId(@PathVariable("userId") String userId) {
		List<AlbumDTO> albums = albumService.findAlbumsByUserId(userId);
		return ResponseEntity.ok(albums);
	}
	
	@PutMapping(value="/userAlbumsWithDetails/{userId}")
	public ResponseEntity<List<AlbumPhotosDTO>> getAlbumsWithDetailsByUserId(@PathVariable("userId") String userId) {
		List<AlbumPhotosDTO> albumsWithDetails = albumService.findAlbumsWithDetailsByUserId(userId);
		return ResponseEntity.ok(albumsWithDetails);
	}
	
}
