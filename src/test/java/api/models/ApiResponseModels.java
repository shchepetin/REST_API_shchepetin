package api.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiResponseModels {

    public static class UserResponse {
        private String name;
        private String job;
        private String updatedAt;
    }

    public static class RegisterResponse {
        private Integer id;
        private String token;
    }

    public static class LoginResponse {
        private String token;
    }

    public static class GetUserResponse {
        private Data data;
        private Support support;

        @Data
        public static class Data {
            private Integer id;
            private String email;
            private String first_name;
            private String last_name;
            private String avatar;
        }

        @Data
        public static class Support {
            private String url;
            private String text;
        }
    }
}