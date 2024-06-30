package pl.jpaluch.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PayuTest {

    @Test
    void itRegisterNewPayment() {
        Payu payu = thereIsPayU();
        OrderCreateRequest request = thereIsExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(request);

        assertNotNull(response.getOrderId());
        assertNotNull(response.getRedirectUri());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        var request = new OrderCreateRequest();
        request
                .setNotifyUrl("https://your.eshop.com/notify")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("420746")
                .setDescription("My digital product")
                .setCurrencyCode("PLN")
                .setTotalAmount(15500)
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer(new Buyer()
                        .setEmail("jan.paluch@example.com")
                        .setFirstName("jan")
                        .setLastName("paluch")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Nice product")
                                .setUnitPrice(15500)
                                .setQuantity(1)
                ));

        return request;
    }

    private Payu thereIsPayU() {
        return new Payu(
                new RestTemplate(),
                PayuCredentials.sandbox(
                        "420746",
                        "2ee86a66e5d97e3fadc400c9f19b065d"
                ));
    }
}
