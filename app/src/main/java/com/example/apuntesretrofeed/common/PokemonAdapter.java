package com.example.apuntesretrofeed.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.apuntesretrofeed.R;
import com.example.apuntesretrofeed.domain.PokemonList;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {

    private Context mContext;
    private List<PokemonList> pokemonLists;

    public PokemonAdapter(Context mContext, List<PokemonList> pokemonLists) {
        this.mContext = mContext;
        this.pokemonLists = pokemonLists;
    }

    @Override
    public int getCount() {
        return pokemonLists.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_pokemon, null);
        }
        TextView textView=convertView.findViewById(R.id.txtPokemon);
        textView.setText(pokemonLists.get(position).getNombre());

        return convertView;
    }
}
