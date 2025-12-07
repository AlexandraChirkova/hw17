package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    void successfulLoginTest() {
        loginPage.openLoginPage()
                .setUserName("admin")
                .setPassword("5qA!H6mY8C@ck7x")
                .clickLogin();
        profilePage.checkUrl()
                .checkUserNameAfterLogin("admin");
    }

}
