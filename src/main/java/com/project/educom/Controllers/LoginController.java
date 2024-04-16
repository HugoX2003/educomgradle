package com.project.educom.Controllers;

import com.project.educom.Models.Comentario;
import com.project.educom.Models.Usuario;
import com.project.educom.Services.LoginService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody Usuario usuario){
        try{
            String newUser = loginService.addUser(usuario);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (IllegalStateException sms){
            return new ResponseEntity<>(sms.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody Usuario updatedUser, @PathVariable Long userId) {
        try {
            String message = loginService.updateUser(updatedUser, userId);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        try {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");
            Usuario loginuser = loginService.verifyAccount(email, password);
            return new ResponseEntity<>(loginuser, HttpStatus.OK);
        }catch (IllegalStateException sms){
            return new ResponseEntity<>(sms.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
