package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginPage {

    private final SelenideElement titleForm = $(".text-center");
    private final SelenideElement userName =$("#userName");
    private final SelenideElement passwordInput =$("#password");
    private final SelenideElement LoginButton =$("#login");


    @Step("Открыть страницу логина")
    public LoginPage openLoginPage() {
        open("/login");
        titleForm.shouldHave(text("Login"));
        return this;
    }

    @Step("Ввести Login")
    public LoginPage setUserName(String name) {
        userName.setValue(name);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать кнопку логин")
    public void clickLogin() {
        LoginButton.click();
    }

}
