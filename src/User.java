public abstract class User {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    public DriverMethods driverMethods;
    public RiderMethods riderMethods;

    public User(String username, String email, String password, String phoneNumber){
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void setDriverMethods(DriverMethods driverMethods) {
        this.driverMethods = driverMethods;
    }
    public void setRiderMethods(RiderMethods riderMethods) {
        this.riderMethods = riderMethods;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

}
