package com.educandoweb.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projetospring.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

}
