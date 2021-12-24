import java.util.ArrayList;

public interface DriverMethods {
     void setUsername(String username);
     void setDrivingLicence(String drivingLicence);
     void setNationalID(String nationalID);
     String getDrivingLicence();
     String getNationalID();
     void setAvailable(boolean status);
     boolean getStatus();
     void addArea(String area);
     void setFavoriteArea(String favoriteArea);
     String getFavoriteArea();
     ArrayList<Notification> getRequests();
     void approveRequest(String source, String destination, Rider rider, int price, int index);
     ArrayList<String> getAreasList();
     ArrayList<Integer> listRates();
     String toString();
}
