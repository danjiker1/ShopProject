package ShopApi;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CartApi {

    private static final String BASE_URL = "https://demowebshop.tricentis.com";
    private final AuthApi authApi;

    public CartApi(){
        this.authApi = new AuthApi();
    }

    public Response addToCard(Cookies cookies, int productId, int quantity){
        return given()
                .baseUri(BASE_URL)
                .cookies(cookies)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("addtocart_" + productId + ".EnteredQuantity", quantity)
                .relaxedHTTPSValidation()
                .when()
                .post("/addproducttocart/details/" + productId + "/" + quantity)
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response addToCardWithLogin(String email, String password, int productId, int quantity){
        Cookies cookies = authApi.loginAndGetCookies(email, password);

        return addToCard(cookies, productId, quantity);
    }
}