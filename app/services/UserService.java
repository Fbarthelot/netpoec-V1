package services;


import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> users;

//    static {
//        users =new ArrayList<User>();
//        users.add(createUser("nicolas.giard@coaxys.com", "test", "Nicolas", "Giard"));
//        users.add(createUser("luke.skywalker@coaxys.com", "test", "Luke", "Skywalker"));
//    }

    public static User createUser(String email, String password, String firstName, String lastName) {
        User user = new User();
        user.email = email;
        user.password = password;
        user.firstName = firstName;
        user.lastName = lastName;
        return user;
    }

    public static User getByEmail(String email) {
        return User.find("email= ?1",email).first();

    }

}
