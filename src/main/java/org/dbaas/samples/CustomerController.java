package org.dbaas.samples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    private final CustomerRepository customers;

    public CustomerController(CustomerRepository repo) {
        this.customers = repo;
    }

    @PostMapping("/customer")
    public Mono<Customer> create(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        return this.customers.save(customer);
    }

    @GetMapping("/customer")
    public Flux<Customer> get(@RequestParam String lastName) {
        return this.customers.findByLastName(lastName);
    }

    @GetMapping("/customers")
    public Flux<Customer> getAll() {
        return this.customers.findAll();
    }
}
