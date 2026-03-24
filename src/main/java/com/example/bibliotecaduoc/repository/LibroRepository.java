package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    
    //Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //Metodo que retorno todo los libros
    public List<Libro> obteneLibros(){
        return listaLibros;
    }

    //Buscar un libro por su Id
    public Libro buscaPorId(int id){
        for (Libro libro : listaLibros) {
            if(libro.getId()==id){
                return libro;
            }
        }
        return null;
    }

    //Buscar un libro por isbn
    public Libro buscaPorisbn(String isbn){
        for (Libro libro : listaLibros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    //Guardar libro
    public Libro guardar(Libro book){
        listaLibros.add(book);
        return book;
    }

    //Actualizar libro por id
    public Libro actualizar(Libro book){
        Libro libroBsucado=buscaPorId(book.getId());
        if(libroBsucado!=null){
            libroBsucado.setIsbn(book.getIsbn());
            libroBsucado.setAutor(book.getAutor());
            libroBsucado.setEditorial(book.getEditorial());
            libroBsucado.setFechaPublicacion(book.getFechaPublicacion());
            libroBsucado.setTitulo(book.getTitulo());
            return libroBsucado;
        }
        return null;
    }

    //Eliminar libro
    public void eliminar(int id){
        listaLibros.removeIf(book -> book.getId()==id);
    }
}