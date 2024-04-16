package com.project.educom.Services;

import com.project.educom.Models.Usuario;
import com.project.educom.Repositories.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Usuario> getAllUsers(){
        return loginRepository.findAll();
    }

    public Optional<Usuario> getUserById(Long userid){
        return loginRepository.findById(userid);
    }

    public Usuario addUser(Usuario usuario){
        return loginRepository.save(usuario);
    }

    public void updateUser(Usuario usuario, Long userid){
        Usuario userExists = loginRepository.findById(userid)
                .orElse(new Usuario());
        userExists.setPassword(usuario.getPassword());
        loginRepository.save(userExists);
    }

    public void deleteUserById(Long userid){
        loginRepository.deleteById(userid);
    }

    public Usuario verifyAccount(String email, String password) {

        Optional<Usuario> optionalUser = loginRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            Usuario user = optionalUser.get();
            // Verificar si la contraseña coincide
            if (user.getPassword().equals(password)) {
                // Las credenciales son válidas
                return user;
            }
        }
        // Si no se encontró el usuario o las credenciales no coinciden, devuelve null
        return null;
    }
}
