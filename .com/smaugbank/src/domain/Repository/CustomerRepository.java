package domain.Repository;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Customer;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public void addCustumer(String name, String user, String password){
        Integer id = 1;
        var newCustomer = new Customer.CustomerBuilder()
        .Id(id)
        .name(name)
        .user(user)
        .password(password)
        .build();

        customers.add(newCustomer);
    }

    public Customer getCustomers(){
        return customers.iterator().next();
    }
}
