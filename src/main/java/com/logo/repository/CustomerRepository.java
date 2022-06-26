package com.logo.repository;

import com.logo.model.Customer;
import com.logo.model.Order;
import com.logo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CustomerRepository {
    private static final List<Customer> customers= new ArrayList<>();
    private static int nextId = 0;


    private List<Customer> prepareCustomerList() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("bilisim.io", 25, new ArrayList<>()));
        customers.add(new Customer("cem", 30, prepareOrderList()));
        customers.add(new Customer("ömer", 21, prepareOrderList()));
        customers.add(new Customer("haluk", 32, prepareOrderList()));
        customers.add(new Customer("halil", 25, prepareOrderList()));
        customers.add(new Customer("fatih", 18, prepareOrderList()));
        return customers;
    }


    private List<Product> prepareProductList(int randomOrderNumber) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        products.add(new Product("MacBook Pro", random.nextDouble(1000)));
        products.add(new Product("MacBook air", random.nextDouble(1000)));
        products.add(new Product("iPhone 12", random.nextDouble(1000)));

        return products.stream().limit(randomOrderNumber).toList();
    }


    private List<Order> prepareOrderList() {
        List<Order> orders = new ArrayList<>();
        int randomOrderNumber = new Random().nextInt(5);
        for (int i = 0; i < randomOrderNumber; i++) {
            Order order = new Order(prepareProductList(randomOrderNumber));
            orders.add(order);
        }
        return orders;
    }

    public Customer save(Customer customer){
        customer.setId(nextId);
        nextId += 1;
        customer.setActive(true);
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> findByName(String name){
        return customers.stream().filter(it -> it.getName().equals(name)).findFirst();
    }

    public List<Customer> getByIsActive(boolean activeStatus){
        return customers.stream().filter(it -> it.isActive() == activeStatus).toList();
    }

    public Optional<Customer> findById(int id){
        return customers.stream().filter(it -> it.getId() == id).findFirst();
    }

    public List<Customer> getAll() {
        return customers;
    }

    public void  delete(Customer customer){
        customers.remove(customer);
    }
}
