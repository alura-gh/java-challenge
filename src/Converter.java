import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Converter {
    private static String API_KEY;
    private final String API_URL;
    private String base_code;
    private String target_code;

    public Converter(String base_code, String target_code) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.API_URL = "https://v6.exchangerate-api.com/v6/" + Converter.API_KEY + "/pair/" + base_code + "/" + target_code;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    // methods
    public static void inputAPIKey() {
        Scanner scn = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Ingrese la API Key:");
        Converter.API_KEY = scn.nextLine();
        System.out.println("-------------------------");
    }

    public void requestAPI(double value) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String data = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            ResultRecord resultRecord = gson.fromJson(data, ResultRecord.class);
            ResultModel resultModel = new ResultModel(resultRecord, value);
            System.out.println(resultModel);

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error de interrupción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
