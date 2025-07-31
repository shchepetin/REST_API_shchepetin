package api.models.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegisterResponse {
    private Integer id;
    private String token;
}
