
package com.mycompany.model;

import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class LibroPrestado extends Libro{
    private LocalDate fechaEmision;
    private LocalDate fechaDevolución;

    
    public LibroPrestado(String codigo, String titulo, String autor, int cantidadDisponible) {
        super(codigo, titulo, autor, cantidadDisponible);
        this.fechaEmision = LocalDate.now();
        this.fechaDevolución = LocalDate.now().plusDays(30);
    }
    
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaDevolución() {
        return fechaDevolución;
    }


}
