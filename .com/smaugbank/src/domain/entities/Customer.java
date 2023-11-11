package domain.entities;

import domain.utils.StringUtil;

public class Customer {

    private Integer id;

    private String document;

    private String name;

    private String user;

    private String password;

    private Customer(Integer id, String document, String name, String user, String password) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public static class CustomerBuilder {
        private Integer id;
        private String document;
        private String name;
        private String user;
        private String password;

        public CustomerBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder document(String document) {
            this.document = document;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder user(String user) {
            this.user = user;
            return this;
        }

        public CustomerBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Customer build() {
            var customer = new Customer(id, document, name, user, password);

            validate(customer);
            
            return customer;
        }

    }

    public static Customer validate(Customer customer) {

        if (StringUtil.isNullOrEmpty(customer.getDocument())) {
            throw new IllegalArgumentException("documento e obrigatorio");

        }

        if (StringUtil.isNullOrEmpty(customer.getName())) {
            throw new IllegalArgumentException("nome e obrigatorio");
        }

        if (StringUtil.isNullOrEmpty(customer.getUser())) {
            throw new IllegalArgumentException("usuario e obrigatorio");
        }

        if (StringUtil.isNullOrEmpty(customer.getPassword())) {
            throw new IllegalArgumentException("senha e obrigatorio");
        }

        return customer;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + "\n"+"CPF: "+document;
    }

}
