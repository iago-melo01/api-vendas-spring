package com.educandoweb.projetospring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name= "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id") // parametro deve ser o nome da chave estrangeira da tabela que deseja-se juntar
    private User client;

    public Order(Integer id, Instant instant, User client) {
        this.id = id;
        this.moment = instant;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInstant() {
        return this.moment;
    }

    public void setInstant(Instant instant) {
        this.moment = instant;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
