package ShopTest;

import ShopApi.AuthApi;
import io.qameta.allure.*;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Authentication")
@Feature("User Authorization")
@Story("User successfully authenticates via API")
@Owner("Daniil")
@Severity(SeverityLevel.CRITICAL)
@Link(name = "Website", url = "https://demowebshop.tricentis.com/")

public class LoginAndGetCookiesTest extends TestBase {


    @Test
    @DisplayName("Login and get cookies")
    @Description("This test verifies that user can login via API and receive authentication cookies")
    public void testLoginAndGetCookies(){

        AuthApi authApi = new AuthApi();

        String email = "daniil123@mail.ru";
        String password = "password";

        Cookies cookies = authApi.loginAndGetCookies(email, password);

        assertNotNull(cookies);

        if (cookies.getValue("Nop.customer") != null) {
            System.out.println("✅ Нашли Nop.customer: " + cookies.getValue("Nop.customer"));
        } else {
            System.out.println("❌ Nop.customer не найден в ответе");
        }

    }
}