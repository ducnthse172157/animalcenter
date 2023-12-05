/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Customer;

import dto.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author huudu
 */
public class UpdateDurationServlet extends HttpServlet {

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
            String id = request.getParameter("txtid");
            String quantity = request.getParameter("txtquantity");
            String type = request.getParameter("btntype");
            //lay gio hang trong session
            HttpSession session = request.getSession();
            HashMap<Service, Integer> order = (HashMap<Service, Integer>) session.getAttribute("order");
            if (order != null) {
                boolean flag = false;
                Service rs = null;
                for (Service s : order.keySet()) {
                    if (s.getServiceId()== Integer.parseInt(id.trim())) {
                        flag = true;
                        rs = s;
                    }
                }
                if (flag) {
                    if (type.equalsIgnoreCase("update")) {//update qquantity
                        order.put(rs, Integer.parseInt(quantity.trim()));
                        session.setAttribute("order", order);
                    } else {//remove item
                        order.remove(rs);

                    }
                }

            }
            response.sendRedirect("MainServlet?action=VIEWBOOKING");
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
