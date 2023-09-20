/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0adt.model;

/**
 *
 * @author 2dam
 */
public class Enunciado {
    private int id;
    private String descripcion;
    private Dificultad nivel;
    private boolean disponible;
    private String ruta;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Dificultad getNivel() {
        return nivel;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNivel(Dificultad nivel) {
        this.nivel = nivel;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Enunciado(int id, String descripcion, Dificultad nivel, boolean disponible, String ruta) {
        this.id = id;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.disponible = disponible;
        this.ruta = ruta;
    }
    
}
