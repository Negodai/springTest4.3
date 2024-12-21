package ru.springtest.dao;

import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    private int id;
    private String name;
    private String addr;
    private String phone;

    public Teacher(){}

    public Teacher(int id, String name, String addr, String phone) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }

    @Id
    @Column( name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column( name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column( name="addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    @Column( name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return String.format("%-3d %-50s %s %s",
                getId(), getName(), getAddr(), getPhone());
    }

}
