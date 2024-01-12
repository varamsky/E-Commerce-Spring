package com.example.ecommerce.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column
    private String color;

    @Column
    private String size;

    @Column
    private Double discount;

    @Column
    private String category;

    @Column(nullable = false)
    private String slug;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime modifiedAt;

    @OneToMany(mappedBy = "product")
    private Set<CartItem> productCartItems;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> productOrderItems;

    public Product() {}

    public Product(Integer id, String title, String description, Integer quantity, Double price, String color, String size, Double discount, String category, String slug, OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.size = size;
        this.discount = discount;
        this.category = category;
        this.slug = slug;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(final Double discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(final String slug) {
        this.slug = slug;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Set<CartItem> getProductCartItems() {
        return productCartItems;
    }

    public void setProductCartItems(final Set<CartItem> productCartItems) {
        this.productCartItems = productCartItems;
    }

    public Set<OrderItem> getProductOrderItems() {
        return productOrderItems;
    }

    public void setProductOrderItems(final Set<OrderItem> productOrderItems) {
        this.productOrderItems = productOrderItems;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", discount=" + discount +
                ", category='" + category + '\'' +
                ", slug='" + slug + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}