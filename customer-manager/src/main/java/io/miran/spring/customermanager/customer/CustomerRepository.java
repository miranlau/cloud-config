package io.miran.spring.customermanager.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by miran on 2019-01-13.
 */
interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByNameAndEmail(String name, String email);
}
