package cl.ramces.pokeinfodex.network;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ramces.pokeinfodex.Interceptor;
import cl.ramces.pokeinfodex.Models.PokeModel;
import cl.ramces.pokeinfodex.PokeWraper;
import cl.ramces.pokeinfodex.Requests;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by sebas on 10-08-2017.
 */

public class GetPokemon extends AsyncTask<Void , Void , List<PokeModel>> {

    @Override
    protected List<PokeModel> doInBackground(Void... params) {
        Requests requests = new Interceptor().theMostBasicInterceptor();
        Call<PokeWraper> call = requests.getPokemon(151);
        try {
            Response<PokeWraper> response = call.execute();
            if (200 == response.code()&& response.isSuccessful()){
                List<PokeModel> pokeModels = new ArrayList<>();
                for (PokeModel pokeModel : response.body().getResults()) {
                    pokeModels.add(pokeModel);
                }
                return pokeModels;
            }else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
