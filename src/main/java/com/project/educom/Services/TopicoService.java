package com.project.educom.Services;

//Modelo Topico importado, aún no es utilizado
import com.project.educom.Models.Topico;
import com.project.educom.Repositories.TopicoRepository;
import org.springframework.stereotype.Service;

// import java.util.List;       Aún no utilizado
// import java.util.Optional;   Aún no utilizado

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Topico addTopico(Topico topico) {
        return topicoRepository.save(topico);
    }
}
