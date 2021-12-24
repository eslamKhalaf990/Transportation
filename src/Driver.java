import java.util.ArrayList;

public class Driver extends User implements DriverMethods{

    private String nationalID;
    private String drivingLicence;
    private String favoriteArea;
    private boolean available;
    private final ArrayList<Notification> requests = new ArrayList<>();
    private final ArrayList <String> areasList = new ArrayList<>();
    public static ArrayList <Driver> availableDrivers = new ArrayList<>();
    public ArrayList <Integer> rateList = new ArrayList<>();

    public Driver(String username, String email, String password, String phoneNumber,
                  String drivingLicence, String nationalID){
        super(username, email, password, phoneNumber);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
    }
    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
    public String getDrivingLicence() {
        return drivingLicence;
    }
    public String getNationalID() {
        return nationalID;
    }
    public void setAvailable(boolean status){
        available = status;
    }
    public boolean getStatus(){
        return available;
    }
    public void addArea(String area){
        areasList.add(area);
    }
    public void setFavoriteArea(String favoriteArea){
        this.favoriteArea = favoriteArea;
    }
    public String getFavoriteArea() {
        return favoriteArea;
    }
    public ArrayList<Integer> listRates(){
        return rateList;
    }
    public ArrayList<Notification> getRequests() {
        return requests;
    }
    public void approveRequest(String source, String destination, Rider rider, int price, int index) {
        Notification n = new Notification();
        n.setPrice(price);
        n.setSource(source);
        n.setRiderName(rider);
        n.setDestination(destination);
        getRequests().remove(index);
        rider.notificationsList.add(n);
    }

    public ArrayList<String> getAreasList() {
        return areasList;
    }
    public int getAvgRating(){
        int sum = 0;
        int numberOFRatings = this.listRates().size();
        for (int i=0; i<this.listRates().size(); i++){
            sum += this.listRates().get(i);
        }
        if (numberOFRatings==0){
            return 0;
        }
        return (sum/numberOFRatings);
    }

    @Override
    public String toString() {
        return "Driver name: "+getUsername() +", email: " + getEmail()+", average rating: "+getAvgRating();
    }
}
