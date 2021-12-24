import java.util.Scanner;

public class mainClass {
    public static void main(String [] args){

        Admin admin = new Admin();
        User.setAdmin(admin);

        System.out.println("Welcome to Transportation App");
        while (true){

            System.out.println("1- Register\n2- Log In\n3- Exit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")){
                User user;

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
                    //user.setDriverMethods((Driver)user);
                    User.Register(user);
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
                    User.Register(user);
                }
            }
            else if(input.equals("2")){
                    scanner = new Scanner(System.in);
                    System.out.print("Enter Your Email: ");
                    String email  = scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    String password  = scanner.nextLine();
                    User user = User.checkIn(email, password);
                    if(user == null){
                        System.out.println("Register New Account");
                    }
                    else {
                        switch (user.getClass().getCanonicalName()) {
                            case "Admin":
                                System.out.println("Welcome Admin");
                                label:
                                while (true) {
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
                                            admin.activateDriver(Driver.availableDrivers.get(option - 1));
                                            break;
                                        }
                                        case "2": {
                                            for (int i = 0; i < Driver.availableDrivers.size(); i++) {
                                                System.out.println((i + 1) + "- " + Driver.availableDrivers.get(i));
                                            }
                                            if (Driver.availableDrivers.size() > 0) {
                                                int option;
                                                option = scanner.nextInt();
                                                admin.suspendDriver(Driver.availableDrivers.get(option - 1));
                                            } else {
                                                System.out.println("Empty List");
                                            }

                                            break;
                                        }
                                        case "3":
                                            for (int i = 0; i < Admin.getPendingList().size(); i++) {
                                                System.out.println((i + 1) + "- " + Admin.getPendingList().get(i));
                                            }
                                            if (Admin.getPendingList().size() > 0) {
                                                int option;
                                                option = scanner.nextInt();
                                                admin.confirmRegistration(Admin.getPendingList().get(option - 1));
                                            } else {
                                                System.out.println("Empty List");
                                            }
                                            break;
                                        case "4":
                                            break label;
                                    }
                                }

                                break;
                            case "Driver":
                                Driver driver = (Driver) user;
                                System.out.println("Welcome, " + driver.getUsername());
                                label:
                                while (true) {
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
                                            for (int i = 0; i < driver.getRequests().size(); i++) {
                                                System.out.println(driver.getRequests().get(i));
                                            }
                                            break;
                                        }
                                        case "2": {
                                            for (int i = 0; i < driver.listRates().size(); i++) {
                                                System.out.println(driver.listRates().get(i));
                                            }
                                            break;
                                        }
                                        case "3": {
                                            for (int i = 0; i < driver.getRequests().size(); i++) {
                                                System.out.println(driver.getRequests().get(i));
                                            }
                                            int index;
                                            index = scanner.nextInt();
                                            Notification request = driver.getRequests().get(index - 1);
                                            if (request.getSource().equals(driver.getFavoriteArea())) {
                                                System.out.println("The request matches your favorite area");
                                                System.out.print("Enter your offer price: ");
                                                int price = scanner.nextInt();
                                                driver.approveRequest(request.getSource(), request.getSource(),
                                                        request.getRider(), price, index - 1);
                                            } else {
                                                System.out.print("Enter Price: ");
                                                int price = scanner.nextInt();
                                                driver.approveRequest(request.getSource(), request.getSource(),
                                                        request.getRider(), price, index - 1);
                                            }


                                            break;
                                        }
                                        case "4": {
                                            System.out.print("Enter Area: ");
                                            String area = scanner.nextLine();
                                            driver.addArea(area);
                                            break;
                                        }
                                        case "5": {
                                            for (int i = 0; i < driver.getAreasList().size(); i++) {
                                                System.out.println(driver.getAreasList().get(i));
                                            }
                                            System.out.print("Enter Favorite Area: ");
                                            String favoriteArea = scanner.nextLine();
                                            driver.setFavoriteArea(favoriteArea);
                                            break;
                                        }
                                        case "6":
                                            break label;
                                    }

                                }


                                break;
                            case "Rider":
                                Rider rider = (Rider) user;
                                System.out.println("Welcome, " + rider.getUsername());
                                label:
                                while (true) {
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
                                            for (int i = 0; i < Driver.availableDrivers.size(); i++) {
                                                System.out.println(i + 1 + "- " + Driver.availableDrivers.get(i));
                                            }
                                            int indexOption = scanner.nextInt();
                                            scanner = new Scanner(System.in);
                                            System.out.print("Enter Source: ");
                                            String source = scanner.nextLine();
                                            System.out.print("Enter destination: ");
                                            String destination = scanner.nextLine();
                                            rider.RequestRide(indexOption - 1, source, destination);

                                            break;
                                        }
                                        case "2": {
                                            for (int i = 0; i < Driver.availableDrivers.size(); i++) {
                                                System.out.println(i + 1 + "- " + Driver.availableDrivers.get(i));
                                            }
                                            int indexOption = scanner.nextInt();
                                            System.out.println("Enter Your stars: ");
                                            int stars = scanner.nextInt();
                                            rider.RateDriver(stars,
                                                    Driver.availableDrivers.get(indexOption - 1));
                                            break;
                                        }
                                        case "3": {
                                            for (int i = 0; i < rider.getNotificationsList().size(); i++) {
                                                System.out.println(rider.getNotificationsList().get(i));
                                            }
                                            if (rider.getNotificationsList().size() < 1) {
                                                System.out.println("Empty List!");
                                            }
                                            break;
                                        }
                                        case "4":
                                            break label;
                                    }
                                }
                                break;
                        }
                    }

            }
            else {
                break;
            }
        }
    }
}
