import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Registration {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> regSensor = new HashMap<>();
        regSensor.put("name", "Rad23");
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(regSensor);
        String url = "http://localhost:8080/sensors/registration";
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);

    }
}
