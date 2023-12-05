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
public class AddServiceServlet extends HttpServlet {

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
          String id = request.getParameter("txtserid");
            String name = request.getParameter("txtsername");
            String price = request.getParameter("txtprice");
            String st = request.getParameter("txtstatus");
            //dua vao id nay lay thong tin item trong db
            //do demo ko co nen db sd code
            if (st.equals("Available")) {
                Service it = new Service(Integer.parseInt(id.trim()), name, Float.parseFloat(price.trim()), st);

                //dua it vao gio hang(cart)
                //lay vung nho session
                HttpSession session = request.getSession();
                HashMap<Service, Integer> order = (HashMap<Service, Integer>) session.getAttribute("order");

                if (order == null) {
                    order = new HashMap<>();
                    order.put(it, 1);
                } else {
                    boolean flag = false;
                    for (Service tmp : order.keySet()) {
                        if (tmp.getServiceId() == it.getServiceId()) {
                            flag = true;
                            int duration = order.get(tmp);
                            duration++;
                            order.put(tmp, duration);
                        }
                    }
                    if (!flag) {
                        order.put(it, 1);
                    }
                }
                //luu cart vao session cho lan buy ssau
                session.setAttribute("order", order);
                response.sendRedirect("MainServlet?action=HOME");

            } else {
                // Service is not 'Available', provide feedback to the user
                request.setAttribute("ERROR", "Sorry, this service is unavailable for you.");
                request.getRequestDispatcher("MainServlet?action=HOME").forward(request, response);
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
