package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ProfilePage {
    public final SelenideElement titleUserName = $("#userName-value");

    @Step("Открыть страницу логина")
    public ProfilePage openPage() {
        open("/profile");
        return this;
    }

    @Step("Проверить урл страницы")
    public ProfilePage checkUrl(){
        webdriver().shouldHave(urlContaining("profile"));
        return this;
    }

    @Step("Проверить User Name")
    public ProfilePage checkUserNameAfterLogin(String userName){
        titleUserName.shouldHave(text(userName));
        return this;

    }
}
