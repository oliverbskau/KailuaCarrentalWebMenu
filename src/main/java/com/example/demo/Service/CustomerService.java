package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    public Customer addCustomer(Customer c) {
        return customerRepo.addCustomer(c);
    }

    public Customer findCustomerById(int customerid) {
        return customerRepo.findCustomerById(customerid);
    }

    public Boolean deleteCustomer(int customerid) {
        return customerRepo.deleteCustomer(customerid);
    }

    public Customer updateContract(int customerid, Customer c) {
        return customerRepo.updateCustomer(customerid,c);
    }
}
