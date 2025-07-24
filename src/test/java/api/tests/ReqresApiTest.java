package api.tests;

import api.endpoints.Endpoints;
import api.models.request.LoginRequest;
import api.models.request.RegisterRequest;
import api.models.request.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utils.TestData.*;
import static api.specs.ApiSpecs.*;

public class ReqresApiTest extends TestBase {

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

    @Test
    @DisplayName("5. Удаление пользователя")
    void deleteUserTest() {
        given(requestSpec())
                .when()
                .delete(Endpoints.USERS + "2")
                .then()
                .spec(responseSpec(204));
    }

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