package com.techprimers.cache.springredisexample.model;

import java.io.Serializable;



public class User implements Serializable {

    private ID id;
    private String name;
    private Long salary;

    public User(ID id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
