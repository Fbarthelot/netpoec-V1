package controllers.api;

import com.google.gson.Gson;
import models.adapters.UserAdapter;
import models.utilisateur.User;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import play.Logger;
import play.mvc.Controller;
import play.mvc.results.RenderJson;
import services.UserService;

import java.util.List;

public class UserApiController extends Controller {




    public static void loginUser() {
        String email = new Gson().fromJson(request.params.get("email"), String.class);
        String password = new Gson().fromJson(request.params.get("password"), String.class);
        Logger.info("loginUser.email %s", email);
        Logger.info("loginUser.password %s", password);

        User user = UserService.getByEmail(email);
        if (user != null) {

            if (user.password.equals(password)) {
                Logger.info("loginUser.id %s", user.id.toString());
                renderText("ok");

            } else {
                Logger.info("loginUser.id  null");
                renderText("badPassword");
            }
        }else{

            renderText("badEmail");
        }

    }

    public static void delete(Long id) {
        User user = UserService.getById(id);
        Logger.info("loginUser.id %s", user.id.toString());
        notFoundIfNull(user);
        Long newId = user.id;
        String profil = user.firstName;

        user.delete();

        renderText("userDelete ");

    }

    public static void userCreate(String email , String password, String firstname, String lastname){


        User user = UserService.getByEmail(email);

        if (user==null){

            int client = UserService.createUser(email, password, firstname, lastname);
            Logger.info("userCreate.email %s", email);

            renderText("userCreate");


        }else{renderText("userExist");}



    }

    public static void changedPassword(String email){

        User newUser = UserService.getByEmail(email);

//        if (user==null){

        renderJSON(newUser);


//        }else{renderText("userExist");}


    }


}
