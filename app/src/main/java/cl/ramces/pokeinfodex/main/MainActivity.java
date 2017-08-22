package cl.ramces.pokeinfodex.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import cl.ramces.pokeinfodex.adapter.PokeAdapter;
import cl.ramces.pokeinfodex.network.GetPokemon;
import cl.ramces.pokeinfodex.Models.PokeModel;
import cl.ramces.pokeinfodex.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.pokemonsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new PokeAdapter();
        recyclerView.setAdapter(adapter);


        new GetFirstGen().execute();
    }

    private class GetFirstGen extends GetPokemon {

        @Override
        protected void onPostExecute(List<PokeModel> pokeModels) {
            if (pokeModels != null) {
                adapter.update(pokeModels);
            }
        }
    }

}
