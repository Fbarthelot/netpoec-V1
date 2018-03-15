package services;


import models.User;
import play.Logger;

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

    public static void saveNewPassword(User user,String password) {


        User newUser = new User();
        newUser.email = user.email;
        newUser.password = password;
        newUser.firstName = user.firstName;
        newUser.lastName = user.lastName;
        user.delete();
        newUser.save();

    }
}
