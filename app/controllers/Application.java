package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import services.UserService;

public class Application extends Controller {

    public static void index() {

        render();
    }

    public static void connexion() {
        UserController.index();
    }

    public static void addUser(){
        render();
    }
    public static void saveNewUser(String email, String password, String firstName, String lastName){
        int result=UserService.createUser(email, password, firstName, lastName);
        if(result==1){
            Security.authenticate(email, password);
            UserController.index();
        }

        addUser();
    }

}