package com.cheesecrave.cheesecravedatabase;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class CheeseCraveDatabaseApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerRepository mockCustomerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindCustomerById() {
        Long knownAccountNumber = 152L;

        when(mockCustomerRepository.findById(knownAccountNumber)).thenReturn(Optional.of(new Customer()));
        Optional<Customer> testCustomer = customerRepository.findById(knownAccountNumber);

        if (testCustomer.isPresent()) {
            System.out.println("Customer with accountNumber " + knownAccountNumber + " found: " + testCustomer.get().toString());
        } else {
            System.out.println("No customer found with accountNumber " + knownAccountNumber);
        }
    }
}
