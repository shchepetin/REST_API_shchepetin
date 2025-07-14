package api.models;

import lombok.Data;
import lombok.experimental.Accessors;

public class ApiResponseModels {

    @Data
    @Accessors(chain = true)
    public static class UserResponse {
        private String name;
        private String job;
        private String updatedAt;
    }

    @Data
    @Accessors(chain = true)
    public static class RegisterResponse {
        private Integer id;
        private String token;
    }

    @Data
    @Accessors(chain = true)
    public static class LoginResponse {
        private String token;
    }

    @Data
    @Accessors(chain = true)
    public static class GetUserResponse {
        private UserData data;
        private Support support;

        @Data
        @Accessors(chain = true)
        public static class UserData {
            private Integer id;
            private String email;
            private String first_name;
            private String last_name;
            private String avatar;
        }

        @Data
        @Accessors(chain = true)
        public static class Support {
            private String url;
            private String text;
        }
    }
}