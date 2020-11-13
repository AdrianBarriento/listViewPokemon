package com.example.apuntesretrofeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.apuntesretrofeed.common.PokemonAdapter;
import com.example.apuntesretrofeed.domain.JsonResponse;
import com.example.apuntesretrofeed.domain.PokemonList;
import com.example.apuntesretrofeed.iface.ApiPokemon;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.apuntesretrofeed.common.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getName();
    private List<PokemonList> mPokemon;
    private ListView listView =null;
    PokemonAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllPokemon();
        listView = findViewById(R.id.listView);

    }



    public void getAllPokemon(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiPokemon apiPokemon = retrofit.create(ApiPokemon.class);

        apiPokemon.getListPokemon().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response!=null && response.body() != null){
                    mPokemon = response.body().results;
                    for (PokemonList p : mPokemon) {
                        Log.d(TAG, "pokemon:   "+p.getNombre());
                        Log.d(TAG, p.getUrl());
                    }

                    adapter=new PokemonAdapter(MainActivity.this, mPokemon);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }
}