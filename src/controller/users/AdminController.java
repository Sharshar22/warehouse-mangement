package controller.users;

import controller.usermanagement.SignUp;

public class AdminController {
    SignUp signUp = new SignUp();

    public void registerUser () throws Exception {
        signUp.userDetails();
    }
}
