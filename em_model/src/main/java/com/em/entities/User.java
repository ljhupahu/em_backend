package com.em.entities;

import javax.persistence.*;

/**
 * Created by Jet on 2017/8/7.
 */
@Entity
@Table(name = "usersT")
public class User extends SalesManagerEntity<Integer, User> {

    private static final long serialVersionUID = 7671103335743647655L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
