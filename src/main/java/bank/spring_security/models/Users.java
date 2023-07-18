package bank.spring_security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "UserName", unique = true, nullable = false)
    private String UserName;

    @Column(name = "PassWord", nullable = false)
    private String password;

    @Column(name = "createdDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdDatetime;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Phone", unique = true)
    private String phone;


    @Column(name = "UserStatus")
    private int userStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Users_Roles", joinColumns = @JoinColumn(name= "UserId"), inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Roles> listRoles = new HashSet<>();
}
