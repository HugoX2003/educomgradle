package com.project.educom.Repositories;

import com.project.educom.Models.Hilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiloRepository extends JpaRepository<Hilo, Long> {
    
}
