package domain.entities;

public class Customer {

    private Integer Id;

    private String name;

    private String user;
    
    private String password;
    
    private Customer(Integer id, String name, String user, String password) {
        this.Id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }
    public static class CustomerBuilder {
        private Integer Id;
        private String name;
        private String user;
        private String password;

        public CustomerBuilder Id(Integer Id) {
            this.Id = Id;
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
            var customer = new Customer(Id, name, user, password);
            return customer;
        }

    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
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
        return "" + name + "\n";
    }

}
