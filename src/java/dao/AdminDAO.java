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
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
// login admin
public class AdminDAO {

    public static Admin getAdmin(String username, String password) throws Exception {
        Admin result = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select*from Admin where UserName=? and Password=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String user = rs.getString("UserName");
                String pass = rs.getString("Password");

                result = new Admin(username, password);
            }
            cn.close();
        }
        return result;
    }

    // search list customer
    public List<Customer> SearchByName(String txtSearch) {
        List<Customer> list = new ArrayList<>();
        String query = "select * from Customer\n"
                + "where [CustomerName] like ?";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, "%" + txtSearch + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    // manage customer
    public void updateStatus(String id, String Status) {
        String query = "UPDATE [dbo].[Customer]\n"
                + "  SET [Status] = ?\n"
                + "  WHERE [CustomerID] = ?";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, Status);
            pst.setString(2, id);
            pst.executeUpdate();

        } catch (Exception e) {

        }
    }
    //manage services

}
