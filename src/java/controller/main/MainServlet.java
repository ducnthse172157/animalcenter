/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

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
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOGIN_PAGE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            }
//            your code here
            else if(action.equals("LOGIN")){
                url = "CusLoginServlet";
            }else if(action.equals("LOGOUT")){
                url = "CusLogoutServlet";
            }else if(action.equals("SIGNUPFORM")){
                url = "signup.jsp";
            }else if(action.equals("SIGNUP")){
                url = "CusSignupServlet";
            }
            //Cus Main controller
            else if(action.equals("HOME")){
                url = "homepage.jsp";
            }else if(action.equals("MANAGEPET")){
                url = "CusPetListServlet";
            }
            else if(action.equals("MANAGEPETPAGE")){
                url = "managepet.jsp";
            }else if(action.equals("ADDPETPAGE")){
                url = "addpet.jsp";
            }else if(action.equals("ADDPET")){
                url = "AddPetServlet";
            }else if(action.equals("EDITPETPAGE")){
                url = "editpet.jsp";
            }else if(action.equals("UPDATEPET")){
                url = "UpdatePetServlet";
            }else if(action.equals("SEARCH")){
                url = "SearchServlet";
            }else if(action.equals("VIEWBOOKING")){
                url = "viewbooking.jsp";
            }else if(action.equals("UPDATEBOOKING")){
                url = "UpdateDurationServlet";
            }else if(action.equals("SAVEBOOKING")){
                url = "SaveOrderServlet";
            }else if(action.equals("ORDERHISTORY")){
                url = "OrderHistoryServlet";
            }else if(action.equals("ORDERHISTORYPAGE")){
                url = "viewordered.jsp";
            }else if(action.equals("FEEDBACK")){
                url = "CusFeedbackServlet";
            }else if(action.equals("FEEDBACKPAGE")){
                url = "feedback.jsp";
                
                    //Admin main controller
            }else if(action.equals("ADMIN")){
                url = "adminpage.jsp";
            }
            else if(action.equals("MANAGESERVICE")){
                url = "ServiceServlet";
            }else if(action.equals("ADMINSEARCH")){
                url = "AdminSearchServlet";
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
