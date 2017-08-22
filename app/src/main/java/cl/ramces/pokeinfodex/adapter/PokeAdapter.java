package cl.ramces.pokeinfodex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.ramces.pokeinfodex.Models.PokeModel;
import cl.ramces.pokeinfodex.R;

/**
 * Created by sebas on 17-08-2017.
 */

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.ViewHolder> {

    private List<PokeModel> pokeModels = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PokeModel pokemod = pokeModels.get(position);
        TextView textView = (TextView) holder.itemView;
        textView.setText(pokemod.getName());
    }


    @Override
    public int getItemCount() {
        return pokeModels.size();
    }
    public void update(List<PokeModel> pokeModels){
        this.pokeModels.clear();
        this.pokeModels.addAll(pokeModels);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }



}

