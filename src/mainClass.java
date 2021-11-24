import java.util.Scanner;

public class mainClass {
    public static void main(String [] args){
        System.out.println("Welcome to Transportation App");
        Registration registration = new Registration();
        Admin admin = new Admin();
        LogIn logIn = new LogIn();

        while (true){
            User user;
            System.out.println("1- Register\n2- Log In\n3- Exit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")){

                scanner = new Scanner(System.in);

                System.out.println("" +
                        "1- Register Driver Account\n" +
                        "2- Register Rider Account"
                );
                input = scanner.nextLine();

                if (input.equals("1")){
                    scanner = new Scanner(System.in);
                    System.out.print("Enter Your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Your Email: ");
                    String email  = scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    String password  = scanner.nextLine();
                    System.out.print("Enter Your Phone Number: ");
                    String phone  = scanner.nextLine();
                    System.out.print("Enter Your Driving License: ");
                    String drivingLic = scanner.nextLine();
                    System.out.print("Enter Your National ID: ");
                    String nationalID = scanner.nextLine();
                    user = new Driver(name, email, password, phone, drivingLic, nationalID);
                    user.setDriverMethods((Driver)user);
                    registration.Register(user);
                }
                else {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter Your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Your Email: ");
                    String email  = scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    String password  = scanner.nextLine();
                    System.out.print("Enter Your Phone Number: ");
                    String phone  = scanner.nextLine();
                    user = new Rider(name, email, password, phone);
                    user.setRiderMethods((Rider) user);
                    registration.Register(user);
                }
            }
            else if(input.equals("2")){
                    scanner = new Scanner(System.in);
                    System.out.print("Enter Your Email: ");
                    String email  = scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    String password  = scanner.nextLine();
                    if (logIn.checkIn(email, password).equals("admin")){
                        System.out.println("Welcome Admin");
                        label:
                        while (true){
                            System.out.println(
                                    "1- Activate Account\n" +
                                    "2- Suspend Account\n" +
                                    "3- Verify Account\n" +
                                    "4- Log out"
                            );
                            scanner = new Scanner(System.in);
                            String adminOption = scanner.nextLine();
                            switch (adminOption) {
                                case "1": {
                                    for (int i = 0; i < Driver.availableDrivers.size(); i++) {
                                        System.out.println((i + 1) + "- " + Driver.availableDrivers.get(i));
                                    }
                                    int option;
                                    option = scanner.nextInt();
                                    admin.activateDriver(Driver.availableDrivers.get(option-1));
                                    break;
                                }
                                case "2": {
                                    for (int i = 0; i < Driver.availableDrivers.size(); i++) {
                                        System.out.println((i + 1) + "- " + Driver.availableDrivers.get(i));
                                    }
                                    if (Driver.availableDrivers.size()>0){
                                        int option;
                                        option = scanner.nextInt();
                                        admin.suspendDriver(Driver.availableDrivers.get(option-1));
                                    }
                                    else {
                                        System.out.println("Empty List");
                                    }

                                    break;
                                }
                                case "3":
                                    for (int i = 0; i < Admin.getPendingList().size(); i++) {
                                        System.out.println((i + 1) + "- " + Admin.getPendingList().get(i));
                                    }
                                    if (Admin.getPendingList().size()>0){
                                        int option;
                                        option = scanner.nextInt();
                                        admin.confirmRegistration(Admin.getPendingList().get(option-1));
                                    }
                                    else {
                                        System.out.println("Empty List");
                                    }
                                    break;
                                case "4":
                                    break label;
                            }
                        }

                    }
                    else if (logIn.checkIn(email, password).equals("found")){
                        if(logIn.getUser().getClass().getCanonicalName().equals("Driver")){
                            user = logIn.getUser();
                            user.setDriverMethods((Driver) user);
                            System.out.println("Welcome, "+user.getUsername());
                            label:
                            while (true){
                                System.out.println("" +
                                        "1- Get Requests\n" +
                                        "2- List Rates\n" +
                                        "3- Approve Request\n" +
                                        "4- Add Areas\n" +
                                        "5- set Favorite Area\n" +
                                        "6- Log out"
                                );
                                scanner = new Scanner(System.in);
                                String driverOption = scanner.nextLine();
                                switch (driverOption) {
                                    case "1": {
                                        for (int i=0; i<user.driverMethods.getRequests().size();i++){
                                            System.out.println(user.driverMethods.getRequests().get(i));
                                        }
                                        break;
                                    }
                                    case "2": {
                                        for (int i=0; i<user.driverMethods.listRates().size(); i++){
                                            System.out.println(user.driverMethods.listRates().get(i));
                                        }
                                        break;
                                    }
                                    case "3":{
                                        for (int i=0; i<user.driverMethods.getRequests().size();i++){
                                            System.out.println(user.driverMethods.getRequests().get(i));
                                        }
                                        int index;
                                        index = scanner.nextInt();
                                        Notification request = user.driverMethods.getRequests().get(index-1);
                                        if (request.getSource().equals(user.driverMethods.getFavoriteArea())){
                                            System.out.println("The request matches your favorite area");
                                            System.out.print("Enter your offer price: ");
                                            int price = scanner.nextInt();
                                            user.driverMethods.approveRequest(request.getSource(), request.getSource(),
                                                    request.getRider(), price, index-1);
                                        }
                                        else {
                                            System.out.print("Enter Price: ");
                                            int price = scanner.nextInt();
                                            user.driverMethods.approveRequest(request.getSource(), request.getSource(),
                                                    request.getRider(), price, index-1);
                                        }


                                        break;
                                    }
                                    case "4":{
                                        System.out.print("Enter Area: ");
                                        String area = scanner.nextLine();
                                        user.driverMethods.addArea(area);
                                        break;
                                    }
                                    case "5":{
                                        for (int i=0; i<user.driverMethods.getAreasList().size() ;i++){
                                            System.out.println(user.driverMethods.getAreasList().get(i));
                                        }
                                        System.out.print("Enter Favorite Area: ");
                                        String favoriteArea = scanner.nextLine();
                                        user.driverMethods.setFavoriteArea(favoriteArea);
                                        break;
                                    }
                                    case "6":
                                        break label;
                                }

                            }

                        }
                        else if(logIn.getUser().getClass().getCanonicalName().equals("Rider")) {
                            user = logIn.getUser();
                            user.setRiderMethods((Rider) user);
                            System.out.println("Welcome, "+user.getUsername());
                            label:
                            while (true){
                                System.out.println(
                                        "1- Request Ride\n" +
                                        "2- Rate Driver\n" +
                                        "3- Notifications List\n" +
                                        "4- Log out"
                                );
                                scanner = new Scanner(System.in);
                                String riderOption = scanner.nextLine();
                                switch (riderOption) {
                                    case "1": {
                                        for (int i=0; i<Driver.availableDrivers.size();i++){
                                            System.out.println(i+1 + "- " + Driver.availableDrivers.get(i));
                                        }
                                        int indexOption = scanner.nextInt();
                                        scanner = new Scanner(System.in);
                                        System.out.print("Enter Source: ");
                                        String source = scanner.nextLine();
                                        System.out.print("Enter destination: ");
                                        String destination = scanner.nextLine();
                                        user.riderMethods.RequestRide(indexOption - 1, source, destination);

                                        break;
                                    }
                                    case "2": {
                                        for (int i=0; i<Driver.availableDrivers.size();i++){
                                            System.out.println(i+1 + "- " + Driver.availableDrivers.get(i));
                                        }
                                        int indexOption = scanner.nextInt();
                                        System.out.println("Enter Your stars: ");
                                        int stars = scanner.nextInt();
                                        user.riderMethods.RateDriver(stars,
                                                Driver.availableDrivers.get(indexOption-1));
                                        break;
                                    }
                                    case "3":{
                                        for(int i=0; i<user.riderMethods.getNotificationsList().size(); i++){
                                            System.out.println(user.riderMethods.getNotificationsList().get(i));
                                        }
                                        if (user.riderMethods.getNotificationsList().size()<1){
                                            System.out.println("Empty List!");
                                        }
                                        break;
                                    }
                                    case "4":
                                        break label;
                                }
                            }
                        }
                    }
            }
            else {
                break;
            }
        }
    }
}
