package api.tests;

import api.models.ApiRequestModels;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utils.TestData.*;
import static api.specs.ApiSpecs.*;

public class ReqresApiTest {

    @Test
    @DisplayName("1. Получение информации о пользователе")
    void getUserTest() {
        given(requestSpec())
                .when()
                .get(USERS_ENDPOINT + "2")
                .then()
                .spec(responseSpec(200))
                .body("data.id", equalTo(2))
                .body("data.email", equalTo(USER_EMAIL));
    }

    @Test
    @DisplayName("2. Регистрация нового пользователя")
    void registerUserTest() {
        ApiRequestModels.RegisterRequest registerData = new ApiRequestModels.RegisterRequest()
                .setEmail(REGISTER_EMAIL)
                .setPassword(REGISTER_PASSWORD);

        given(requestSpec())
                .body(registerData)
                .when()
                .post(REGISTER_ENDPOINT)
                .then()
                .spec(responseSpec(200))
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @Test
    @DisplayName("3. Авторизация пользователя")
    void loginUserTest() {
        ApiRequestModels.LoginRequest loginData = new ApiRequestModels.LoginRequest()
                .setEmail(LOGIN_EMAIL)
                .setPassword(LOGIN_PASSWORD);

        given(requestSpec())
                .body(loginData)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .spec(responseSpec(200))
                .body("token", equalTo(LOGIN_TOKEN));
    }

    @Test
    @DisplayName("4. Частичное обновление пользователя")
    void patchUserTest() {
        ApiRequestModels.UserRequest updateData = new ApiRequestModels.UserRequest()
                .setJob(USER_JOB);

        given(requestSpec())
                .body(updateData)
                .when()
                .patch(USERS_ENDPOINT + "2")
                .then()
                .spec(responseSpec(200))
                .body("job", equalTo(USER_JOB));
    }

    @Test
    @DisplayName("5. Удаление пользователя")
    void deleteUserTest() {
        given(requestSpec())
                .when()
                .delete(USERS_ENDPOINT + "2")
                .then()
                .spec(responseSpec(204));
    }

    @Test
    @DisplayName("6. Полное обновление пользователя (PUT)")
    void putUserTest() {
        ApiRequestModels.UserRequest updateData = new ApiRequestModels.UserRequest()
                .setName(USER_NAME)
                .setJob(USER_JOB);

        given(requestSpec())
                .body(updateData)
                .when()
                .put(USERS_ENDPOINT + "2")
                .then()
                .spec(responseSpec(200))
                .body("name", equalTo(USER_NAME))
                .body("job", equalTo(USER_JOB));
    }
}