/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ASUS
 */
public class Feedback {
    private String feedbackID;
    private String customerID;
    private String orderID;    
    private String content;
    private String createDate;
    private String reply;

    public Feedback() {
    }

    public Feedback(String feedbackID, String customerID, String orderID, String content, String createDate, String reply) {
        this.feedbackID = feedbackID;
        this.customerID = customerID;
        this.orderID = orderID;
        this.content = content;
        this.createDate = createDate;
        this.reply = reply;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackID=" + feedbackID + ", customerID=" + customerID + ", orderID=" + orderID + ", content=" + content + ", createDate=" + createDate + ", reply=" + reply + '}';
    }
    
            
                    
}
