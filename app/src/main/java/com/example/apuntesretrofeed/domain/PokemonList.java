package com.example.apuntesretrofeed.domain;

public class PokemonList {
    private String nombre;
    private String url;
    public PokemonList(String nombre, String url){
        this.nombre=nombre;
        this.url=url;
    }

    public PokemonList() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
