package services;


import controllers.Secure;
import controllers.Security;
import models.User;
import play.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String LOG_PREFIX = "ArticleService";


    public static int createUser(String email, String password, String firstName, String lastName) {
        User user = new User();
        user.email = email;
        user.password = password;
        user.firstName = firstName;
        user.lastName = lastName;
        user=user.save();
        if(user==null){
            return 0;
        }
        return 1;
    }

    public static User getByEmail(String email) {
        return User.find("email= ?1",email).first();

    }

    public static User getById(Long id) {
        Logger.debug("%s : getById [%s]", LOG_PREFIX, id);

        return User.findById(id);
    }
}
