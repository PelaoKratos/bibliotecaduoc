package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;






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
    public Libro getLibroId(@PathVariable int id) {
        return libroService.readbyId(id);
    }

    //Obtener un libro por ISBN
    @GetMapping("isbn/{isbn}")
    public Libro getLibroByIsbn(@PathVariable String isbn) {
        return libroService.readbyIsbn(isbn);
    }

    //ENTREGAR LA LIBRERIA DE LIBROS
    @GetMapping("seed")
    public String getSeed() {
        libroService.datosFake();
        return "Datos cargados";
    }

    //Actualizar un libro por id
    @PutMapping("{id}")
    public Libro putLibro(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(id,libro);
    }

    @DeleteMapping("eliminar/{id}")
    public String deleteLibro(@PathVariable int id) {
        if(libroService.deleteLibro(id)){
            return "Libro Eliminado";
        }
        return "No fue posible eliminar el libro";
    }
}