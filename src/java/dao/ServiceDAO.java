/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Service;
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
public class ServiceDAO {

     public static ArrayList<Service> getService(String serviceName) throws Exception {
        ArrayList<Service> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service where ServiceName like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%"+ serviceName+"%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("serviceId");
                    String name = rs.getString("serviceName");
                    float price = rs.getFloat("price");
                    String st = rs.getString("status");
                    Service s = new Service(id, name, price, st);
                    list.add(s);
                }
            }
            cn.close();
        }
        return list;
    }
    
    
    public List<Service> getAllService() {
        List<Service> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service ";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String status = rs.getString(4);
                    
                    Service s = new Service(id, name, price,status);
                    list.add(s);
                }
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return list;
    }
   
    public Service getServiceByID(String service_id){
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service where ServiceID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, service_id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String status = rs.getString(4);
                    Service s = new Service(id, name, price,status);
return s;
                }
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return null;
    }
    
    
    
    public List<Service> getServiceByPrice(int service_price) {
        List<Service> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service where Price<= ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, service_price);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String status = rs.getString(4);
                    Service s = new Service(id, name, price,status);
                    list.add(s);
                }
            }
            cn.close();
        }
        }catch(Exception e){
            
        }
        return list;
    }
    
    public List<Service> getServiceByPriceASC() {
        List<Service> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service ORDER BY Price";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String status = rs.getString(4);
                    Service s = new Service(id, name, price,status);
                    list.add(s);
                }
            }
            cn.close();
        }
        }catch(Exception e){
            
        }
        return list;
    }
    
    public List<Service> getServiceByPriceDESC() {
        List<Service> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Service ORDER BY Price DESC";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String status = rs.getString(4);
                    Service s = new Service(id, name, price,status);
                    list.add(s);
                }
            }
            cn.close();
        }
        }catch(Exception e){
            
        }
        return list;
    }
    
    public void updateStatusService(String id, String Status) {
        String query = "UPDATE [dbo].[Service]\n"
+ "SET [Status] = ?\n"
                + "WHERE [ServiceID] = ?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, Status);
            pst.setString(2,id);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
        }  
    }
   
    public void updateStatus(String id, String Status){
        String query= "UPDATE [dbo].[Customer]\n" +
                        "  SET [Status] = ?\n" +
                        "  WHERE [CustomerID] = ?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, Status);
            pst.setString(2,id);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
            
        }
    }
    
    public void updateService(int id, String name, float price , String Status){
        String query= "UPDATE [dbo].[Service]\n" +
                        "SET [ServiceName]= ?,[Price]=?,[Status]=?\n" +
                        "WHERE [ServiceID]=?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, name);
            pst.setFloat(2, price);
            pst.setString(3, Status);
            pst.setInt(4,id);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
            
        }
    }
    
    
    
    public void createService(int id, String name, int price, String status){
        String query= "INSERT INTO Service  \n" +
                "([ServiceID],[ServiceName],[Price],[Status]) \n"+
                    "values(?,?,?,?)";
        try {
        Connection cn=DBUtils.makeConnection();
        PreparedStatement pst = cn.prepareStatement(query);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setInt(3, price);
        pst.setString(4, status);
        pst.executeUpdate();
        
        
        
        } catch (Exception e) {
        }
    }
    
    

    public static void main(String[] args) {
        ServiceDAO dao = new ServiceDAO();
        List<Service> s =  dao.getAllService();
        System.out.println(s);
    }
    
}
    

