/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Feedback;
import dto.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
public class FeedbackDAO {
    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Feedback ";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String feedback_id = rs.getString(1);
                    String customer_id = rs.getString(2);
                    String order_id = rs.getString(3);
                    String content = rs.getString(4);
                    String Reply = rs.getString(5);
                    String date = rs.getString(6);
                    
                    
                    Feedback s = new Feedback(feedback_id, customer_id, order_id, content, date, Reply);
                    list.add(s);
                }
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return list;
    }
    
    public void updateReply(String id, String reply) {
        String query = "UPDATE [dbo].[Feedback]\n" +
                        "   SET [Reply] = ?\n" +
                        " WHERE [FeedbackID] = ?";
        try{
            Connection cn=DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, reply);
            pst.setString(2, id);
            pst.executeUpdate();
            
            
            
        }catch (Exception e){
        }  
    }    
    
     public Feedback getFeedbackByID(String feedback_id){
        try{
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "Select * from Feedback where FeedbackID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, feedback_id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String feed_id = rs.getString(1);
                    String customer_id = rs.getString(2);
                    String order_id = rs.getString(3);
                    String content = rs.getString(4);
                    String date = rs.getString(6);
                    String Reply = rs.getString(5);
                    
                    Feedback s = new Feedback(feedback_id, customer_id, order_id, content, date, Reply);
                    return s;
                }
            }
            cn.close();
        }
        }catch (Exception e){
            
        }
        return null;
    }
     
      public static int insertFeedback(String customerid,int orderId,String Content) throws Exception{
        int rs=0;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
              String sql="insert into Feedback (CustomerID, OrderID, Content, CreateDate) values(?,?,?,?)";         
              PreparedStatement pst=cn.prepareStatement(sql);
              Date d = new Date(System.currentTimeMillis());
              pst.setString(1, customerid);
              pst.setInt(2, orderId);
              pst.setString(3, Content);
              pst.setDate(4, d);

              rs=pst.executeUpdate();
        }
        return rs;
    }   
     
    
    
    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> list= dao.getAllFeedback();
        
        dao.updateReply("1", "xin chao");
        
        System.out.println(list);
    }
}
