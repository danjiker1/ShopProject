import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Демо-проект")
@Feature("Примеры тестов")
public class AllureSampleTest extends TestBase {

    @Test
    @DisplayName("Простой тест с шагами")
    @Description("Этот тест показывает, как работают шаги Allure")
    @Severity(SeverityLevel.NORMAL)
    @Story("Базовые проверки")
    public void simpleTestWithSteps() {
        stepOne();
        stepTwo();
    }

    @Step("Шаг 1: Успешная проверка")
    private void stepOne() {
        assertTrue(true);
        Allure.addAttachment("Результат", "Шаг 1 выполнен успешно");
    }

    @Step("Шаг 2: Ещё одна проверка")
    private void stepTwo() {
        assertTrue(2 > 1);
    }

    private void assertTrue(boolean condition) {
        org.junit.jupiter.api.Assertions.assertTrue(condition);
    }
}