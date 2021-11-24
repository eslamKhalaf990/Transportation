import java.util.ArrayList;

public class Registration extends Admin{

    public static ArrayList <User> usersList = new ArrayList<>();
    public void Register(User driver){
            addToPendingList(driver);
    }
    public ArrayList<User> getUsersList() {
        return usersList;
    }
}
