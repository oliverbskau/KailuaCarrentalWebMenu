package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Contract;
import com.example.demo.Model.Customer;
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



    //Home menu page
    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    //---------------------------------------------------------THIS IS CONTRACT HOME CONTROLLER--------------------------------------------------//

    //List and see all contracts
    @GetMapping("/contractIndex")
    public String contractIndex(Model model) {
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts",contractList);
        return "home/contractIndex";
    }
    //Create a contract on new page
    @GetMapping("/contractCreate")
    public String contractCreate(){
        return "home/contractCreate";
    }
    //Return to homepage after contract creation
    @PostMapping("/contractCreate")
    public String contractCreate(@ModelAttribute Contract contract){
        contractService.addContract(contract);
        return "redirect:/";
    }
    //View a single contract on a new page, linked by its id. example: localhost:5555/contractViewOne/1,2,3....
    @GetMapping("/contractViewOne/{rentalcontract_id}")
    public String contractViewOne(@PathVariable("rentalcontract_id") int rentalcontract_id, Model model){
        model.addAttribute("contracts", contractService.findContractById(rentalcontract_id));
        return "home/contractViewOne";
    }

    //return to homepage once a contract is deleted. Either way if contract is deleted or not, the user will be redirected back to home page (index)
    @GetMapping("/contractDelete/{rentalcontract_id}")
    public String contractDelete(@PathVariable("rentalcontract_id") int rentalcontract_id){
        boolean deleted = contractService.deleteContract(rentalcontract_id);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
    //Update a contract on a new page...
    @GetMapping("/contactUpdate/{rentalcontract_id}")
    public String contractUpdate(@PathVariable("rentalcontract_id") int rentalcontract_id, Model model){
        model.addAttribute("contracts", contractService.findContractById(rentalcontract_id));
        return "home/contractUpdate";
    }
    //... redirect to home page(index) when updated
    @PostMapping("/updateContract")
    public String updateContract(@ModelAttribute Contract contract){
        contractService.updateContract(contract.getRentalcontract_id(),contract);
        return "redirect:/";
    }


    //---------------------------------------------------------THIS IS CAR HOME CONTROLLER--------------------------------------------------//

    //List and see all cars
    @GetMapping("/carIndex")
    public String carIndex(Model model) {
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars",carList);
        return "home/carIndex";
    }
    //Create a car on new page
    @GetMapping("/carCreate")
    public String carCreate(){
        return "home/carCreate";
    }
    //Return to homepage after car creation
    @PostMapping("/carCreate")
    public String carCreate(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/";
    }

    //View a single car on a new page, linked by its id. example: localhost:5555/carViewOne/1,2,3....
    @GetMapping("/carViewOne/{carid}")
    public String carViewOne(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carViewOne";
    }

    //return to homepage once a car is deleted. Either way if car is deleted or not, the user will be redirected back to home page (index)
    @GetMapping("/carDelete/{carid}")
    public String carDelete(@PathVariable("carid") int carid){
        boolean deleted = carService.deleteCar(carid);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    //Update a car on a new page...
    @GetMapping("/carUpdate/{carid}")
    public String carUpdate(@PathVariable("carid") int carid, Model model){
        model.addAttribute("car", carService.findCarById(carid));
        return "home/carUpdate";
    }
    //... redirect to home page(index) when updated
    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute Car car){
        carService.updateCar(car.getCarid(),car);
        return "redirect:/";
    }

    //---------------------------------------------------------THIS IS CUSTOMER HOME CONTROLLER--------------------------------------------------//

    //List and see all customers
    @GetMapping("/customerIndex")
    public String customerIndex(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers",customerList);
        return "home/customerIndex";
    }

    //Create a customer on new page
    @GetMapping("/customerCreate")
    public String customerCreate(){
        return "home/customerCreate";
    }

    //Return to homepage after customer creation
    @PostMapping("/customerCreate")
    public String customerCreate(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/";
    }

    //View a single customer on a new page, linked by its id. example: localhost:5555/customerViewOne/1,2,3....
    @GetMapping("/customerViewOne/{customerid}")
    public String customerViewOne(@PathVariable("customerid") int customerid, Model model){
        model.addAttribute("customers", customerService.findCustomerById(customerid));
        return "home/customerViewOne";
    }

    //return to homepage once a customer is deleted. Either way if customer is deleted or not, the user will be redirected back to home page (index)
    @GetMapping("/customerDelete/{customerid}")
    public String customerDelete(@PathVariable("customerid") int customerid){
        boolean deleted = customerService.deleteCustomer(customerid);
        if(deleted){
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    //Update a customer on a new page...
    @GetMapping("/customerUpdate/{customerid}")
    public String customerUpdate(@PathVariable("customerid") int customerid, Model model){
        model.addAttribute("customers", customerService.findCustomerById(customerid));
        return "home/customerUpdate";
    }

    //... redirect to home page(index) when updated
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomerid(),customer);
        return "redirect:/";
    }
}
