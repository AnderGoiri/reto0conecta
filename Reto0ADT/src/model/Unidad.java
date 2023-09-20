/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ander Goirigolzarri Iturburu 
 */
public class Unidad {
    private int id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;

    public int getId() {
        return id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Unidad(int id, String acronimo, String titulo, String evaluacion, String descripcion) {
        this.id = id;
        this.acronimo = acronimo;
        this.titulo = titulo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }
 
}
