package com.educandoweb.projetospring.services;

import com.educandoweb.projetospring.entities.Category;
import com.educandoweb.projetospring.entities.Product;
import com.educandoweb.projetospring.repositories.CategoryRepository;
import com.educandoweb.projetospring.repositories.ProductRepository;
import com.educandoweb.projetospring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
