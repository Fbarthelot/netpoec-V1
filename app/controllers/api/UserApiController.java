package controllers.api;

import com.google.gson.Gson;
import models.adapters.UserAdapter;
import models.utilisateur.User;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import play.Logger;
import play.mvc.Controller;
import services.UserService;

import java.util.List;

public class UserApiController extends Controller {


//    public static void delete(Long id) {
//        User user = UserService.getById(id);
//        notFoundIfNull(user);
//
//
//        UserService.deleteUser(user);
//        renderText("Profil supprimé");
//        } else {
//            error("Ce profil n'existe pas");
    //    }

    public static void loginUser () {
            String email = new Gson().fromJson(request.params.get("email"), String.class);
            String password = new Gson().fromJson(request.params.get("password"), String.class);
            Logger.info("loginUser.email %s", email);
            Logger.info("loginUser.password %s", password);
            User user = UserService.getByEmail(email);
            notFoundIfNull(user);

            if(password.equals(password) ){
                Logger.info("loginUser.id %s", user.id.toString());
                renderJSON("ok");

            }
            else{

                renderJSON(-1);
            }

    }

    public static void delete(Long id){
        User user = UserService.getById(id);
        Logger.info("loginUser.id %s",user.id.toString());
        notFoundIfNull(user);
        Long newId = user.id;
        String profil= user.firstName;

        user.delete();

        renderText("Votre compte a été supprimé" +" "+profil+". A bientot ");

    }


//    public static void profil ( String email , String password, String firstname, String lastname){
//
//        User user = UserService.createUser(String email , String password, String firstname, String lastname);
//        renderJSON(user);
//
//    }

//    public static void userCreate (String email, String password, String firstname, String lastname){
//
//        User user = UserService.createUser()
//        renderJSON(user);
//        //user.save();
//    }

}
