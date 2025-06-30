import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static final String API_KEY_NAME = "x-api-key";
    protected static final String API_KEY_VALUE = "reqres-free-v1";
    protected static final String USERS_ENDPOINT = "/users/";
    protected static final String REGISTER_ENDPOINT = "/register";
    protected static final String LOGIN_ENDPOINT = "/login";

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }
}
