import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class ReqresTests extends TestBase {

    @Test
    @DisplayName("1. Получение информации о пользователе")
    void getUserTest() {
        given()
                .header(API_KEY_NAME, API_KEY_VALUE)
                .log().uri()
                .when()
                .get(USERS_ENDPOINT + "2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .log().all();
    }

    @Test
    @DisplayName("2. Регистрация нового пользователя")
    void registerUserTest() {
        String userData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";

        given()
                .header(API_KEY_NAME, API_KEY_VALUE)
                .contentType(JSON)
                .body(userData)
                .log().uri()
                .when()
                .post(REGISTER_ENDPOINT)
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @Test
    @DisplayName("3. Авторизация пользователя")
    void loginUserTest() {
        String loginData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        given()
                .header(API_KEY_NAME, API_KEY_VALUE)
                .contentType(JSON)
                .body(loginData)
                .log().uri()
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @DisplayName("4. Частичное обновление пользователя")
    void patchUserTest() {
        String patchData = "{\"job\": \"zion resident\"}";

        given()
                .header(API_KEY_NAME, API_KEY_VALUE)
                .contentType(JSON)
                .body(patchData)
                .log().uri()
                .when()
                .patch(USERS_ENDPOINT + "2")
                .then()
                .statusCode(200)
                .body("job", equalTo("zion resident"))
                .body("updatedAt", containsString("T"));
    }

    @Test
    @DisplayName("5. Удаление пользователя")
    void deleteUserTest() {
        given()
                .header(API_KEY_NAME, API_KEY_VALUE)
                .log().uri()
                .when()
                .delete(USERS_ENDPOINT + "2")
                .then()
                .statusCode(204);
    }
}