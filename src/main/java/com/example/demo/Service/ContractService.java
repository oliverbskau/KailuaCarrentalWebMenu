package com.example.demo.Service;

import com.example.demo.Model.Contract;
import com.example.demo.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractService {

    @Autowired
    ContractRepo contractRepo;

    public List<Contract> fetchAll() {
        return contractRepo.fetchAll();
    }

    public Contract addContract(Contract c) {
        return contractRepo.addContract(c);
    }

    public Contract findContractById(int rentalcontractid) {
        return contractRepo.findContractById(rentalcontractid);
    }

    public Boolean deleteContract(int rentalcontractid) {
        return contractRepo.deleteContract(rentalcontractid);
    }

    public Contract updateContract(int rentalcontractid, Contract c) {
        return contractRepo.updateContract(rentalcontractid,c);
    }
}
