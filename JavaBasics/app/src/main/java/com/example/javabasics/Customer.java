package com.example.javabasics;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String name;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        if (this.name == null || this.address == null) {
            throw new IllegalArgumentException("name or address is null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getName().equals(customer.getName()) && getAddress().equals(customer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }

    @Override
    public int compareTo(Customer to) {
        int cmp = getName().compareTo(to.getName());
        if (cmp != 0) return cmp;
        cmp = getAddress().compareTo(to.getAddress());
        return cmp;
    }

    public Customer changeName(String name) {
        return new Customer(name,this.address);
    }

    public Customer changeAddress(String address) {
        return new Customer(this.name,address);
    }
}
