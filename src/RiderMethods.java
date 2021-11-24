import java.util.ArrayList;

public interface RiderMethods {

    public void RequestRide(int index, String source, String destination);
    public void RateDriver(int stars, Driver driver);
    public ArrayList<Notification> getNotificationsList();
    public String toString();
}
