public class Notification {
    private String source;
    private String destination;
    private Rider riderName;
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setRiderName(Rider riderName) {
        this.riderName = riderName;
    }
    public String getDestination() {
        return destination;
    }
    public Rider getRider() {
        return riderName;
    }
    public String getSource() {
        return source;
    }
    public void setRequests(Driver driver, Notification requests) {
        driver.getRequests().add(requests);
    }
    @Override
    public String toString() {
        return
                "source: " + source +
                ", destination: " + destination +
                ", rider name: " + riderName.getUsername() +
                ", price: " + price;

    }
}
