/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author huudu
 */
public class Pet {
     private String petId;
    private String customerid;
    private String petName;
    private String petType;
    private String status;

    public Pet() {
    }

    public Pet(String petId, String customerid, String petName, String petType, String status) {
        this.petId = petId;
        this.customerid = customerid;
        this.petName = petName;
        this.petType = petType;
        this.status = status;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerId) {
        this.customerid = customerId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
