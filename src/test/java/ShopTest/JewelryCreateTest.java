package ShopTest;

import ShopObjects.JewelryPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JewelryCreateTest extends TestBase{

    private JewelryPage jewelryPage;

    @BeforeEach
    @Step("Open page to create Jewelry")
    public void setUp(){
        jewelryPage = new JewelryPage();
        jewelryPage.openPageJewelry();
    }

    @Test
    public void shouldHaveCorrectCountOfMaterialOptions(){

        int actualCount = jewelryPage.getMaterialOptionsCount();

        Allure.addAttachment("Количество опций", String.valueOf(actualCount));

        assertEquals(3,actualCount);
    }

    @Test
    public void shouldHaveCorrectMaterialOptions(){


        List<String> expectedOptions = Arrays.asList(
                "Gold (0,5 mm)",
                "Gold (1 mm)",
                "Silver (1 mm)"
        );

        List<String> actualOptions = jewelryPage.getMaterialOptionsText();

        Allure.addAttachment("Expected Options", expectedOptions.toString());
        Allure.addAttachment("Actual Options", actualOptions.toString());

        assertTrue(actualOptions.containsAll(expectedOptions));
    }


}
