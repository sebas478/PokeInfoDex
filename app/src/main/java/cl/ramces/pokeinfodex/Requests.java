package cl.ramces.pokeinfodex;

import cl.ramces.pokeinfodex.Models.PokeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sebas on 10-08-2017.
 */

public interface Requests {
    @GET("pokemon")
    Call<PokeWraper> getPokemon(@Query("limit") int limit);

    @GET("pokemon")
    Call<PokeModel> getName(@Query("name")String name);

}
