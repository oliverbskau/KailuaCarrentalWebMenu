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
    public List<Car> fetchAll(){
        return carRepo.fetchAll();
    }
    public Car addCar(Car c){
        return carRepo.addCar(c);
    }
    public Car findCarById(int carid){
        return carRepo.findCarById(carid);
    }
    public Boolean deleteCar(int carid){
        return carRepo.deleteCar(carid);
    }
    public Car updateCar(int carid, Car c){
        return carRepo.updateCar(carid,c);
    }
}
