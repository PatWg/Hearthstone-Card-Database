package fr.isep.ii3510.hearthstonecarddatabase.service;

import java.util.List;

import fr.isep.ii3510.hearthstonecarddatabase.model.Card;
import fr.isep.ii3510.hearthstonecarddatabase.model.QueryResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HearthstoneService {
    String URL = "https://boiling-shelf-89461.herokuapp.com/";


    @GET("cards/")
    Call<List<Card>> getCards();

    @Headers("Content-type: application/json;charset=utf-8")
    @POST("cards/")
    Call<QueryResponse> getCards(@Body QueryParam queryParam);
}
