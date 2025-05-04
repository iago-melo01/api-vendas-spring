package com.educandoweb.projetospring.resources;

import com.educandoweb.projetospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Iago veras", "iago@gmail.com", "123456", "83998075205");
        return ResponseEntity.ok().body(u);
    }

}
