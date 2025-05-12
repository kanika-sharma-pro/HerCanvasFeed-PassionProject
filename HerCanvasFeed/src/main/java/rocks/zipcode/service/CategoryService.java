package rocks.zipcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_KEY = "6dca2ab7dcf4454ab9c523300489ff2e";
    private final String BASE_URL = "https://newsapi.org/v2/everything?q=tesla&from=2025-04-07&sortBy=publishedAt&apiKey=6dca2ab7dcf4454ab9c523300489ff2e";

public String getNewsByCategory(String world) {
    String url = BASE_URL + "?q=" + world + "&appid=" + API_KEY;

    return restTemplate.getForObject(url, String.class);



}

}
