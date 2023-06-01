package com.cheesecrave.cheesecravedatabase.Repository;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // returns all customers by first name
    List<Customer> findByFirstName(String firstName);

    // returns all customers by last name
    List<Customer> findByLastName(String LastName);

    // returns all customers by email
    List<Customer> findByEmail(String email);
}

