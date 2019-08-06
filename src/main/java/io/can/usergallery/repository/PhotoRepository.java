package io.can.usergallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.can.usergallery.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long>{

}
