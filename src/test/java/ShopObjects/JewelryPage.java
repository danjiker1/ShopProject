package ShopObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class JewelryPage {

    private final SelenideElement materialDropdown = $("#product_attribute_71_9_15");

    private final ElementsCollection materialOptions = $$("#product_attribute_71_9_15 option");


    @Step("Open page Create Jewelry")
    public void openPageJewelry(){

        open("https://demowebshop.tricentis.com/create-it-yourself-jewelry");
    }

    @Step("Get material options")
    public List<String> getMaterialOptionsText(){

        return materialOptions.texts();
    }

    @Step("Get material options count")
    public int getMaterialOptionsCount(){

        return materialOptions.size();

    }


}
