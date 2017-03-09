/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shoppingCart.model;

/**
 * 
 * Author     : Tien Nguyen
 * Created on : Mar 7, 2017, 10:37:09 AM
 *
 */
public class Product {
    private int id;
    private String name;
    private String type;
    private float price;
private int quantity;
    
    public Product() {
    }

    public Product(int id, String name, String type, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
