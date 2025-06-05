package com.educandoweb.projetospring.entities;

import com.educandoweb.projetospring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.educandoweb.projetospring.entities.Payment;

@Entity
@Table(name= "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "status")
    private Integer orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //Estamos mapeando as duas entidades para ter o mesmo id
     // ou seja, o order id vai ser o mesmo do payment id.  o cascade está fazendo isso
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @Column(name = "total")
    private Double total;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
        this.payment = payment;
    }
    public Order(Integer id, Instant moment, OrderStatus orderStatus, User client) {
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;

    }


    public Order(){

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null)
            this.orderStatus = orderStatus.getCode();
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getTotal(){
        Double total = 0.0;
        for (OrderItem oi : items){
            total += oi.getSubTotal();
        }
        return total;
    }

    public void setTotal(Double value){
        this.total = value;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
