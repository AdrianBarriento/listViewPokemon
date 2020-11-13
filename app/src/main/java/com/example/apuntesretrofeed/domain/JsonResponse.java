package com.example.apuntesretrofeed.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    //coge el array del json y lo parsea
    @SerializedName("results")
    @Expose
    public final List<PokemonList> results=null;

}
