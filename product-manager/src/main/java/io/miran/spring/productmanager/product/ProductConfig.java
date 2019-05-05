package io.miran.spring.productmanager.product;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by miran on 2019-01-13.
 */
@Component
@ConfigurationProperties(prefix = "products")
public class ProductConfig {
    private List<String> exclusives;

    public List<String> getExclusives() {
        return exclusives;
    }

    public void setExclusives(List<String> exclusives) {
        this.exclusives = exclusives;
    }
}
