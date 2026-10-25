package software.ulpgc.katas;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.katas.adapters.JsonRandomUserDeserializer;
import software.ulpgc.katas.adapters.dtos.UserDto;
import software.ulpgc.katas.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://randomuser.me/api?results=10")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            List<User> users = new JsonRandomUserDeserializer().deserializer(json);
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
