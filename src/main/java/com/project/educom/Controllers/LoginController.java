package com.project.educom.Controllers;

// import com.project.educom.Models.Comentario;
import com.project.educom.Models.Usuario;
import com.project.educom.Services.LoginService;
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

    @GetMapping
    private List<Usuario> getAllUsers(){
        return loginService.getAllUsers();
    }

    @GetMapping("/{userid}")
    public Usuario getUserById(@PathVariable Long userid){
        return loginService.getUserById(userid).orElse(new Usuario());
    }

    @PostMapping
    public void addUser(@RequestBody Usuario usuario){
        loginService.addUser(usuario);
    }

    @PutMapping("/{userid}")
    public void addUser(@RequestBody Usuario usuario, @PathVariable Long userid){
        loginService.updateUser(usuario, userid);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable Long userid){
        loginService.deleteUserById(userid);
    }

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
    String email = loginRequest.get("email");
    String password = loginRequest.get("password");
    Usuario usuario = loginService.verifyAccount(email, password);

    if (usuario != null) {
        String comment = "Estás de vuelta, " + usuario.getFirstName() + " " + usuario.getLastName() + "!";
        return new ResponseEntity<>(comment, HttpStatus.OK);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

}
