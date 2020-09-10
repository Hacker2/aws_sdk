package book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    static ObjectMapper mapper = new ObjectMapper();

    public static <T> T readValue(String json, Class<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApiGatewayResponse writeValueAsString(Object object) {
        try {
            String responseBody = mapper.writeValueAsString(object);
            return new ApiGatewayResponse(200, responseBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ApiGatewayResponse(500, "Can't parse json");
        }
    }
}
