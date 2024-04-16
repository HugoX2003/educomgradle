package com.project.educom.Repositories;

import com.project.educom.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
