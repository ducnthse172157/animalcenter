/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author huudu
 */
public class PetDAO {
    // lay danh sach mua hang
    public static List<Pet> getPetListByCus(String CustomerID) throws Exception {
        List<Pet> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "SELECT p.PetID, p.PetName, p.PetType, p.Status\n"
                    + "FROM Pet p\n"
                    + "INNER JOIN Customer c ON p.CustomerID = c.CustomerID\n"
                    + "WHERE c.CustomerID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, CustomerID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("petId");
                    String name = rs.getString("petName");
                    String type = rs.getString("petType");
                    String st = rs.getString("Status");

                    Pet p = new Pet(id, CustomerID, name, type, st);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }

    //loai bo mot pet tu khach hang
    public static void DisablePet(String petId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE Pet\n"
                    + "SET Pet.Status = 'Not Fit'\n"
                    + "FROM Pet \n"
                    + "INNER JOIN Customer ON Pet.CustomerID = Customer.CustomerID\n"
                    + "WHERE Pet.PetID=?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, petId);
            pst.executeUpdate();
        }

    }

    //Cap nhat thong tin Pet
    public static void UpdatePet(String petName, String petType, String petId) throws Exception {

        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE Pet\n"
                    + "SET Pet.PetName = ?,\n"
                    + "Pet.PetType = ?\n"
                    + "FROM Pet \n"
                    + "INNER JOIN Customer ON Pet.CustomerID = Customer.CustomerID\n"
                    + "WHERE Pet.PetID=?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, petName);
            pst.setString(2, petType);
            pst.setString(3, petId);

            pst.executeUpdate();
        }

    }

    //ham lay thong tin pet
    public static Pet getPet(String petId) throws Exception {
        Pet result = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select*from Pet where PetID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            //gan input vao 2 cho dau ?
            pst.setString(1, petId);

            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String pid = rs.getString("PetId");
                String id = rs.getString("CustomerId");
                String name = rs.getString("PetName");
                String type = rs.getString("PetType");
                String stat = rs.getString("Status");
                result = new Pet(pid, id, name, type, stat);
            }
            cn.close();
        }
        return result;
    }

    //ham nay de insert a new Customer vao tblUser
    //tra ve :1/0
    public static int addPet(String petId, String customerid, String petName, String petType, String status) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "INSERT INTO Pet (PetID, CustomerID, PetName,PetType, Status) values(?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, petId);
            pst.setString(2, customerid);
            pst.setString(3, petName);
            pst.setString(4, petType);
            pst.setString(5, status);
            rs = pst.executeUpdate();
        }
        return rs;
    }
}
