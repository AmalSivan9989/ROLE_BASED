package org.hexa.dao;

import org.hexa.model.Customer;
import org.hexa.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao{
    static Connection connection;
    PreparedStatement psmt;

    static {
        try {
            connection = ConnectionHelper.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public String addCustomerDao(Customer customer) throws SQLException {
        if (customer.getCustomerName().length()<5|| customer.getCustomerName().length()>10){
            return "customer name contains 5 to 10 characters...";


        }
        else if(customer.getCity().length()<3){
            return "customer city contains min 3 characters...";
        }
        else if(customer.getMobile().length()!=10){
            return "customer mobile contains min 10 characters...";
        }
        String cmd="insert into customer(customerName,city,mobile)values(?,?,?)";
        psmt= connection.prepareStatement(cmd);
        psmt.setString(1,customer.getCustomerName());
        psmt.setString(2,customer.getCity());
        psmt.setString(3,customer.getMobile());
        psmt.executeUpdate();
        return "customer record inserted";
    }
}
