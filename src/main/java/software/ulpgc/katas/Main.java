package software.ulpgc.katas;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.katas.adapters.dtos.UserDto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://randomuser.me/api?results=10")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            JsonArray results = new Gson().fromJson(json, JsonObject.class).get("results").getAsJsonArray();
            for (JsonElement result : results) {
                UserDto user = new Gson().fromJson(result, UserDto.class);
                System.out.println(String.join(" ",
                        user.name.first,
                        user.name.last,
                        user.gender,
                        Integer.toString(user.dob.age)));
            }
        }
    }
}
