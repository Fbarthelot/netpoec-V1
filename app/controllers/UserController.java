package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.With;
import services.UserService;

import java.util.List;

@With(Secure.class)
public class UserController extends Controller{

    public static void index() {
        Security.isConnected();
        render();
    }

    public static void userProfil(User user) {

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
        userProfil(user);
    }

    public static void  saveNewPassword(User user,String password){
//        session.clear();
        UserService.saveNewPassword(user,password);
//        session.put("username",user.email);
        userProfil(user);
    }



}
