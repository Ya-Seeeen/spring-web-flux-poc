package xyz.techrick.springwebfluxdemo.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.techrick.springwebfluxdemo.entity.Address;
import xyz.techrick.springwebfluxdemo.entity.Customer;
import xyz.techrick.springwebfluxdemo.service.CustomerService;
import xyz.techrick.springwebfluxdemo.utility.Result;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Mono<Result> saveCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @GetMapping("/get/{customerId}")//R
    public Mono<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @PutMapping("/updateCustomerOrCreate")//U
    public Mono<Result> updateOrCreateCustomer(@RequestBody Customer customer) {
        return customerService.updateExistingOrCreateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")//D
    public Mono<Result> deleteCustomer(@PathVariable("customerId") String customerId) {
        return customerService.deleteCustomerByCustomerId(customerId);
    }

    @PutMapping("/updateCustomer")
    public Mono<Result> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateExistingCustomer(customer);
    }

    @GetMapping("/query/{customerId}")
    public Mono<Address> queryCustomerAddress(@PathVariable("customerId") String customerId) {
        return customerService.queryAddressByCustomerId(customerId);
    }

    @GetMapping("/allCustomerList")
    public Flux<Customer> getAllCustomer() {
        return customerService.getCustomerList();
    }

}