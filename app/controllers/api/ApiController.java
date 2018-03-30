//package controllers.api;
//
//import models.utilisateur.User;
//import play.Logger;
//import play.Play;
//import play.libs.Codec;
//import play.mvc.Before;
//import play.mvc.Controller;
//import play.mvc.results.RenderJson;
//
//import java.util.Date;
//
//public class ApiController extends Controller {
//    @Before
//    static void before() {
//        Logger.info("nav %s", request.url);
//
//        if (Play.mode.isDev()) {
//            User apiUserDev = User.find("apiKey=?1", "6b11044b-83a7-47cc-897c-98b8c662209b").first();
//            long timestamp = new Date().getTime();
//            String control = Codec.hexSHA1(timestamp + apiUserDev.privateApiKey + apiUserDev.apiKey);
//            System.out.println("apiKey=" + apiUserDev.apiKey + "&timestamp=" + timestamp + "&control=" + control);
//        }
//
//        // Récupérer apiKey
//        String apiKey = request.params._contains("apiKey") ? request.params.get("apiKey") : "";
//
//        // Récupérer timestamp
//        String timestamp = request.params._contains("timestamp") ? request.params.get("timestamp") : "";
//
//        // Récupérer control
//        String control = request.params._contains("control") ? request.params.get("control") : "";
//
//
//
//        User apiUser = User.find("apiKey=?1", apiKey).first();
//        if (apiUser == null) {
//            response.status = 401;
//            throw new RenderJson("{\"code\": \"InvalidCredentials\", \"message\": \"The passed API key is invalid.\"}");
//        }
//
//        // Vérifier que le hash de timestamp + privateApiKey + apiKey = control
//        if (!control.equals(Codec.hexSHA1(timestamp + apiUser.privateApiKey + apiKey))) {
//            response.status = 401;
//            throw new RenderJson("{\"code\": \"InvalidCredentials\", \"message\": \"That timestamp, apiKey and control combination is invalid.\"}");
//        }
//
//
//    }
//
//}
