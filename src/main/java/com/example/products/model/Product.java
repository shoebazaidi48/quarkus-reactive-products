package com.example.products.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;

    public Product() {}

//    @JsonCreator
//    public Product(@JsonProperty("id") String id,
//                   @JsonProperty("name") String name,
//                   @JsonProperty("category") String category,
//                   @JsonProperty("price") double price) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//    }

////    @JsonCreator
    public Product(String id,
                   String name,
                   String category,
                   double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
