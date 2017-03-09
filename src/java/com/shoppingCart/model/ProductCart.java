/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingCart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Author : DSLP Created on : Mar 7, 2017, 10:48:35 AM
 *
 */
public class ProductCart {

    private final List<Product> cardItems;
    private List Product;

    public ProductCart() {
        this.cardItems = new ArrayList();
    }

    public List<Product> getProduct() {
        List temp = new ArrayList();
        try {
            String url = "jdbc:derby://localhost:1527/derbyDB";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection(url, "root", "1");
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("select * from product");
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), (float) rs.getDouble(4));
                temp.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public void addItem(int id, String name, String type, double price, int quantity) {
        Product p = null;
        boolean match = false;
        for (com.shoppingCart.model.Product cardItem : cardItems) {
            if (cardItem.getId() == id) {
                p = cardItem;
                setAmount(getAmount() + quantity * p.getPrice());
                p.setQuantity(quantity + p.getQuantity());
                match = true;
                break;
            }
        }
        if (!match) {
            p = new Product();
            p.setId(id);
            p.setName(name);
            p.setPrice((float) price);
            p.setType(type);
            setAmount(getAmount() + quantity * p.getPrice());
            p.setQuantity(quantity);
            cardItems.add(p);
        }
    }

    public void removeItem(int productId) {
        for (int i = 0; i < cardItems.size(); i++) {
            Product p = cardItems.get(i);
            if (p.getId() == productId) {
                setAmount(getAmount() - p.getPrice() * p.getQuantity());
                cardItems.remove(p);
                break;
            }
        }
    }

    public List<Product> getCartItem() {
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
