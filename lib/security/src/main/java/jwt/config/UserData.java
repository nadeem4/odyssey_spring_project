package jwt.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserData {

    private String userId;

    private String username;

    private String firstName;

    private String lastName;

    private String hashedPass;

    private List<String> roles;
}
