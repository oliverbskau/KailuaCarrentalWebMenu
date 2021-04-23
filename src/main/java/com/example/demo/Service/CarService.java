package com.example.demo.Service;

import com.example.demo.Model.Car;
import com.example.demo.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

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
