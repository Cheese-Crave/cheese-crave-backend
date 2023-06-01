package com.cheesecrave.cheesecravedatabase.Service;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    // built in methods with JPA
    void save(Customer customer);
    void delete(Customer customer);
    void delete(Long accountNumber);
    Iterable<Customer> findAll();
    Customer findById(Long accountNumber);

    // custom methods
    Customer findByEmail( String email );
    Customer findByFirstName( String firstName );
    Customer findByLastName( String lastName );
}
