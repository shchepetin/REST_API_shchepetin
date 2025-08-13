package api.tests;

import api.endpoints.Endpoints;
import api.models.request.AuthRequest;
import api.models.request.UserRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.TestData.*;
import static api.specs.ApiSpecs.*;

@Tag("Jenkins")
@Owner("Ilya Shchepetin")
public class ReqresApiTest extends TestBase {

    @Feature("Тестирование метода получения информации о пользователе")
    @Tag("User")
    @Test
    @DisplayName("1. Получение информации о пользователе")
    void getUserTest() {
        given(requestSpec())
                .when()
                .get(Endpoints.USERS + "2")
                .then()
                .spec(responseSpec(200))
                .body("data.id", equalTo(2))
                .body("data.email", equalTo(USER_EMAIL));
    }

    @Feature("Тестирование метода регистрации нового пользователя")
    @Tag("Register")
    @Test
    @DisplayName("2. Регистрация нового пользователя")
    void registerUserTest() {
        AuthRequest registerData = new AuthRequest(REGISTER_EMAIL, REGISTER_PASSWORD);

        String token = given(requestSpec())
                .body(registerData)
                .when()
                .post(Endpoints.REGISTER)
                .then()
                .spec(responseSpec(200))
                .extract().path("token");

        assertNotNull(token, "Токен не должен быть null");
        assertFalse(token.isBlank(), "Токен не должен быть пустым");
    }

    @Feature("Тестирование метода авторизации пользователя")
    @Tag("Login")
    @Test
    @DisplayName("3. Авторизация пользователя")
    void loginUserTest() {
        AuthRequest loginData = new AuthRequest(LOGIN_EMAIL, LOGIN_PASSWORD);

        String token = given(requestSpec())
                .body(loginData)
                .when()
                .post(Endpoints.LOGIN)
                .then()
                .spec(responseSpec(200))
                .extract().path("token");

        assertNotNull(token, "Токен не должен быть null");
        assertFalse(token.isBlank(), "Токен не должен быть пустым");
    }

    @Feature("Тестирование метода честичного обновления информации о пользователе")
    @Tag("Patch")
    @Test
    @DisplayName("4. Частичное обновление пользователя (PATCH)")
    void patchUserTest() {
        UserRequest updateData = new UserRequest(null, USER_JOB);

        given(requestSpec())
                .body(updateData)
                .when()
                .patch(Endpoints.USERS + "2")
                .then()
                .spec(responseSpec(200))
                .body("job", equalTo(USER_JOB));
    }

    @Feature("Тестирование метода удаления пользователя")
    @Tag("Delete")
    @Test
    @DisplayName("5. Удаление пользователя")
    void deleteUserTest() {
        given(requestSpec())
                .when()
                .delete(Endpoints.USERS + "2")
                .then()
                .spec(responseSpec(204));
    }

    @Feature("Тестирование метода обновления информации о пользователе")
    @Tag("Put")
    @Test
    @DisplayName("6. Полное обновление пользователя (PUT)")
    void putUserTest() {
        UserRequest updateData = new UserRequest(USER_NAME, USER_JOB);

        given(requestSpec())
                .body(updateData)
                .when()
                .put(Endpoints.USERS + "2")
                .then()
                .spec(responseSpec(200))
                .body("name", equalTo(USER_NAME))
                .body("job", equalTo(USER_JOB));
    }
}