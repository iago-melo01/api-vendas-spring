package com.educandoweb.projetospring.repositories;

import com.educandoweb.projetospring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
