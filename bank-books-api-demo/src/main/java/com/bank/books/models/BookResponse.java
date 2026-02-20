package com.bank.books.models;

public class BookResponse {

    private Long id;
    private String title;
    private String author;

    ///@Mask( maskSymbol = '*', maskingEnd = 2, maskingStart = 10)
    private String email;

    //@Mask(maskingStart = 3, maskingEnd = 2, maskSymbol = '*')
    private String phoneNumber;

    // default constructor
    public BookResponse() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}