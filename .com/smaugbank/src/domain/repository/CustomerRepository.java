package domain.repository;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Customer;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public void addCustumer(String name, String user, String password, String document) {
        Integer id = 1;
        var newCustomer = new Customer.CustomerBuilder()
                .id(id)
                .name(name)
                .user(user)
                .password(password)
                .document(document)
                .build();

        customers.add(newCustomer);
    }

    public Customer getCustomers() {
        return customers.iterator().next();
    }
}
