/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingCart.controller;

import com.shoppingCart.model.Product;
import com.shoppingCart.model.ProductCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DSLP
 */
public class ShoppingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("shoppingError.jsp");
        }
//        String products=request.getParameter("products");
//        String[] data=products.split("|");
//        Product product=new Product(Integer.parseInt(data[0]),data[1],data[2],Float.parseFloat(data[3]));
        ProductCart buyList = (ProductCart) session.getAttribute("prod");
        String action = request.getParameter("action");
        if (!action.equalsIgnoreCase("checkout")) {
            if (action.equalsIgnoreCase("delete")) {
                int productId = Integer.parseInt(request.getParameter("delItem"));
                buyList.removeItem(productId);
            } else {
                if (action.equalsIgnoreCase("add")) {
                    if (buyList == null) {
                        buyList = new ProductCart();

                    }
                    addProduct(request, response, buyList);
                    session.setAttribute("prod", buyList);

                } else {
                    if (action.equalsIgnoreCase("checkout")) {
                        RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response, ProductCart product) {
        String myProduct = request.getParameter("products");
        String quantity = request.getParameter("quantity");
        if (!validateQuantity(quantity)) {
            try {
                ServletContext sr = getServletContext();
                RequestDispatcher rd = sr.getRequestDispatcher("shoppingError.jsp");
                request.setAttribute("msg", "Quantity should be a positive nonzero value.");
                rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ShoppingServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShoppingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }

        StringTokenizer t = new StringTokenizer(myProduct, "|");
        Integer productId = new Integer(t.nextToken());
        String name = t.nextToken();
        String type = t.nextToken();
        Float price = new Float(t.nextToken());
        product.addItem(productId.intValue(), name, type, price, Integer.parseInt(quantity));

    }

    private boolean validateQuantity(String quantity) {
        boolean vali = false;
        for (int i = 0; i < quantity.length(); i++) {
            if ("0123456789".indexOf(quantity.charAt(i)) >= 0) {
                vali = true;
            } else {
                vali = false;
                break;
            }

        }

        if (!vali) {
            return false;
        } else {
            if (Integer.parseInt(quantity) == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
