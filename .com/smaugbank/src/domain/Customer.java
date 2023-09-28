package domain;

public class Customer {

    private long Id;

    private String name;

    private String user;
    
    private String password;
    

    public Customer(long id, String name, String user, String password) {
        Id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
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
        return "Customer [Id=" + Id + ", name=" + name + ", user=" + user + ", password=" + password + "]";
    }
    
}
