import java.util.ArrayList;

public interface DriverMethods {
    public void setUsername(String username);
    public void setDrivingLicence(String drivingLicence);
    public void setNationalID(String nationalID);
    public String getDrivingLicence();
    public String getNationalID();
    public void setAvailable(boolean status);
    public boolean getStatus();
    public void addArea(String area);
    public void setFavoriteArea(String favoriteArea);
    public String getFavoriteArea();
    public ArrayList<Notification> getRequests();
    public void approveRequest(String source, String destination, Rider rider, int price, int index);
    public ArrayList<String> getAreasList();
    public ArrayList<Integer> listRates();
    public String toString();
}
