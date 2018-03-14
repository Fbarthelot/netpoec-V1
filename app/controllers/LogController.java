package controllers;

import play.Logger;
import play.mvc.Before;
import play.mvc.Controller;

public class LogController extends Controller {

    @Before
    static void before() {
        Logger.info("nav %s", request.url);
    }

}
