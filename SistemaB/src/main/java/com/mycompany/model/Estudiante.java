
package com.mycompany.model;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Estudiante extends Usuario {
    private ArrayList<LibroPrestado> librosP;
    
    
    public Estudiante(String usuario, String password) {
        super(usuario, password);
        librosP = new ArrayList<>();
    }
    
    public void addLibro(LibroPrestado lb){
        librosP.add(lb);
    }

    public ArrayList<LibroPrestado> getLibrosP() {
        return librosP;
    }
       
      
    
    
    
}
