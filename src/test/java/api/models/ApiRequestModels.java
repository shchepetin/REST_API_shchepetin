package api.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiRequestModels {

    public static class UserRequest {
        private String name;
        private String job;
    }

    public static class RegisterRequest {
        private String email;
        private String password;
    }

    public static class LoginRequest {
        private String email;
        private String password;
    }
}