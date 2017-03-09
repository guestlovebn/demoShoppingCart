/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shoppingCart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Author     : Tien Nguyen
 * Created on : Mar 7, 2017, 10:48:35 AM
 *
 */
public class ProductCart {
    private final List<Product> cardItems;
    private List Product;

    public ProductCart() {
        this.cardItems = new ArrayList();
    }
    
    public List<Product> getProduct(){
        List temp = new ArrayList();
        try {
            
            String url = "jdbc:derby://localhost:1527/ShopingCart";  
            Connection con = DriverManager.getConnection(url,"sa","sa");
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("select * from");
            while(rs.next()){
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                temp.add(p);
            }
        } catch (Exception e) {
        }
        
        return temp;
    }
    
    public void addItem(int id, String name, String type, float price, int quantity){
        Product p = null;
        boolean match = false;
        for (com.shoppingCart.model.Product cardItem : cardItems) {
            if (cardItem.getId() == id) {
                p = cardItem;
                setAmount(getAmount() + quantity + p.getPrice());
                p.setQuantity(quantity + p.getQuantity());
                match = true;
                break;
            }
        }
        if(!match){
            p = new Product();
            p.setId(id);
            p.setName(name);
            p.setPrice(price);
            p.setType(type);
            setAmount(getAmount() + quantity + p.getPrice());
            p.setQuantity(quantity);
            cardItems.add(p);
        }
    }
    
    
    public void removeItem(int productId){
        for (int i = 0; i < cardItems.size(); i++) {
            Product p = cardItems.get(i);
            if(p.getId() == productId){
                setAmount(getAmount() - p.getPrice() * p.getQuantity());
                cardItems.remove(p);
                break;
            }
        }
    }
    
    public List<Product> getCartItem(){
        return cardItems;
    }
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
}
