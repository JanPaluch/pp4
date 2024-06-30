package pl.jpaluch.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapProductStorageTest {

    public static final String productname= "example product";

    @Test
    void itStoresAndLoadProduct() {
        var product = thereIsExampleProduct();
        var productStorage = thereIsProductStorage();

        productStorage.addProduct(product);

        List<Product> products = productStorage.allProducts();

        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains(productname);
    }

    @Test
    void itStoresAndLoadById() {
        var product = thereIsExampleProduct();
        var productStorage = thereIsProductStorage();

        productStorage.addProduct(product);
        var loaded = productStorage.getProductBy(product.getId());

        assertThat(loaded.getId()).isEqualTo(product.getId());
    }

    private HashMapProductStorage thereIsProductStorage() {
        return new HashMapProductStorage();
    }

    private Product thereIsExampleProduct() {
        var product = new Product(UUID.randomUUID(), productname, "nice one");
        product.changePrice(BigDecimal.valueOf(10.10));

        return product;
    }
}