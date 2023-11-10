package com.pm.demo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<User> getUserByFirstName(String firstName) {
        return User.list("firstName = :firstName", Parameters.with("firstName", firstName).map());
    }

    public static List<User> getUserByAlphabets(String letter) {
        String searchInput = "%" + letter + "%";
        return User.list(" firstName like ?1 OR lastName like ?2", searchInput, searchInput);
    }

}
