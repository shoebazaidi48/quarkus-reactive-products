package com.example.products.builder;

import com.example.products.model.Notification;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.ZonedDateTime;
import java.util.Map;

@ApplicationScoped
public class NotificationBuilder {

    private String id;
    private String type;
    private String title;
    private String message;
    private ZonedDateTime timestamp;
    private String priority;
    private Map<String, String> related;
    private String status;

    public NotificationBuilder id(String id) {
        this.id = id;
        return this;
    }

    public NotificationBuilder type(String type) {
        this.type = type;
        return this;
    }

    public NotificationBuilder title(String title) {
        this.title = title;
        return this;
    }

    public NotificationBuilder message(String message) {
        this.message = message;
        return this;
    }

    public NotificationBuilder timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public NotificationBuilder priority(String priority) {
        this.priority = priority;
        return this;
    }

    public NotificationBuilder related(Map<String, String> related) {
        this.related = related;
        return this;
    }

    public NotificationBuilder status(String status) {
        this.status = status;
        return this;
    }

//    public Notification build() {
//        return new Notification(this);
//    }
}

