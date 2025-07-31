package api.models.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetUserResponse {
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