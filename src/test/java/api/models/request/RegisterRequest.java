package api.models.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegisterRequest {
    private String email;
    private String password;
}