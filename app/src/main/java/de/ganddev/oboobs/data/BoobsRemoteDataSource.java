package de.ganddev.oboobs.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

public interface BoobsRemoteDataSource {

    String ENDPOINT = "http://api.oboobs.ru";

    @GET("/boobs/get/{id}")
    Call<Boobs> getBoobById(@Path("id") int id);

    @GET("/noise/{number_od_elements}")
    Call<List<Boobs>> getRandomBoobs(@Path("number_od_elements") int count);

    @GET("/boobs/model/{name}")
    Call<List<Boobs>> getBoobsByModel(@Path("name") String name);

    @GET("/boobs/author/{name}")
    Call<List<Boobs>> getBoobsByAuthor(@Path("name") String name);

    @POST("/noise/vote/{id}/minus")
    Call<Boobs> rateNoiseNegativ(@Path("id") int id);

    @POST("/noise/vote/{id}/minus")
    Call<Boobs> rateNoisePositiv(@Path("id") int id);
}
