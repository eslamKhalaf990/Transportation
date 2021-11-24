public class LogIn extends Registration {
    User user;
    public String checkIn(String email, String password){
        if (!email.equals("admin@gmail.com") && !password.equals("111")){
            for (int i = 0; i< getUsersList().size(); i++){
                if (getUsersList().get(i).getEmail().equals(email)
                        && getUsersList().get(i).getPassword().equals(password)){
                    this.user = getUsersList().get(i);
                    return "found";
                }
            }
            if (user == null){
                return ("Register Your Account!");
            }
        }
        else {
            return ("admin");
        }
        return "";
    }

    public User getUser() {
        return user;
    }
}
