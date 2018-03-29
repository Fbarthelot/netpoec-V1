package controllers;

import models.utilisateur.User;
import play.mvc.Controller;
import play.mvc.With;
import services.UserService;

@With(Secure.class)
public class UserController extends Controller{

    public static void index() {
        Security.isConnected();
        render();
    }

    public static void userProfil(Long id) {

        User user=UserService.getById(id);

        render(user);

    }

    public static void detailUser() {

        String session= request.cookies.get("PLAY_SESSION").value.toString();
        String[] mailList=session.split("username=");
        String mail=mailList[1];
        String mail2=mail.replace("%40","@");


        User user = UserService.getByEmail(mail2);
        if (user == null) {
            index();
        }
        userProfil(user.id);
    }

    public static void  saveNewPassword(Long id,String password){
//        session.clear();

       Long newID = UserService.saveNewPassword(id,password);
//        session.put("username",user.email);
        User user=UserService.getById(id);

        userProfil(newID);
    }



}
