/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookingDAO;
import dto.Booking;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class CheckPetStatusByPetID extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           
            String id = request.getParameter("txtpetid");
            BookingDAO dao= new BookingDAO();
            List<Booking> list = dao.getBookingByPetID(id);
            int check = dao.checkPetStatus(id);
            switch (check) {
                case 1:
                    request.setAttribute("THONGBAO", "Pet's Status is fit. Can not change booking information.");
                    request.getRequestDispatcher("manageBooking.jsp").forward(request, response);
                    break;
                case -1:
                    request.setAttribute("THONGBAO", "No pet's information");
                    request.getRequestDispatcher("manageBooking.jsp").forward(request, response);
                    break;
                case -2:
                    request.setAttribute("THONGBAO", "Error");
                    request.getRequestDispatcher("manageBooking.jsp").forward(request, response);
                    break;
                case 0:
                    request.setAttribute("listB", list);
                    request.getRequestDispatcher("manageBookingafterSearch.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
            
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
