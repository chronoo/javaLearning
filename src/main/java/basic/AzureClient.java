package basic;

import java.util.Properties;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 * AzureClient - извлекает данные из Azure DevOps
 */
public class AzureClient {
    private final static String PATH_TO_PROPERTIES = "src/main/resources/auth.properties";
    private final static Properties properties = PropertyManager.getProperties(PATH_TO_PROPERTIES);
    private final static String base64token = getbase64token();

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://dev.azure.com/")
                // хардкод, надо вынести в чтение из настроек
                .path("ushakovad/test_project/_apis/work/processconfiguration");

        Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
        Response response = builder.accept("application/json")
                .header("Authorization", "Basic " + base64token)
                .get();

        System.out.println(response.getStatus());
        // надо сделать десериализацию из JSON
        System.out.println(response.readEntity(String.class));
    }

    private static String getbase64token() {
        String token = properties.getProperty("Base64Token");
        return token;
    }
}