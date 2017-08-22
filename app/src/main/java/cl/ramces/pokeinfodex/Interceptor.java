package cl.ramces.pokeinfodex;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sebas on 10-08-2017.
 */

public class Interceptor {
    public static final String BASE_URL = "http://pokeapi.co/api/v2/";

    public Requests theMostBasicInterceptor() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Requests someRequest = interceptor.create(Requests.class);
        return someRequest;
    }
}
