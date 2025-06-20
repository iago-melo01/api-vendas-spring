package com.educandoweb.projetospring.services;

import com.educandoweb.projetospring.entities.User;
import com.educandoweb.projetospring.repositories.UserRepository;
import com.educandoweb.projetospring.services.exceptions.DBIntegrityException;
import com.educandoweb.projetospring.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj); // método save retorna um objeto, após salvar
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DBIntegrityException(e.getMessage());
        }


    }

    public User update(Long id, User obj) {
        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        updateData(entity, obj);
        return userRepository.save(entity);
    }

    // This function updates the data of the object "entity" with the data provided by the object "obj"
    private void updateData(User entity, User obj) {

        entity.setPhone(obj.getPhone());
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }
}
