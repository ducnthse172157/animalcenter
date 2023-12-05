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
public class Booking {
    private String orderID;
    private String petID;
    private String createDate;
    private String total;
    private String checkinDate;
    private String checkoutDate;
    private String status;

    public Booking() {
    }

    public Booking(String orderID, String petID, String createDate, String total, String checkinDate, String checkoutDate, String status) {
        this.orderID = orderID;
        this.petID = petID;
        this.createDate = createDate;
        this.total = total;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" + "orderID=" + orderID + ", petID=" + petID + ", createDate=" + createDate + ", total=" + total + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", status=" + status + '}';
    }

   
    
}
