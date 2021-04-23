package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int customerid;
    private String first_name;
    private String last_name;
    private String phonenumber;
    private String email;
    private String driver_license_number;
    private String address;
    private String zipcode;


    public Customer(){}

    public Customer(int customerid, String first_name, String last_name, String phonenumber, String email, String driver_license_number, String address, String zipcode) {
        this.customerid = customerid;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.driver_license_number = driver_license_number;
        this.address = address;
        this.zipcode = zipcode;
    }


    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriver_license_number() {
        return driver_license_number;
    }

    public void setDriver_license_number(String driver_license_number) {
        this.driver_license_number = driver_license_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }




}
