/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Booking;
import dto.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mylib.DBUtils;


/**
 *
 * @author ASUS
 */
public class BookingDAO {
    
     // lay danh sach mua hang
    public static List<HashMap<String, Object>> getOrderedList(String CustomerID) throws Exception {
        List<HashMap<String, Object>> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "SELECT od.DetailID, b.OrderID, s.ServiceName, od.Duration, b.Total, b.Status\n"
                    + "FROM OrderDetail od\n"
                    + "INNER JOIN Service s ON od.ServiceID = s.ServiceID \n"
                    + "INNER JOIN OrderBooking b ON od.OrderID = b.OrderID\n"
                    + "INNER JOIN Pet p ON b.PetID = p.PetID\n"
                    + "INNER JOIN Customer c ON p.CustomerID = c.CustomerID\n"
                    + "WHERE c.CustomerID = ? And b.Status != 'Cancel'";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, CustomerID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {               
                  while (rs.next()) {
                HashMap<String, Object> o = new HashMap<>();
                o.put("OrderID", rs.getInt("OrderID"));
                o.put("DetailID", rs.getInt("DetailID"));
                o.put("ServiceName", rs.getString("ServiceName"));
                o.put("Duration", rs.getInt("Duration"));
                o.put("Total", rs.getDouble("Total"));
                o.put("Status", rs.getString("Status"));
                list.add(o);
                }
            }
            cn.close();
        }
        return list;
    }
     
    //huy don hang
    public static void cancelOrder(String detailID) throws Exception{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE OrderBooking\n" +
                         "SET OrderBooking.Status = 'Cancel'\n" +
                         "FROM OrderBooking\n" +
                         "INNER JOIN OrderDetail ON OrderBooking.OrderID = OrderDetail.OrderID WHERE OrderDetail.DetailID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, detailID);
            pst.executeUpdate();
            
        }
    }
    //ham nay de insert 1 ddh vao bang Order
    public static int insertOrderfromCus(String petid, double total, String status, HashMap<Service, Integer> order) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            cn.setAutoCommit(false);//tu dong commit 1 cau query
            String sql = "insert [OrderBooking](PetID,CreateDate,Total,Status) values(?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            Date d = new Date(System.currentTimeMillis());
            pst.setString(1, petid);
            pst.setDate(2, d);
            pst.setDouble(3, total);
            pst.setString(4, status);
            rs = pst.executeUpdate();
            //lay orderid cua ket qua lenh insert o tren
            if (rs > 0) {
                sql = "Select top 1 OrderID\n"
                        + "from[OrderBooking] \n"
                        + "order by OrderID desc";
                pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    int orderid = table.getInt("OrderID");
                    for (Service s : order.keySet()) {
                        int serviceid = s.getServiceId();
                        int duration = order.get(s);
                        sql = "insert OrderDetail (OrderID,ServiceID,Duration)\n"
                                + "values(?,?,?)";
                        pst = cn.prepareStatement(sql);
                        pst.setInt(1, orderid);
                        pst.setInt(2, serviceid);
                        pst.setInt(3, duration);
                        pst.executeUpdate();
                    }
                }
            }
            cn.commit();//xac nhan ket thuc trang session
            cn.setAutoCommit(true);
        }
        return rs;
    }
    
    public List<Booking> getAllBooking1() {
        List<Booking> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = " SELECT *\n" +
            "  FROM [dbo].[OrderBooking]";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String orderid = rs.getString(1);
                    String petid = rs.getString(2);
                    String createdate = rs.getString(3);
                    String total = rs.getString(4);
                    String checkindate = rs.getString(5);
                    String checkoutdate = rs.getString(6);
                    String status = rs.getString(7);
                    
                    
                    
                    
                    
                    
                    Booking s = new Booking(orderid, petid, createdate,total, checkindate, checkoutdate, status);
                    list.add(s);
                }
                
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return list;
    }
    
    
    public List<Booking> getBookingByPetID(String petID) {
        List<Booking> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = " SELECT *\n" +
            "  FROM [dbo].[OrderBooking] \n"
                    + "WHERE PetID= ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, petID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String orderid = rs.getString(1);
                    String petid = rs.getString(2);
                    String createdate = rs.getString(3);
                    String total = rs.getString(4);
                    String checkindate = rs.getString(5);
                    String checkoutdate = rs.getString(6);
                    String status = rs.getString(7);
                    

                    Booking s = new Booking(orderid, petid, createdate,total, checkindate, checkoutdate, status);
                    list.add(s);
                }
                
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return list;
    }
    
    
    
    public List<Booking> getBookingByOrderID(String orderID) {
        List<Booking> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = " SELECT *\n" +
            "  FROM [dbo].[OrderBooking] \n"
                    + "WHERE OrderID= ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,  orderID);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String orderid = rs.getString(1);
                    String petid = rs.getString(2);
                    String createdate = rs.getString(3);
                    String total = rs.getString(4);
                    String checkindate = rs.getString(5);
                    String checkoutdate = rs.getString(6);
                    String status = rs.getString(7);
                    

                    Booking s = new Booking(orderid, petid, createdate,total, checkindate, checkoutdate, status);
                    list.add(s);
                }
                
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return list;
    }
   
    public void updateStatusBooking(String id, String Status) {
        String query = "UPDATE [dbo].[OrderBooking]\n"
                + "SET [Status] = ?\n"
                + "WHERE [OrderID] = ?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, Status);
            pst.setString(2,id);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
        }  
    }    
        
        
      public int checkPetStatus(String id) {
        String query = "SELECT PetID, Status FROM [dbo].[Pet] WHERE PetID =?";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            
            if (rs.next()) {
            String status = rs.getString("Status");
            if (status != null && status.equals("Fit")) {
                return 1;
            } else {
                return 0; // The status is not "Fit."
            }
        } else {
            return -1; // No pet found for the given CustomerID.
        }

           
        } catch (Exception e) {
            e.printStackTrace(); 
            return -2; 
//            Return an error code to indicate an issue.
        }
        
    }
      
      
      
         public void updateBooking(String or_id, String pet_id, String createDate, String total, String checkin, String checkout, String Status) {
        String query = "UPDATE [dbo].[OrderBooking]\n"
                + "SET "
                + "      [PetID] = ?\n"
                + "      ,[CreateDate] =? \n"
                + "      ,[Total] =? \n"
                + "      ,[CheckinDate] =? \n"
                + "      ,[CheckoutDate] =? \n"
                + "      ,[Status] =? \n"
                + "WHERE [OrderID] = ?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(7, or_id);
            pst.setString(1, pet_id);
            pst.setString(2, createDate);
            pst.setString(3, total);
            pst.setString(4, checkin);
            pst.setString(5, checkout);
            pst.setString(6, Status);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
        }  
    }  
      
      public static void main(String[] args) {
        BookingDAO dao = new BookingDAO();
        int a = dao.checkPetStatus("2");
        List<Booking> d = dao.getBookingByOrderID("2");
          System.out.println(d);
    }
        
}
    
    
    
    
    

