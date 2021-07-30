package com.ipartek.formacion.spring.springmvcforms.modelos;

public class Saludo {
    private Long id;
    private String contenido;

    public Saludo(Long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Saludo [contenido=" + contenido + ", id=" + id + "]";
    }
}
