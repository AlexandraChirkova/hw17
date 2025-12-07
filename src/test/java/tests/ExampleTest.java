package tests;

import extension.WithLogin;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import models.LoginResponse;
import models.UserCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;

@WithLogin
public class ExampleTest extends BaseTest {

    ProfilePage profilePage = new ProfilePage();
    UserCredentials bodyUser = new UserCredentials();
    LoginPage loginPage = new LoginPage();

    @Test
    @Description("Отправляет POST запрос для логина")
    @DisplayName("Логин пользователя")
    void registerUserSuccessTest() {
    /*    bodyUser.setUserName("admin");
        bodyUser.setPassword("5qA!H6mY8C@ck7x");

        LoginResponse loginResponse =  Allure.step("Выполняем регистрацию пользователя", () ->
                given(requestSpec)
                        .body(bodyUser)

                        .when()
                        .post("/Account/v1/Login")

                        .then()
                        .spec(responseSpec(200))
                        .extract().as(LoginResponse.class));

        loginPage.openLoginPage();
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("username", loginResponse.getUsername()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));*/

        profilePage.openPage()
                .checkUrl()
                .checkUserNameAfterLogin("admin");

    }

}
