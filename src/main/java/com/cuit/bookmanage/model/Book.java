package com.cuit.bookmanage.model;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private String price;

    private Integer status;

    public Book(Integer id, String name, String author, String price, Integer status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}