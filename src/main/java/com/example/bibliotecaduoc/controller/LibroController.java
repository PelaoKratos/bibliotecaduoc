package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;
    //LO IDEAL ES SIEMPRE EMPEZAR CON EL GET 
    @GetMapping
    public List<Libro> listaLibros() {
        return libroService.readAll();
    }
    
    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        return libro;
    }
    
    //Para buscar solo por id, usa la misma url pero al final se agrega el id que quieres
    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id) {
        return libroService.readbyId(id);
    }

    
}