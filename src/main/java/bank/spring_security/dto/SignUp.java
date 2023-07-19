package bank.spring_security.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Data
public class SignUp {
    private String UserName;
    private String password;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdDateTime = new Date();

    private int userStatus = 1;

    private Set<String> listRoles;

}
