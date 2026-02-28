package ShopApi;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    private static final String BASE_URL = "https://demowebshop.tricentis.com";

    public Cookies loginAndGetCookies(String email, String password) {

        Response response = given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", email)
                .formParam("Password", password)
                .formParam("RememberMe", "false")
                .relaxedHTTPSValidation()
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract().response();

        return response.getDetailedCookies();



    }
}
