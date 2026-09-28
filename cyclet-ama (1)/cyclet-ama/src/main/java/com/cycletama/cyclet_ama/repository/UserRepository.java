package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
