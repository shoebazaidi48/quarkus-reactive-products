package com.example.products.messaging;

import com.example.products.model.Product;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;


@ApplicationScoped
public class ProductConsumer {
    private static final Logger LOG = Logger.getLogger(ProductConsumer.class);

    /**
     * Consumes from the "products-in" channel (AMQP address/queue: products).
     */
//    @Incoming("products-in")
//    public void consume(Product product) {
//        LOG.infov("Consumed: {0}", product);
//        // Do useful work here (persist, call downstream, etc.)
//    }

//    @Incoming("products-in")
//    public void consume(JsonObject product) {
//        Product product1 = product.mapTo(Product.class);
//        LOG.infov("Consumed: {0}", product1);
//        // Do useful work here (persist, call downstream, etc.)
//    }

    @Incoming("products-in")
    public Uni<Void> process(Message<Product> product) {
        Product productFromPayload = product.getPayload();
        LOG.infov("Consumed: {0}", productFromPayload);
        // Do useful work here (persist, call downstream, etc.)
        return Uni.createFrom().nullItem();
    }
}
