package com.example.apuntesretrofeed.iface;

import com.example.apuntesretrofeed.domain.JsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static com.example.apuntesretrofeed.common.Constants.POKEMON_FORM;

public interface ApiPokemon {
    //para decir que tipo de archivo va a traer la api (normalmente un JSON)  //para obtener recursos (GET POR QUE ES UN GETTER)
    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(POKEMON_FORM)//en estos parametros se añadiria el parametro  --("/{name}")
            //creamos un metodo que coge los datos del api ya pasados a json
    Call <JsonResponse> getListPokemon(/*@Query/Path("name") String name -----query para pasar parametro path para pasar path*/);
}
