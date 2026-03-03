package ShopTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();  // Автоматически скачает драйвер
        Configuration.headless = true;
        // Добавляем слушатель Allure для Selenide (скриншоты при падениях)
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));

        // Настройки для Jenkins (headless режим)
        Configuration.headless = true;  // ← ВАЖНО!
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        System.out.println("✅ TestBase настроен для Jenkins (headless mode)");
    }
}