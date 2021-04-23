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

    public Contract findContractById(int rentalcontract_id) {
        return contractRepo.findContractById(rentalcontract_id);
    }

    public Boolean deleteContract(int rentalcontract_id) {
        return contractRepo.deleteContract(rentalcontract_id);
    }

    public Contract updateContract(int rentalcontract_id, Contract c) {
        return contractRepo.updateContract(rentalcontract_id,c);
    }
}
