package com.educandoweb.projetospring.config;

import com.educandoweb.projetospring.entities.*;
import com.educandoweb.projetospring.entities.enums.OrderStatus;
import com.educandoweb.projetospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1= new User("pinto" ,"email@gmail.com" ,"senha", "8399999999");
        User u2= new User("pau" ,"email@gmail.com" ,"senha", "8399999999");



        Order o1= new Order(null, Instant.now().plus(1, ChronoUnit.DAYS), OrderStatus.PAID, u1);
        Order o2= new Order(null, Instant.now().plus(5, ChronoUnit.DAYS), OrderStatus.WAITING_PAYMENT, u2);
        Order o3= new Order(null, Instant.now().plus(1, ChronoUnit.DAYS), OrderStatus.PAID, u1);
        Order o4= new Order(null, Instant.now().plus(5, ChronoUnit.DAYS), OrderStatus.WAITING_PAYMENT, u2);


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o2, p2, 2, p2.getPrice());
        OrderItem oi3 = new OrderItem(o3, p3, 3, p3.getPrice());
        OrderItem oi4 = new OrderItem(o4, p4, 4, p4.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.now(), o1);
        //para salvar um objeto dependente de uma associação OneToOne, não precisa chamar o repository do proprio
        //objeto não.
        o1.setPayment(pay1);

        orderRepository.save(o1);

    }
}
