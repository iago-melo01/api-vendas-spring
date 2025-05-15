package com.educandoweb.projetospring.repositories;

import com.educandoweb.projetospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
