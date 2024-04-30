package com.project.educom.Services;

import com.project.educom.Models.Hilo;
import com.project.educom.Repositories.HiloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HiloService {

    private final HiloRepository hiloRepository;

    public HiloService(HiloRepository hiloRepository) {
        this.hiloRepository = hiloRepository;
    }

    public List<Hilo> listarHilo() {
        return hiloRepository.findAll();
    }

    public Hilo guardarHilo(Hilo hilo) {
        if (hilo.getId() != null) {
            throw new IllegalArgumentException("El hilo nuevo no debe tener un ID");
        }
        return hiloRepository.save(hilo);
    }

    public Optional<Hilo> encontrarHilo(Long id) {
        return hiloRepository.findById(id);
    }

    public void eliminarHilo(Long id) {
        hiloRepository.deleteById(id);
    }

    public Hilo guardarCambios(Hilo hilo) {
        if (hilo.getId() == null || !hiloRepository.existsById(hilo.getId())) {
            throw new IllegalArgumentException("El hilo debe existir para poder actualizarlo");
        }
        return hiloRepository.save(hilo);
    }

}
