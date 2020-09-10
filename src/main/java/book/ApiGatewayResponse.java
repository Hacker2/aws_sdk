package book;

public class ApiGatewayResponse {
  public int statusCode;
  public String body;

  public ApiGatewayResponse(int statusCode, String body) {
    this.statusCode = statusCode;
    this.body = body;
  }

}
