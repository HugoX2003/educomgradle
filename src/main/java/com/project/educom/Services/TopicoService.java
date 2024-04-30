package com.project.educom.Services;

//Modelo Topico importado, aún no es utilizado
import com.project.educom.Models.Topico;
import com.project.educom.Repositories.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> encontrarTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico actualizarTopico(Topico topico) {
        // Asegura que el tópico ya exista antes de intentar actualizarlo
        if (topico.getId() != null && topicoRepository.existsById(topico.getId())) {
            return topicoRepository.save(topico);
        }
        throw new IllegalArgumentException("Topico no existente");
    }

    public void eliminarTopico(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Topico no existente");
        }
    }

    public Topico addTopico(Topico topico) {
        return topicoRepository.save(topico);
    }
}
