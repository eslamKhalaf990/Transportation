import java.util.ArrayList;

public class Admin {
    private static final ArrayList <User> pendingList = new ArrayList <> ();
    private static final ArrayList <User> suspendedList = new ArrayList <> ();

    public void addToPendingList(User user){ pendingList.add(user); }
    public void confirmRegistration(User user){
        boolean found = false;
            for(int i = 0; i<Registration.usersList.size(); i++){
                if (Registration.usersList.get(i).getEmail().equals(user.getEmail())){
                    found = true;
                    break;
                }
            }
            if (!found){
                pendingList.remove(user);
                Registration.usersList.add(user);
                if (user.getClass().getCanonicalName().equals("Driver"))Driver.availableDrivers.add((Driver) user);
            }
            else {
                System.out.println(user.getUsername()+", You Should Enter A Unique Email!");
            }
    }
    public void suspendDriver(User user){
        Registration.usersList.remove(user);
        suspendedList.add(user);
    }
    public void activateDriver(User user ){
        if(suspendedList.contains(user)){
            Registration.usersList.add(user);
            suspendedList.remove(user);
        }
    }
    public static ArrayList<User> getPendingList() {
        return pendingList;
    }
}
