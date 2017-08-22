package cl.ramces.pokeinfodex;

import cl.ramces.pokeinfodex.Models.PokeModel;

/**
 * Created by sebas on 10-08-2017.
 */

public class PokeWraper {
    private int count;
    private PokeModel[] results;

    public PokeWraper(PokeModel[] results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PokeModel[] getResults() {
        return results;
    }

    public void setResults(PokeModel[] results) {
        this.results = results;
    }
}
