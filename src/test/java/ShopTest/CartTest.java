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

@Epic("Корзина покупок")
@Feature("Добавление товаров в корзину")
@Story("Пользователь добавляет товар в корзину через API")
@Owner("Daniil")
@Severity(SeverityLevel.CRITICAL)
@Link(name = "Сайт магазина", url = "https://demowebshop.tricentis.com/")
public class CartTest extends TestBase{

    private CartApi cartApi;
    private AuthApi authApi;
    private Cookies authCookies;
    private final String email = "daniil123@mail.ru";
    private final String password = "password";
    private final int LAPTOP_ID = 31;

    @BeforeEach
    @Step("Подготовка теста: авторизация и получение куки")
    public void setUp() {
        cartApi = new CartApi();
        authApi = new AuthApi();
        // Получаем свежие куки перед каждым тестом
        authCookies = authApi.loginAndGetCookies(email, password);
        System.out.println("✅ Получены свежие куки: " + authCookies.getValue("Nop.customer"));
    }

    @Test
    @DisplayName("Добавление товара в корзину через API")
    @Step("Отправка запроса на добавление товара")
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