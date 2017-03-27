/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.jpa.web.servlet.basics.controller;

import edu.wctc.jpa.web.servlet.basics.ejb.ManufacturerFacade;
import edu.wctc.jpa.web.servlet.basics.ejb.ProductFacade;
import edu.wctc.jpa.web.servlet.basics.model.Manufacturer;
import edu.wctc.jpa.web.servlet.basics.model.Product;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jlombardo
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /*
     * This is how you use dependency injectin to inject an EJB Session
     * bean into this servlet. Note that these beans are "stateless" so
     * it doesn't matter that they exist as properties of a Singleton.
     */
    @EJB
    private ProductFacade productService;
    @EJB
    private ManufacturerFacade mfgService;

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
        
        response.setContentType("text/html;charset=UTF-8");
        String destination = "/results.jsp";
        String action = request.getParameter("action");
        
        if (action != null && action.equals("getAllMfgs")) {
            //List<Manufacturer> mfgs = mfgService.findAll();
            List<Manufacturer> mfgs = mfgService.findByState("CA");
            request.setAttribute("mfgs", mfgs);
            
        } else if(action != null && action.equals("getAllProducts")) {
            List<Product> products = productService.findAll();
            request.setAttribute("products", products);
        }
        
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);

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
        processRequest(request, response);
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
