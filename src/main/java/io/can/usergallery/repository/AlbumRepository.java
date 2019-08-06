package io.can.usergallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.can.usergallery.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Query("SELECT a FROM Album a WHERE a.user.userId=:userId")
	List<Album> findAlbumsByUserId(@Param("userId") Long userId);
	
	@Query("SELECT a FROM Album a JOIN FETCH a.photos p WHERE a.user.userId=:userId")
	List<Album> findAlbumsWithDetailsByUserId(@Param("userId") Long userId);

}
