package com.cheesecrave.cheesecravedatabase;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Repository.CustomerRepository;
import com.cheesecrave.cheesecravedatabase.Service.CustomerServiceImplementation;
import com.cheesecrave.cheesecravedatabase.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheeseCraveDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheeseCraveDatabaseApplication.class, args);
    }
}
