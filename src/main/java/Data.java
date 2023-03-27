import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Data {
    public static void main(String[] args) throws InterruptedException {

        RestTemplate restTemplate = new RestTemplate();

        Random random = new Random();

        Map<String, Object> weather = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            int t = random.nextInt(-50, 50);
            weather.put("value", t);
            weather.put("raining", isRaining(t));
            weather.put("sensor", new Sensor("Rad23"));
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(weather);
            String url = "http://localhost:8090/measurements/add";
            String response = restTemplate.postForObject(url, request, String.class);
            System.out.println(response);
        }

    }

    public static boolean isRaining(int t) {
        return t % 2 == 0;
    }

    public static class Sensor {
        String owner;

        public Sensor(String owner) {
            this.owner = owner;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}
