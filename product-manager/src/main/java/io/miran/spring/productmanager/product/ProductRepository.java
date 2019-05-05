package io.miran.spring.productmanager.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by miran on 2019-01-13.
 */
interface ProductRepository extends JpaRepository<Product, String> {
}
