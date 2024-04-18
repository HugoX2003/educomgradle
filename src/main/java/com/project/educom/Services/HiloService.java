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
        return hiloRepository.save(hilo);
    }

    public Optional<Hilo> encontrarHilo(Long id) {
        return hiloRepository.findById(id);
    }

    public void eliminarHilo(Long id) {
        hiloRepository.deleteById(id);
    }

    public Hilo guardarCambios(Hilo hilo) {
        return hiloRepository.save(hilo);
    }

}
