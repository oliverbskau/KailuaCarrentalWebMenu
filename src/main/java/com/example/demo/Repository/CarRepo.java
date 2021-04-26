package com.example.demo.Repository;

import com.example.demo.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    @Autowired
    JdbcTemplate template;

    public List<Car> fetchAll(){
        String sql = "SELECT * FROM cars";
        RowMapper<Car> cars = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql,cars);
    }
    public Car addCar(Car c){
        String sql = "INSERT INTO cars(carid, brand, model, carclass, fueltype, driven_km, first_registration_year, price) values(?,?,?,?,?,?,?,?)";
        template.update(sql,c.getCarid(),c.getBrand(),c.getModel(),c.getCarclass(),c.getFueltype(),
                c.getDriven_km(),c.getFirst_registration_year(),c.getPrice());
        return null;
    }
    public Car findCarById(int carid){
        String sql = "SELECT * FROM cars WHERE carid = ?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car c = template.queryForObject(sql, rowMapper, carid);
        return c;
    }
    public Boolean deleteCar(int carid){
        String sql = "DELETE FROM cars WHERE carid = ?";
        return template.update(sql, carid) < 0;
    }
    public Car updateCar(int carid, Car c){
        String sql = "UPDATE cars SET brand = ?, model = ?, carclass = ?, fueltype = ?, driven_km = ?, first_registartion_year = ?, price = ? WHERE carid = ?";
        template.update(sql,c.getBrand(),c.getModel(),c.getCarclass(),c.getFueltype(),
                c.getDriven_km(),c.getFirst_registration_year(),c.getPrice(),c.getCarid());
        return null;
    }
}
