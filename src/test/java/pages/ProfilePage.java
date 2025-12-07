package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ProfilePage {
    public final SelenideElement titleUserName = $("#userName-value");
    public final SelenideElement userNameLabel = $(".col-md-5 > #userName-label");

    @Step("Открыть страницу профайла")
    public ProfilePage openPage() {
        open("/profile");
        $(".loading").should(disappear);
        userNameLabel.shouldBe(visible);
        return this;
    }

    @Step("Проверить урл страницы")
    public ProfilePage checkUrl(){
        webdriver().shouldHave(urlContaining("profile"));
        return this;
    }

    @Step("Проверить User Name")
    public ProfilePage checkUserNameAfterLogin(String userName){
        titleUserName.shouldBe(visible).shouldHave(text(userName));
        return this;

    }
}
