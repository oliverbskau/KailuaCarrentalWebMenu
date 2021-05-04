package com.example.demo.Repository;

import com.example.demo.Model.Contract;
import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll() {
        String sql = "SELECT * FROM customers";
        RowMapper<Customer> customers = new BeanPropertyRowMapper<>(Customer.class);

        return template.query(sql,customers);
    }

    public Customer addCustomer(Customer c) {
        String sql = "INSERT INTO customers(first_name,last_name,phonenumber,email,drivers_license_number,address,zipcode) " +
                "VALUES(?,?,?,?,?,?,?)";
        template.update(sql,c.getFirst_name(),c.getLast_name(),c.getPhonenumber(),c.getEmail(),
                c.getDrivers_license_number(), c.getAddress(),c.getZipcode());

        return null;
    }

    public Customer findCustomerById(int customerid) {
        String sql = "SELECT * FROM customers WHERE customerid = ?";
        RowMapper<Customer> customers = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql, customers, customerid);

        return c;
    }

    public Boolean deleteCustomer(int customerid) {
        String sql = "DELETE FROM customers WHERE customerid = ?";

        return template.update(sql,customerid) < 0;
    }

    public Customer updateCustomer(int customerid, Customer c) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?,phonenumber = ?,email = ?" +
                ",drivers_license_number = ?,address = ?,zipcode = ?";
        template.update(sql,c.getFirst_name(),c.getLast_name(),c.getPhonenumber(),c.getEmail(),
                c.getDrivers_license_number(), c.getAddress(),c.getZipcode());
        return null;
    }

}
