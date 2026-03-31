package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    
    //Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    public void cargarLibrosFake(){
        listaLibros= new ArrayList<>(Arrays.asList(
        new Libro(1, "978-84-376-0494-7", "Cien años de soledad", "Editorial Sudamericana", 1967, "Gabriel García Márquez"),
        new Libro(2, "978-0-7432-7356-5", "El código Da Vinci", "Doubleday", 2003, "Dan Brown"),
        new Libro(3, "978-84-204-6725-2", "Don Quijote de la Mancha", "Francisco de Robles", 1605, "Miguel de Cervantes"),
        new Libro(4, "978-0-452-28423-4", "1984", "Secker & Warburg", 1949, "George Orwell"),
        new Libro(5, "978-84-670-5190-9", "La sombra del viento", "Planeta", 2001, "Carlos Ruiz Zafón")
        ));
    }

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

    public Libro modificarLibro(int id, Libro libro) {
        Libro libroDestino=buscaPorId(id);
        if(libroDestino!=null){
            libroDestino.setIsbn(libro.getIsbn());
            libroDestino.setAutor(libro.getAutor());
            libroDestino.setEditorial(libro.getEditorial());
            libroDestino.setFechaPublicacion(libro.getFechaPublicacion());
            libroDestino.setTitulo(libro.getTitulo());
            return libroDestino;
        }
        return null;
    }

    public boolean eliminarLibro(int id){
        listaLibros.removeIf(b-> b.getId()==id);
        return true;
    }

    public List<Libro> getMayores(int year) {
        List<Libro> mayores=new ArrayList<>();
        for (Libro libro : listaLibros) {
            if(libro.getFechaPublicacion()>=year){
                mayores.add(libro);
            }
        }
        return mayores;
    }
}