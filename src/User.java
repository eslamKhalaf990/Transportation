import java.util.ArrayList;

public abstract class User {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;

    public static ArrayList<User> usersList = new ArrayList<>();

    public User(){

    }

    public User(String username, String email, String password, String phoneNumber){
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public static User checkIn(String email, String password){
        User user = null;
        for (int i = 0; i< getUsersList().size(); i++){
            if (getUsersList().get(i).getEmail().equals(email)
                    && getUsersList().get(i).getPassword().equals(password)){
                    user =getUsersList().get(i);
            }
        }

        return user;
    }

    public static void Register(User user){

        if(user.getClass().getCanonicalName().equals("Driver")){
            Admin.addToPendingList(user);
        }
        else{
            boolean found = false;
            for(int i = 0; i<User.usersList.size(); i++){
                if (User.usersList.get(i).getEmail().equals(user.getEmail())){
                    found = true;
                    break;
                }

            }
            if (!found){
                User.usersList.add(user);
            }
            else {
                System.out.println(user.getUsername()+", You Should Enter A Unique Email!");
            }
        }
    }

    public static void setAdmin(Admin admin){
        admin.setEmail("admin@gmail.com");
        admin.setPassword("111");
        usersList.add(admin);
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
    public static ArrayList<User> getUsersList() {
        return usersList;
    }

}
