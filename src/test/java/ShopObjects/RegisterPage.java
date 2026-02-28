package ShopObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {

    private SelenideElement genderMaleRadio = $("#gender-male");
    private SelenideElement firstNameInput = $("#FirstName");
    private SelenideElement lastNameInput = $("#LastName");
    private SelenideElement emailInput = $("#Email");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement passwordConfirmInput = $("#ConfirmPassword");
    private SelenideElement registerButton = $("#register-button");

    public void openRegister(){
        open("https://demowebshop.tricentis.com/register");
    }

    public void setGenderMaleRadio(){
        genderMaleRadio.click();
    }

    public void setFirstName(String firstName){
        firstNameInput.setValue(firstName);
    }

    public void setLastNameInput(String lastName){
        lastNameInput.setValue(lastName);
    }

    public void setEmailInput(String email){
        emailInput.setValue(email);
    }

    public void setPasswordInput(String password){
        passwordInput.setValue(password);
    }

    public void setPasswordConfirmInput(String password){
        passwordConfirmInput.setValue(password);
    }

    public void setRegisterButton(){
        registerButton.click();
    }

    public void Register(String firstName, String lastName, String email, String password){
        setGenderMaleRadio();
        setFirstName(firstName);
        setLastNameInput(lastName);
        setEmailInput(email);
        setPasswordInput(password);
        setPasswordConfirmInput(password);
        setRegisterButton();
    }
}