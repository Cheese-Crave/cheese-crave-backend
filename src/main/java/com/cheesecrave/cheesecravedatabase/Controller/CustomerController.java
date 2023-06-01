package com.cheesecrave.cheesecravedatabase.Controller;

import com.cheesecrave.cheesecravedatabase.Model.Customer;
import com.cheesecrave.cheesecravedatabase.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService ) {
        this.customerService = customerService;
    }

    @GetMapping("/account")
    public Iterable<Customer> get() {
        return customerService.findAll();
    }

    @PutMapping ("/new") //automatically creates and saves customers
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @DeleteMapping ("/delete")
    public void delete(@RequestBody Customer customer) {
        customerService.delete(customer);
    }
}
