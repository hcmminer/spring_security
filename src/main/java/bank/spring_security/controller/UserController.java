package bank.spring_security.controller;

import bank.spring_security.dto.MessageRes;
import bank.spring_security.dto.SignUp;
import bank.spring_security.jwt.JwtProvider;
import bank.spring_security.models.ERoles;
import bank.spring_security.models.Roles;
import bank.spring_security.models.Users;
import bank.spring_security.service.RoleService;
import bank.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUp signUp) {
        if (userService.existsByUserName(signUp.getUserName())) {
            return ResponseEntity.badRequest().body(new MessageRes("User Name is exist"));
        }

        if (userService.existsByEmail(signUp.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageRes("Email is exists"));

        }

        Users user = new Users();
        user.setUserName(signUp.getUserName());
        user.setPassword(passwordEncoder.encode(signUp.getPassword()));
        user.setEmail(signUp.getEmail());
        user.setPhone(signUp.getPhone());

        Set<String> strRoles = signUp.getListRoles();
        Set<Roles> listRoles = new HashSet<>();

        if (strRoles == null) {
            Roles userRole = roleService.findByRoleName(ERoles.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
            listRoles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        Roles adminRole = roleService.findByRoleName(ERoles.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                        listRoles.add(adminRole);
                    case "MOD":
                        Roles modRole = roleService.findByRoleName(ERoles.ROLE_MOD).orElseThrow(() -> new RuntimeException("Role not found"));
                        listRoles.add(modRole);
                    case "USER":
                        Roles userRole = roleService.findByRoleName(ERoles.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
                        listRoles.add(userRole);
                }
            });
        }

        user.setListRoles(listRoles);
        userService.addOrUpdate(user);
        return ResponseEntity.ok(new MessageRes("User registered successfully"));



    }


}
