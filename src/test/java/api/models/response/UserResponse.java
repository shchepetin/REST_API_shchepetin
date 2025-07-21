package api.models.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponse {
    private String name;
    private String job;
    private String updatedAt;
}