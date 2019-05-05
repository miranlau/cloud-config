package io.miran.spring.productmanager.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by miran on 2019-01-13.
 */
interface ProductSubscriptionRepository extends JpaRepository<ProductSubscription, ProductSubscriptionId> {
    List<ProductSubscription> findByIdCustomerId(Long id);
    Optional<ProductSubscription> findByIdCustomerIdAndIdProductCode(Long id, String code);
}
