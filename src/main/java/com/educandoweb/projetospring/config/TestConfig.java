package com.educandoweb.projetospring.config;

import com.educandoweb.projetospring.entities.Order;
import com.educandoweb.projetospring.entities.User;
import com.educandoweb.projetospring.repositories.OrderRepository;
import com.educandoweb.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1= new User("pinto" ,"email@gmail.com" ,"senha", "8399999999");
        User u2= new User("pau" ,"email@gmail.com" ,"senha", "8399999999");

        Order o1= new Order(null, Instant.now().plus(1, ChronoUnit.DAYS), u1);
        Order o2= new Order(null, Instant.now().plus(5, ChronoUnit.DAYS), u1    );

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
    }
}
