/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.model;

import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author Jagoba Bartolomé Barroso
 */
public class Convocatoria {
    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private Set<Enunciado> setEnunciados;
    
    public String getConvocatoria() {
        return convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCurso() {
        return curso;
    }

    public Set<Enunciado> getSetEnunciados() {
        return setEnunciados;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSetEnunciados(Set<Enunciado> setEnunciados) {
        this.setEnunciados = setEnunciados;
    }

    public Convocatoria() {
      
    }

    public Convocatoria(String convocatoria, String descripcion, LocalDate fecha, String curso) {
        this.convocatoria = convocatoria;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.curso = curso;
    }
    
}
