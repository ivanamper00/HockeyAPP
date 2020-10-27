package com.ivandeveloper.hockeyapp.Database;

import com.ivandeveloper.hockeyapp.Model.PlayerStatsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface NHLstatApi {
    String BASE_URL = "https://api.sportsdata.io/v3/nhl/stats/json/";

    @Headers("Ocp-Apim-Subscription-Key: a5a91f4dd2d746619371d6f8bdd17d1c")
    @GET("PlayerSeasonStatsByPlayer/{season}/{playerId}")
    Call<PlayerStatsModel> getPlayerStats(@Path("season") String season, @Path("playerId") String playerId);
}
