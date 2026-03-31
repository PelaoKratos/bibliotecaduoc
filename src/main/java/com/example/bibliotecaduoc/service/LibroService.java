package com.example.bibliotecaduoc.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> readAll (){
        return libroRepository.obteneLibros();
    }

    public Libro save(Libro book){
        return libroRepository.guardar(book);
    }

    public Libro update(Libro book){
        return libroRepository.actualizar(book);
    }

    public void delete(int id){
        libroRepository.eliminar(id);
    }

    public Libro readbyId(int id){
        return libroRepository.buscaPorId(id);
    }

    public Libro readbyIsbn(String isbn){
        return libroRepository.buscaPorisbn(isbn);
    }

    public List<String> obtenerTodosIsbn(){
        List<String> isbns = new ArrayList<>();
        for (Libro libro : libroRepository.obteneLibros()) {
            isbns.add(libro.getIsbn());
        }
        return isbns;
    }

    public void datosFake(){
        libroRepository.cargarLibrosFake();
    }


}
