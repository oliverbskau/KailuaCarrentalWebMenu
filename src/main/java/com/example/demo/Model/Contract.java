package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    private int rentalcontract_id;
    private int customerid;
    private int carid;

    public Contract(int rentalcontract_id, int customerid, int carid) {
        this.rentalcontract_id = rentalcontract_id;
        this.customerid = customerid;
        this.carid = carid;
    }

    public Contract(){
    }

    public int getRentalcontract_id() {
        return rentalcontract_id;
    }

    public void setRentalcontract_id(int rentalcontract_id) {
        this.rentalcontract_id = rentalcontract_id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }
}
