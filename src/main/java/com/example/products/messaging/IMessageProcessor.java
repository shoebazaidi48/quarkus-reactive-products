package com.example.products.messaging;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public interface IMessageProcessor {

    @Incoming("incoming-message")
    public Uni<Void> processIncomingMessage(Message<JsonObject> message);

    @Outgoing("outgoing-message")
    public Multi<Message<JsonObject>> produceNotification();
}
