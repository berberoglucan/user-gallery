package io.can.usergallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.can.usergallery.model.Album;
import io.can.usergallery.model.Photo;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Query("SELECT a FROM Album a WHERE a.user.userId=:userId")
	List<Album> findAlbumsByUserId(@Param("userId") Long userId);
	
	@Query("SELECT a.photos FROM Album a JOIN a.photos p WHERE a.user.userId=:userId")
	List<Photo> findAlbumsWithDetailsByUserId(@Param("userId") Long userId);

}
