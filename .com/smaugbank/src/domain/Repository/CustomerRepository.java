package domain.Repository;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public void addCustumer(String name, String user, String password){
        Integer id = 1;
        var newCustomer = new Customer(id, name, user, password);
        customers.add(newCustomer);
    }

    public List<Customer> getCustomers(){
        return customers;
    }
}
