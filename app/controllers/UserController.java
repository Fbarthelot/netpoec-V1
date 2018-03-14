package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.With;
import services.UserService;

import java.util.List;

@With(Secure.class)
public class UserController extends Controller{
    public static void index() {

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
        System.out.println(mail2);

        User user = UserService.getByEmail(mail2);
        if (user == null) {
            render();
        }
        userProfil(user);
    }

    public static void  saveNewPassword(User user,String password){
        UserService.saveNewPassord(user,password);

        userProfil(user);
    }



}
