package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int carid;
    private String brand;
    private String model;
    private String carclass;
    private String fueltype;
    private int driven_km;
    private String first_registration_year;
    private String price;

    public Car() {}

    public Car(int carid, String brand, String model, String carclass, String fueltype, int driven_km, String first_registration_year, String price) {
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.carclass = carclass;
        this.fueltype = fueltype;
        this.driven_km = driven_km;
        this.first_registration_year = first_registration_year;
        this.price = price;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarclass() {
        return carclass;
    }

    public void setCarclass(String carclass) {
        this.carclass = carclass;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public int getDriven_km() {
        return driven_km;
    }

    public void setDriven_km(int driven_km) {
        this.driven_km = driven_km;
    }

    public String getFirst_registration_year() {
        return first_registration_year;
    }

    public void setFirst_registration_year(String first_registration_year) {
        this.first_registration_year = first_registration_year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
