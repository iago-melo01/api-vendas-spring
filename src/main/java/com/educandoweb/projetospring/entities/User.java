package com.educandoweb.projetospring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    @OneToMany (mappedBy ="client") // mapeado pelo atributo "client"
    //que é o valor atribuido pro objeto user na classe Order
    private List<Order> orders = new ArrayList<>();



    public User(){}

    public User( Long id, String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
        this.phone = phone;
    }

    public User(  String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;

        this.password = password;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(id, user.id) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
