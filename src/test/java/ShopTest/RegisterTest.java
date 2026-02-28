package ShopTest;

import ShopObjects.RegisterPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

@Epic("Register")
@Feature("User register")
@Story("User registration UI")
@Owner("Daniil")
@Severity(SeverityLevel.CRITICAL)
@Link(name = "Shop", url = "https://demowebshop.tricentis.com/")

public class RegisterTest extends TestBase{


    @Test
    @Step("Register and submit")
    public void userRegisterTest(){

        String firstName = "Daniil";
        String lastName = "Egorov";
        String email = "Daniil_" + System.currentTimeMillis() + "@test.com";
        String password = "password";

        RegisterPage registration= new RegisterPage();
        registration.openRegister();
        registration.Register(firstName, lastName, email, password);

        $(".result").shouldHave(Condition.text("Your registration completed"));
    }
}