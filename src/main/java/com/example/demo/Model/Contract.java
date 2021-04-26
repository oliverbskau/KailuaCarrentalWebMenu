package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    private int rentalcontractid;
    private int customerid;
    private int carid;

    public Contract(){}

    public Contract(int rentalcontractid, int customerid, int carid) {
        this.rentalcontractid = rentalcontractid;
        this.customerid = customerid;
        this.carid = carid;
    }



    public int getRentalcontractid() {
        return rentalcontractid;
    }

    public void setRentalcontractid(int rentalcontract_id) {
        this.rentalcontractid = rentalcontract_id;
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
