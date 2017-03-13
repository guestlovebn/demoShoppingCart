/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingCart.model;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FIA
 */
public class BillExtractor {

    private List<Product> productList;
    private String customerName;
    private String customerMail;
    private String date;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BillExtractor(List<Product> productList, String customerName, String customerMail) {
        this.productList = productList;
        this.customerName = customerName;
        this.customerMail = customerMail;
    }

    private BillExtractor() {

    }

    public String extractBill() {
        StringWriter writer = new StringWriter();
        writer.append(customerName);
        writer.append("\n");
        float totalAmount = 0;
        java.util.Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        writer.append(df.format(date));
        writer.append("\n");
        writer.append("Details");
        writer.append("\n");
        for (Product product : productList) {
            writer.append(product.getName());
            writer.append("\t");
            writer.append(product.getType());
            writer.append("\t");
            writer.append(product.getPrice() + "");
            writer.append("\t");
            writer.append(product.getQuantity() + "");
            writer.append("\t");
            totalAmount += product.getQuantity() * product.getPrice();
            writer.append((product.getQuantity() * product.getPrice()) + "");
            writer.append("\n");
        }
        writer.append("Total cost:");
        writer.append("\t");
        writer.append(totalAmount + "");
        return writer.toString();
    }
    
}
