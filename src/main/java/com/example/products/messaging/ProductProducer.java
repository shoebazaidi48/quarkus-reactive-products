package com.example.products.messaging;

import com.example.products.model.Product;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
public class ProductProducer {

    private static final Logger LOG = Logger.getLogger(ProductProducer.class);
    private static final List<String> CATEGORIES = List.of("Books", "Electronics", "Grocery", "Toys", "Clothing");
    private final Random random = new Random();

    /**
     * Emits a new random Product every second to the "products-out" channel.
     */
    @Outgoing("products-out")
    public Multi<Message<Product>> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(30))
                .onItem().transform(i -> randomProduct());
    }

    private Message<Product> randomProduct() {
        String id = UUID.randomUUID().toString();
        String name = "Product-" + id.substring(0, 8);
        String category = CATEGORIES.get(random.nextInt(CATEGORIES.size()));
        double price = Math.round((10 + random.nextDouble() * 90) * 100.0) / 100.0; // $10–$100

        Product product = new Product(id, name, category, price);
        Message<Product> productMessage = Message.of(product);
        LOG.infov("Producing product : {0}", productMessage.getPayload());
        return productMessage;
    }
}
