/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Customer;
import dao.CustomerDAO;
import dto.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author huudu
 */
public class CusSignupServlet extends HttpServlet {

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
           String customerid=request.getParameter("txtcusid");
           String customername=request.getParameter("txtcusname");
           String password=request.getParameter("txtpwd");
           String phone=request.getParameter("txtphone");
           //check customerid ko trung voi ai
           Customer cus=CustomerDAO.getCustomer(customerid);
           if(cus!=null){ //customerid da co trong bang Customer
               request.setAttribute("THONGBAO", "Customerid is already exist!");
               request.getRequestDispatcher("MainServlet?action=SIGNUPFORM").forward(request, response);
           }
           else{// Customerid chua co trong tblCustomer
               String status="Active";
               String role="Cus";
               int rs=CustomerDAO.insertCustomer(customerid, customername, password, phone,role, status);
               HttpSession session = request.getSession();
               session.setAttribute("THONGBAO", "");
               request.getRequestDispatcher("MainServlet?action=LOGIN_PAGE").forward(request, response);
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
