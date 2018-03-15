package controllers;

import models.User;
import services.UserService;

public class Security extends Secure.Security {

    static boolean authenticate(String userMail, String password) {
        User user = UserService.getByEmail(userMail);
        if (user == null) {
            return false;
        }
        if (user.password.equals(password)) {
            return true;
        }

        return false;
    }

    static void onAuthenticated() {
        String url = flash.get("url");
        if (url == null) {
            url = "UserController.index";
        }
        redirect(url);
    }

    static void onDisconnected() {

        redirect("Application.index");
    }
}
