package bank.spring_security.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private int roleId;

    @Column(name = "RoleName")
    @Enumerated
    private ERoles roleName;

}
