package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Contract;
import com.example.demo.Service.CarService;
import com.example.demo.Service.ContractService;
import com.example.demo.Service.CustomerService;
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
    ContractService contractService;
    CustomerService customerService;

    //THIS IS CONTRACT HOME CONTROLLER

    @GetMapping("/")
     public String index(){
        return "home/index";
    }

    @GetMapping("/contractIndex")
    public String contractIndex(Model model) {
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts",contractList);
        return "home/contractIndex";
    }
    @GetMapping("/contractCreate")
    public String contractCreate(){
        return "home/contractCreate";
    }
    @PostMapping("/contractCreate")
    public String contractCreate(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:/";
    }
    @GetMapping("/contractViewOne/{rentalcontract_id}")
    public String contractViewOne(@PathVariable("rentalcontract_id") int rentalcontract_id, Model model){
        model.addAttribute("contracts", contractService.findContractById(rentalcontract_id));
        return "home/contractViewOne";
    }

    @GetMapping("/contractDelete/{rentalcontract_id}")
    public String contractDelete(@PathVariable("rentalcontract_id") int rentalcontract_id){
        boolean deleted = contractService.deleteContract(rentalcontract_id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/contactUpdate/{rentalcontract_id}")
    public String contractUpdate(@PathVariable("rentalcontract_id") int rentalcontract_id, Model model){
        model.addAttribute("contracts", contractService.findContractById(rentalcontract_id));
        return "home/contractUpdate";
    }

    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getRentalcontract_id(),contract);
        return "redirect:/";
    }

// THIS IS CAR HOME CONTROLLER

    @GetMapping("/carIndex")
    public String carIndex(Model model) {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars",carList);
        return "home/carIndex";
    }
    @GetMapping("/carCreate")
    public String carCreate(){
        return "home/carCreate";
    }
    @PostMapping("/carCreate")
    public String carCreate(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/";
    }
    @GetMapping("/carViewOne/{carid}")
    public String carViewOne(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carViewOne";
    }
    @GetMapping("/carDelete/{carid}")
    public String carDelete(@PathVariable("carid") int carid){
        boolean deleted = carService.deleteCar(carid);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/carUpdate/{carid}")
    public String carUpdate(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carUpdate";
    }

    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute Car car){
        carService.updateCar(car.getCarid(),car);
        return "redirect:/";
    }
}
