package ShopTest;

import ShopApi.AuthApi;
import io.qameta.allure.*;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Авторизация")
@Feature("Авторизация пользователя")
@Story("Пользователь успешно авторизуется через API")
@Owner("Daniil")
@Severity(SeverityLevel.CRITICAL)
@Link(name = "Сайт магазина", url = "https://demowebshop.tricentis.com/")

public class LoginAndGetCookiesTest extends TestBase {


    @Test
    @DisplayName("Авторизация и получение cookie")
    @Step("Отправить корректные данные и получить куки")
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