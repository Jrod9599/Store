package com.company;

public class Products {
    private String name;
    private String description;
    private double price;
    boolean inCart;

    public Products(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price  = price;
        inCart = false;
    }

    public double getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

}
