package cat.xtec.ioc.client;

import org.springframework.web.client.RestTemplate;

public class Main {

    private static final String BASE_URL = "http://localhost:8080/rendacatalunya/rendes";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        RendaClient[] rendes = restTemplate.getForObject(BASE_URL + "/2013", RendaClient[].class);

        for (RendaClient renda : rendes) {          
            System.out.println(renda.toString());
            System.out.println("---------------------------");

        }
    }
}
