package com.pi2.backendsolarclean.dao;

import com.pi2.backendsolarclean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
