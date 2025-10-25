package com.example.products.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.ZonedDateTime;
import java.util.Map;

@RegisterForReflection
public class Notification {

    private String id;
    private String type;
    private String title;
    private String message;
    private ZonedDateTime timestamp;
    private String priority;
    private Map<String, String> related;
    private String status;
    private SomeBuilder builder;

    public Notification() {
    }

    private Notification(SomeBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.title = builder.title;
        this.message = builder.message;
        this.timestamp = builder.timestamp;
        this.priority = builder.priority;
        this.related = builder.related;
        this.status = builder.status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Map<String, String> getRelated() {
        return related;
    }

    public void setRelated(Map<String, String> related) {
        this.related = related;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", priority='" + priority + '\'' +
                ", related=" + related +
                ", status='" + status + '\'' +
                '}';
    }


    public static class SomeBuilder {

        private String id;
        private String type;
        private String title;
        private String message;
        private ZonedDateTime timestamp;
        private String priority;
        private Map<String, String> related;
        private String status;

        public SomeBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SomeBuilder type(String type) {
            this.type = type;
            return this;
        }

        public SomeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SomeBuilder message(String message) {
            this.message = message;
            return this;
        }

        public SomeBuilder timestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public SomeBuilder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public SomeBuilder related(Map<String, String> related) {
            this.related = related;
            return this;
        }

        public SomeBuilder status(String status) {
            this.status = status;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}

