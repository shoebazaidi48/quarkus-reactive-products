package com.example.products.messaging;

//import com.example.products.builder.NotificationBuilder;
import com.example.products.model.Notification;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
//import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
public class NotificationProducer implements IMessageProcessor{
    private static final List<String> CATEGORIES = List.of("Books", "Electronics", "Grocery", "Toys", "Clothing");
    private final Random random = new Random();

    @Override
    public Uni<Void> processIncomingMessage(Message<JsonObject> message) {
        return null;
    }

    @Override
    @Outgoing("notifications-out")
    public Multi<Message<JsonObject>> produceNotification() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(10))
                .onItem().transform(i -> randomNotification());
    }

    private Message<JsonObject> randomNotification() {
        String id = UUID.randomUUID().toString();
        String name = "Notification-" + id.substring(0, 8);
        String category = CATEGORIES.get(random.nextInt(CATEGORIES.size()));

        Notification notification = new Notification.SomeBuilder()
                .id(id)
                .type(category)
                .title(name)
                .message("Your order #ORD-12345 has been shipped.")
                .timestamp(ZonedDateTime.now())
                .priority("high")
                .related(Map.of("orderId", "ORD-12345", "trackingUrl", "https://track.example.com/ORD-12345"))
                .status("unread")
                .build();

        JsonObject jsonObject = JsonObject.mapFrom(notification);
        Message<JsonObject> jsonObjectMessage = Message.of(jsonObject);

        LOG.infov("Producing notification : {0}", jsonObjectMessage.getPayload());
        return jsonObjectMessage;
    }
}
