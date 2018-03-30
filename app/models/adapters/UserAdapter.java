package models.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.utilisateur.User;

import java.lang.reflect.Type;

public class UserAdapter implements JsonSerializer<User> {

    public static UserAdapter instance;

    private UserAdapter() {
    }

    public static UserAdapter get() {
        if (instance == null) {
            instance = new UserAdapter();
        }
        return instance;
    }

    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject obj = new JsonObject();
        obj.addProperty("email", user.email );
        obj.addProperty("firstname", user.firstName );
        obj.addProperty("lastname", user.lastName );


        return obj;
    }

}
