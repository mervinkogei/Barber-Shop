
package com.example.barbershop.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BarberStylistResponse {

    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BarberStylistResponse() {
    }

    /**
     * 
     * @param hits
     */
    public BarberStylistResponse(List<Hit> hits) {
        super();
        this.hits = hits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
