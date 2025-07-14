package api.models;

import lombok.Data;
import lombok.experimental.Accessors;

public class ApiRequestModels {

    @Data
    @Accessors(chain = true)
    public static class UserRequest {
        private String name;
        private String job;
    }

    @Data
    @Accessors(chain = true)
    public static class RegisterRequest {
        private String email;
        private String password;
    }

    @Data
    @Accessors(chain = true)
    public static class LoginRequest {
        private String email;
        private String password;
    }
}