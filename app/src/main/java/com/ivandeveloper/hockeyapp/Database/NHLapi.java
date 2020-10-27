package com.ivandeveloper.hockeyapp.Database;

import com.ivandeveloper.hockeyapp.Model.GameModel;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.PlayerStatsModel;
import com.ivandeveloper.hockeyapp.Model.StandingModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface NHLapi {


    String BASE_URL = "https://api.sportsdata.io/v3/nhl/scores/json/";



    //WITHOUT PARAMETERS
        //NHL Updates
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("News")
    Call<List<NewsModel>> getNews();

        //Teams Active
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("teams")
    Call<List<TeamsActiveModel>> getTeams();

        //All Teams
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("AllTeams")
    Call<List<TeamsActiveModel>> getAllTeams();

        //Current Game
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("AreAnyGamesInProgress")
    Call<GameModel.CurrentGame> isGameOngoing();

        //Active Players
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("Players")
    Call<List<PlayerModel>> getPlayersActive();

        //Free Agents
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("FreeAgents")
    Call<List<PlayerModel>> getPlayersFreeAgent();

    //WITH PARAMETERS
        //Games
    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("Games/{season}")
    Call<List<GameModel>> getGamesPerSeason(@Path("season") String season);

    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("Players/{team}")
    Call<List<PlayerModel>> getTeamPlayers(@Path("team") String team);

    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("Standings/{season}")
    Call<List<StandingModel>> getStanding(@Path("season") String season);

    @Headers("Ocp-Apim-Subscription-Key: 9ef2a0de885d44b2bda4adfed2d4b906")
    @GET("Players/{playerid}")
    Call<List<PlayerModel>> getPlayerDetails(@Path("playerid") String team);

}
