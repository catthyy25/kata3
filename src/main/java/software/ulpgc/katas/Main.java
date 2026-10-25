package software.ulpgc.katas;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        try (HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://randomuser.me/api?results=10")).GET().build();
        }
    }
}
