package com.example.javabasics;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;

public class Caps {
    Set<Cap> caps = new TreeSet<Cap>();

    // this needs infrastructure for Cap.
    private Map<Cap, Customer> cap2CustomerMap = new TreeMap<Cap,Customer>();

    // this infrastructure for String
    private Map<Customer,Cap> customer2CapMap = new TreeMap<Customer, Cap>();

    void addCap(Cap cap, Customer customer) {
        Cap clone = cap.clone();
        cap2CustomerMap.put(clone, customer);
        customer2CapMap.put(customer, clone);
    }

    Customer customerForCap(Cap cap) {
        return cap2CustomerMap.get(cap); // null if not associated
    }

    Cap capForCustomer(String customer) {
        Cap cap = customer2CapMap.get(customer);
        return (cap == null) ? null : cap.clone();
    }

    void setLabel(Cap cap, String label) {
        Customer customer = cap2CustomerMap.get(cap);
        if (customer != null) {
            cap2CustomerMap.remove(cap);
            Cap clone = cap.clone();
            clone.setLabel(label);
            cap2CustomerMap.put(clone,customer);
            customer2CapMap.put(customer,clone);
        }
    }

    // Mutation danger

    // safe sets

    // search and sort
}
