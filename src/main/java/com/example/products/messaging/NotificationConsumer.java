package com.example.products.messaging;

import com.example.products.model.Notification;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;


@ApplicationScoped
public class NotificationConsumer implements IMessageProcessor{
    private static final Logger LOG = Logger.getLogger(NotificationConsumer.class);

    @Override
    @Incoming("notifications-in")
    public Uni<Void> processIncomingMessage(Message<JsonObject> message) {
        JsonObject notificationJsonObject = message.getPayload();
        Notification notification = notificationJsonObject.mapTo(Notification.class);
        LOG.infov("Consumed notification: {0}", notification);
        return Uni.createFrom().nullItem();
    }

    @Override
    public Multi<Message<JsonObject>> produceNotification() {
        return null;
    }
}
