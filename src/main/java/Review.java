import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Review {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8090/measurements";
        String response = restTemplate.getForObject(url, String.class);
        assert response != null;
        String[] str = response.split("},");
        Arrays.stream(str).forEach(System.out::println);
    }
}