package com.example.demo.Repository;


import com.example.demo.Model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepo {

    @Autowired
    JdbcTemplate template;

    public List<Contract> fetchAll() {
        String sql = "SELECT * FROM rentalcontracts";
        RowMapper<Contract> contracts = new BeanPropertyRowMapper<>(Contract.class);

        return template.query(sql,contracts);
    }

    public Contract addContract(Contract c) {
        String sql = "INSERT INTO rentalcontracts(rentalcontractid,customerid,carid) VALUES(?,?,?)";
        template.update(sql,c.getRentalcontractid(),c.getCustomerid(),c.getCustomerid());

        return null;
    }

    public Contract findContractById(int contractid) {
        String sql = "SELECT * FROM rentalcontracts WHERE rentalcontractid = ?";
        RowMapper<Contract> contracts = new BeanPropertyRowMapper<>(Contract.class);
        Contract c = template.queryForObject(sql, contracts, contractid);

        return c;
    }

    public Boolean deleteContract(int rentalcontractid) {
        String sql = "DELETE FROM rentalcontracts WHERE rentalcontractid = ?";

        return template.update(sql,rentalcontractid) < 0;
    }

    public Contract updateContract(int rentalcontractid, Contract c) {
        String sql = "UPDATE rentalcontracts SET customerid = ?, carid = ? WHERE rentalcontractid = ?";
        template.update(sql,c.getCustomerid(),c.getCarid(),c.getRentalcontractid());
        return null;
    }
}
