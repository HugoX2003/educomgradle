package com.project.educom.Services;

import com.project.educom.Models.Categoria;
import com.project.educom.Repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    //GPT
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> encontrarCategoria(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    //FIN
}
