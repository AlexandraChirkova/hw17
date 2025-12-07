package tests;

import extension.AuthData;
import extension.WithLogin;
import io.qameta.allure.Description;
import models.AddBooksRequest;
import models.Isbn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DeleteAllBooksModal;
import pages.ProfilePage;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpecAuth;
import static specs.Specs.responseSpec;

@WithLogin
public class DeleteBooksTest extends BaseTest{

    ProfilePage profilePage = new ProfilePage();
    DeleteAllBooksModal deleteAllBooksModal = new DeleteAllBooksModal();

    @Test
    @Description("Удаляем книги из списка")
    @DisplayName("Удалить книги")
    void deleteBooksSuccessTest() {

        given()
                .spec(requestSpecAuth(AuthData.token))
                .delete("/BookStore/v1/Books?UserId=" + AuthData.userId)
                .then()
                .statusCode(204);

        AddBooksRequest body = new AddBooksRequest();
        body.setUserId(AuthData.userId);

        Isbn isbn = new Isbn();
        isbn.setIsbn("9781491904244");

        body.setCollectionOfIsbns(Collections.singletonList(isbn));

        given(requestSpecAuth(AuthData.token))
                .body(body)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec(201));

        profilePage.openPage()
                .checkUrl()
                .checkUserNameAfterLogin("admin")
                .checkBookAvailable()
                .deleteBookClick();
        deleteAllBooksModal.deleteBook();
        profilePage.checkEmptyBooksList();

    }
}
