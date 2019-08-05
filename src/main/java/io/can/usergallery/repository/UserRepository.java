package io.can.usergallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.can.usergallery.model.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

}
