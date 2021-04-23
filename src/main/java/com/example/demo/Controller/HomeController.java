package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CarService carService;

    @GetMapping("/")
    public String carIndex(Model model) {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars",carList);
        return "home/carIndex";
    }
    @GetMapping("/carCreate")
    public String create(){
        return "home/create";
    }
    @PostMapping("/carCreate")
    public String create(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/";
    }
    @GetMapping("/carViewOne/{carid}")
    public String viewOne(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carViewOne";
    }
    @GetMapping("/carDelete/{carid}")
    public String delete(@PathVariable("carid") int carid){
        boolean deleted = carService.deleteCar(carid);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/carUpdate/{carid}")
    public String update(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carUpdate";
    }

    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute Car car){
        carService.updateCar(car.getCarid(),car);
        return "redirect:/";
    }
}
