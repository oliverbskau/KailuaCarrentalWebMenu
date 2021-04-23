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

    public Contract findContractById(int contractid) {
        return contractRepo.findContractById(contractid);
    }

    public Boolean deleteContract(int contractid) {
        return contractRepo.deleteContract(contractid);
    }

    public Contract updateContract(Contract c, int contractid) {
        return contractRepo.updateContract(c,contractid);
    }
}
