package org.hexa.dao;

import org.hexa.model.Customer;

import java.sql.SQLException;

public interface CustomerDao {
    String addCustomerDao(Customer customer) throws SQLException;
}
