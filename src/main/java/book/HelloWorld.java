package book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

    ObjectMapper mapper = new ObjectMapper();

    public String handler(String hello) {
        return "hello world" + hello;
    }

    public Map<String,String> handlerMap() {
        Map<String, String> map = new HashMap<>();
        map.put("body", "hello world");
        return map;
    }

    public ApiGatewayResponse handlerResponse(ApiGatewayRequest apiGatewayRequest)
        throws JsonProcessingException {
        System.out.println(apiGatewayRequest.body);
//        Person person = mapper.readValue(apiGatewayRequest.body, Person.class);
        Person person = JsonParser.readValue(apiGatewayRequest.body, Person.class);
        System.out.println(person.getName());
        System.out.println(apiGatewayRequest.queryStringParameters);
//        String json = mapper.writeValueAsString(person);
        return JsonParser.writeValueAsString(person);
    }

    public static void main(String[] args) throws JsonProcessingException {
        HelloWorld helloWorld = new HelloWorld();
        ApiGatewayRequest apiGatewayRequest = new ApiGatewayRequest();
        apiGatewayRequest.body = "{\"name\":\"max\"}";
        helloWorld.handlerResponse(apiGatewayRequest);
    }

    public boolean handlerBoolean(boolean b) {
        return !b;
    }

    public int handlerInteger(int i) {
        return i + i;
    }
}