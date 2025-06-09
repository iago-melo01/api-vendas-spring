package com.educandoweb.projetospring.services;

import com.educandoweb.projetospring.entities.User;
import com.educandoweb.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    public User insert(User obj) {
        return userRepository.save(obj); // método save retorna um objeto, após salvar
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setPhone(obj.getPhone());
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }
}
