package com.example.demo.Repository;

import com.example.demo.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {

   @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Car> fetchAll() {
        return null;
    }

    public Car addCar(Car car) {
        return null;
    }

    public Car findCarById(int carid) {
        return null;
    }

    public Boolean deleteCar(int carid) {
        return null;
    }

    public Car updateCar(int carid, Car car) {
        return null;
    }
}
