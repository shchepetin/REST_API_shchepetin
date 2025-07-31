package api.tests;

import api.endpoints.Endpoints;
import api.models.request.LoginRequest;
import api.models.request.RegisterRequest;
import api.models.request.UserRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utils.TestData.*;
import static api.specs.ApiSpecs.*;

public class ReqresApiTest extends TestBase {

    @Owner("Ilya Shchepetin")
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

    @Owner("Ilya Shchepetin")
    @Feature("Тестирование метода регистрации нового пользователя")
    @Tag("Register")
    @Test
    @DisplayName("2. Регистрация нового пользователя")
    void registerUserTest() {
        RegisterRequest registerData = new RegisterRequest(REGISTER_EMAIL, REGISTER_PASSWORD);

        given(requestSpec())
                .body(registerData)
                .when()
                .post(Endpoints.REGISTER)
                .then()
                .spec(responseSpec(200))
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @Owner("Ilya Shchepetin")
    @Feature("Тестирование метода авторизации пользователя")
    @Tag("Login")
    @Test
    @DisplayName("3. Авторизация пользователя")
    void loginUserTest() {
        LoginRequest loginData = new LoginRequest(LOGIN_EMAIL, LOGIN_PASSWORD);

        given(requestSpec())
                .body(loginData)
                .when()
                .post(Endpoints.LOGIN)
                .then()
                .spec(responseSpec(200))
                .body("token", equalTo(LOGIN_TOKEN));
    }

    @Owner("Ilya Shchepetin")
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

    @Owner("Ilya Shchepetin")
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

    @Owner("Ilya Shchepetin")
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