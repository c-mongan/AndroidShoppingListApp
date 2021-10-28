package com.example.shoppinglistapplication;

public class Items {

    String name;
    int price;


    public Items(String name, int price) {
        super();
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public Items() {


    }

}
