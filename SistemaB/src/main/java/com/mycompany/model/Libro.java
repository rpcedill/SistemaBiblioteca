
package com.mycompany.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author USER
 */
public class Libro implements Serializable{
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Libro(String codigo) {
        this.codigo = codigo;
    }

    public Libro(String codigo, String titulo, String autor, int cantidadDisponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    public void reservar(){
        cantidadDisponible--;
        
    }
    public void aumentarTomos(int a){
        cantidadDisponible+=a;
    }
    
    public static ArrayList<Libro> cargarDatos(){
        ArrayList<Libro> lista = new ArrayList<>();
        try(ObjectInputStream ob = new ObjectInputStream(new FileInputStream("src/main/resources/com/mycompany/sistemab/libros.ser"))){
            lista = (ArrayList<Libro>) ob.readObject();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public static void guardarDatos(ArrayList<Libro> lista){
        try(ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/mycompany/sistemab/libros.ser"))){
            ob.writeObject(lista);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + '}';
    }
    
    
}
