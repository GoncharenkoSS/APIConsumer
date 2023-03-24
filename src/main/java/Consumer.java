import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Consumer {
    public static void main(String[] args) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();

        Random random = new Random();

        Map<String, String> weather = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            int t = random.nextInt(-50, 50);
            weather.put("weather", randomWeather(t));
            weather.put("temp", String.valueOf(t));
        }

    HttpEntity<Map<String, String>> request = new HttpEntity<>(weather);
    String url = "http://localhost:8090/people";
    String response = restTemplate.postForObject(url, request, String.class);

    //FOR GET//String url = "https://reqres.in/api/users?page=2";
    //FOR GET// String response = restTemplate.getForObject(url, String.class);
    System.out.println(response);
        }

    public static String randomWeather(int t) {
        if (t > 0 & t < 20) return "Дождь";
        else if (t > 19) return "Ясно";
        else return "Снег";
    }
}
