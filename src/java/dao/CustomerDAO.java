/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Admin;
import dto.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;

/**
 *
 * @author huudu
 */
public class CustomerDAO {
    public static Customer getUser(String customerid, String password) throws Exception{
        Customer result=null;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            String sql = "select*from Customer where CustomerID=? and Password=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, customerid);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            if(rs!=null && rs.next()){
                String id=rs.getString("CustomerId");
                String name=rs.getString("CustomerName");
                String pwd=rs.getString("Password");
                String sdt=rs.getString("Phone");
                String r=rs.getString("Role");
                String stat=rs.getString("Status");
                result=new Customer(id, name, pwd, sdt,r , stat);
            }
            cn.close();
        }
        return result;
    }
     public static Customer CheckStatus(String status) throws Exception{
        Customer result=null;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            String sql = "select*from Customer where Status=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, status);            
            ResultSet rs=pst.executeQuery();
            if(rs!=null && rs.next()){
                String id=rs.getString("CustomerId");
                String name=rs.getString("CustomerName");
                String pwd=rs.getString("Password");
                String sdt=rs.getString("Phone");
                String r=rs.getString("Role");
                String stat=rs.getString("Status");
                result=new Customer(id, name, pwd, sdt,r, stat);
            }
            cn.close();
        }
        return result;
    }
    //ham nay de lay user khi biet userid
    public static Customer getCustomer(String customerid) throws Exception{
        Customer result=null;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            String sql = "select*from Customer where CustomerID=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, customerid);
          
            ResultSet rs=pst.executeQuery();
            if(rs!=null && rs.next()){
                String id=rs.getString("CustomerId");
                String name=rs.getString("CustomerName");
                String pwd=rs.getString("Password");
                String sdt=rs.getString("Phone");
                String r=rs.getString("Role");
                String stat=rs.getString("Status");
                result=new Customer(id, name, pwd, sdt,r, stat);
            }
            cn.close();
        }
        return result;
    }
    //ham nay de insert a new Customer vao tblUser
    //tra ve :1/0
    public static int insertCustomer(String customerid,String customername,String password,String phone,String role,String status) throws Exception{
        int rs=0;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
              String sql="insert into Customer(CustomerID, CustomerName, Password, Phone,Role, Status) values(?,?,?,?,?,?)";         
              PreparedStatement pst=cn.prepareStatement(sql);
              pst.setString(1, customerid);
              pst.setString(2, customername);
              pst.setString(3, password);
              pst.setString(4, phone);
              pst.setString(5, role);
              pst.setString(6, status);
              rs=pst.executeUpdate();
        }
        return rs;
    }   
    
    
    
    public static Admin getAdmin(String username, String password) throws Exception{
        Admin result=null;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            String sql = "select*from Admin where UserName=? and Password=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            if(rs!=null && rs.next()){
                String user=rs.getString("UserName");
                String pass=rs.getString("Password");
           
                result=new Admin(username,password);
            }
            cn.close();
        }
        return result;
    }
}


