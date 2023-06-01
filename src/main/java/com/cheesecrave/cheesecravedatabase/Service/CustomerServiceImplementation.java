package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // built in methods with JPA
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
    @Override
    public void delete(Long accountNumber) {
        customerRepository.deleteById(accountNumber);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long accountNumber) {
        Optional<Customer> customer = customerRepository.findById(accountNumber);
        return customer.orElse(null);
    }

    // custom methods
    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).stream().findFirst().orElse(null);
    }

    @Override
    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName).stream().findFirst().orElse(null);
    }

    @Override
    public Customer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).stream().findFirst().orElse(null);
    }
}
