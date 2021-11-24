import java.util.ArrayList;

public class Rider extends User implements RiderMethods{
    public ArrayList <Notification> notificationsList = new ArrayList<>();
    public Rider(String username, String email, String password, String phoneNumber){
        super(username, email, password, phoneNumber);
    }

    public void RequestRide(int index, String source, String destination){

        Notification request = new Notification();
        request.setRiderName(this);
        request.setSource(source);
        request.setDestination(destination);
        request.setRequests(Driver.availableDrivers.get(index), request);
    }

    public ArrayList<Notification> getNotificationsList() {
        return notificationsList;
    }


    public void RateDriver(int stars, Driver driver){
        driver.rateList.add(stars);
    }

    @Override
    public String toString() {
        return "Rider name: "+getUsername() +", email: " + getEmail();
    }
}
