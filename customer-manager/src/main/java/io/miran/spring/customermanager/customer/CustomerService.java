package io.miran.spring.customermanager.customer;

import io.miran.spring.customermanager.infrastructure.exception.BadRequestException;
import io.miran.spring.customermanager.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by miran on 2019-01-13.
 */
@Service
@RefreshScope
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final String premiumEmailSuffix;

    public CustomerService(CustomerRepository customerRepository, @Value("${premium-email-suffix}") String premiumEmailSuffix) {
        this.customerRepository = customerRepository;
        this.premiumEmailSuffix = premiumEmailSuffix;
    }

    List<Customer> findAll() {
        return customerRepository.findAll();
    }

    List<Customer> findAllPremium() {
        return findAll().stream().filter(it -> it.getEmail().endsWith(premiumEmailSuffix)).collect(toList());
    }

    Customer findOne(Long id) {
        return customerRepository.findById(id).orElseThrow(customerNotFound(id));
    }

    Customer createCustomer(Customer from) {
        if (customerRepository.findByNameAndEmail(from.getName(), from.getEmail()).isPresent()) {
            throw new BadRequestException(String.format("Customer with name %s and email %s already exists", from.getName(), from.getEmail()));
        } else {
            return customerRepository.save(new Customer(from.getName(), from.getEmail()));
        }
    }

    private Supplier<NotFoundException> customerNotFound(Long id) {
        return () -> new NotFoundException(String.format("Customer with id %n not found", id));
    }
}
