package com.educandoweb.projetospring.config;

import com.educandoweb.projetospring.entities.Category;
import com.educandoweb.projetospring.entities.Order;
import com.educandoweb.projetospring.entities.enums.OrderStatus;
import com.educandoweb.projetospring.entities.User;
import com.educandoweb.projetospring.repositories.CategoryRepository;
import com.educandoweb.projetospring.repositories.OrderRepository;
import com.educandoweb.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        User u1= new User("pinto" ,"email@gmail.com" ,"senha", "8399999999");
        User u2= new User("pau" ,"email@gmail.com" ,"senha", "8399999999");

        Order o1= new Order(null, Instant.now().plus(1, ChronoUnit.DAYS), OrderStatus.PAID, u1);
        Order o2= new Order(null, Instant.now().plus(5, ChronoUnit.DAYS), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
    }
}
