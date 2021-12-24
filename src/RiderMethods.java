import java.util.ArrayList;

public interface RiderMethods {

     void RequestRide(int index, String source, String destination);
     void RateDriver(int stars, Driver driver);
     ArrayList<Notification> getNotificationsList();
     String toString();
}
