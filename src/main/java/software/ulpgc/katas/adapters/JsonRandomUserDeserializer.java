package software.ulpgc.katas.adapters;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.katas.adapters.dtos.UserDto;
import software.ulpgc.katas.model.Gender;
import software.ulpgc.katas.model.User;
import software.ulpgc.katas.ports.UserDeserializer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class JsonRandomUserDeserializer implements UserDeserializer {
    @Override
    public List<User> deserialize(String json) {
        return deserialize(new Gson().fromJson(json, JsonObject.class).get("results").getAsJsonArray());
    }

    private List<User> deserialize(JsonArray array) {
        List<User> users = new ArrayList<>();
        for (JsonElement item : array) {
            users.add(deserialize(item));
        }
        return users;
    }

    private User deserialize(JsonElement item) {
        return deserialize(new Gson().fromJson(item, UserDto.class));
    }

    private User deserialize(UserDto user) {
        return new User(
                String.join(" ", user.name.title, user.name.first, user.name.last),
                Gender.valueOf(user.gender),
                Instant.parse(user.dob.date)
        );
    }
}
