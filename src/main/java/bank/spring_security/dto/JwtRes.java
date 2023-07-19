package bank.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtRes {
    private String token;
    private String type = "Bearer";
    private String userName ;
    private String email;
    private String phone;
    private List<String> listRoles;

}
