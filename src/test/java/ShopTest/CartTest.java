package ShopTest;

import ShopApi.AuthApi;
import ShopApi.CartApi;
import io.qameta.allure.*;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Shopping Cart")
@Feature("Add to Cart")
@Story("User adds product to cart via API")
@Owner("Daniil")
@Severity(SeverityLevel.CRITICAL)
@Link(name = "Website", url = "https://demowebshop.tricentis.com/")


public class CartTest extends TestBase{

    private CartApi cartApi;
    private AuthApi authApi;
    private Cookies authCookies;
    private final String email = "daniil123@mail.ru";
    private final String password = "password";
    private final int LAPTOP_ID = 31;

    @BeforeEach
    @Step("Test setup: authenticate and get cookies")
    public void setUp() {
        cartApi = new CartApi();
        authApi = new AuthApi();
        // Получаем свежие куки перед каждым тестом
        authCookies = authApi.loginAndGetCookies(email, password);
        System.out.println("✅ Получены свежие куки: " + authCookies.getValue("Nop.customer"));
    }

    @Test
    @DisplayName("Add product to cart via API")
    @Description("Verify that product can be successfully added to shopping cart")
    public void addToCart(){
        Response response = cartApi.addToCard(authCookies, LAPTOP_ID, 1);

        assertEquals(200, response.statusCode());

        String responseBody = response.asString();
        System.out.println("=== ПОЛНЫЙ ОТВЕТ ОТ СЕРВЕРА ===");
        System.out.println(responseBody);
        System.out.println("==============================");

        assertTrue(responseBody.contains("\"success\":true"));


    }
}