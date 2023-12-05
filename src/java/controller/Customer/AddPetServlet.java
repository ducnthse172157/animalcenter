/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Customer;

import dao.PetDAO;
import dto.Pet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huudu
 */
public class AddPetServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
           String petid=request.getParameter("txtpetid");
           String customerid=request.getParameter("txtcusid");
           String petname=request.getParameter("txtpetname");
           String pettype=request.getParameter("txtpettype");
           //check customerid ko trung voi ai
           Pet p=PetDAO.getPet(petid);
           if(p!=null){ //customerid da co trong bang Customer
               request.setAttribute("THONGBAO", "Petid is already exist!");
               request.getRequestDispatcher("MainServlet?action=ADDPETPAGE").forward(request, response);
           }
           else{// Customerid chua co trong tblCustomer
               String status="Fit";
               int rs=PetDAO.addPet(petid, customerid, petname, pettype, status);
              
               request.setAttribute("THONGBAO", "");
               request.getRequestDispatcher("MainServlet?action=MANAGEPET").forward(request, response);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
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
