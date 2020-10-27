package com.ivandeveloper.hockeyapp.Extras;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.PlayerDetailsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.PlayersAdapter;
import com.ivandeveloper.hockeyapp.Adapter.TeamsAdapter;
import com.ivandeveloper.hockeyapp.Database.NHLapi;
import com.ivandeveloper.hockeyapp.Database.NHLstatApi;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.PlayerStatsModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.View.PlayerDetailsActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class DataController {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PLAYERS = "Players";
    public static final String PLAYERS_FREE_AGENT = "Players_free_agent";
    public static final String TEAM = "teams";
    public static final String STANDING = "standings";
    public static final String NEWS = "news";
    Context context;
    Activity activity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    HashMap<String,String>errors;
    HashMap<String,String>success;

    @SuppressLint("CommitPrefEdits")
    public DataController(Context context) {
        this.context = context;
        this.activity = (Activity) context;
        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        errors = new HashMap<>();
        success = new HashMap<>();
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public SharedPreferences getCurrentSharedPreferences() {
        return sharedPreferences;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(String key, String value) {
        this.errors.put(key,value);
    }

    public HashMap<String, String> getSuccess() {
        return success;
    }

    public void setSuccess(String key, String value) {
        this.success.put(key,value);
    }

    public <T> void saveData(String calling, List<T> object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        getEditor().putString(calling ,json);
        getEditor().commit();
    }

    public <T> void saveData(String calling, T object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        getEditor().putString(calling ,json);
        getEditor().commit();
    }

    public List<NewsModel> retrieveNewsList(){
        Gson gson = new Gson();
        String json = getCurrentSharedPreferences().getString(NEWS,"");
        Type type = new TypeToken<List<NewsModel>>(){}.getType();
        List<NewsModel> objects = gson.fromJson(json, type);
        return objects;
    }

    public List<TeamsActiveModel> retrieveTeamsList(){
        Gson gson = new Gson();
        String json = getCurrentSharedPreferences().getString(TEAM,"");
        Type type = new TypeToken<List<TeamsActiveModel>>(){}.getType();
        List<TeamsActiveModel> objects = gson.fromJson(json, type);
        return objects;
    }

    public List<PlayerModel> retrievePlayersList(){
        Gson gson = new Gson();
        String json = getCurrentSharedPreferences().getString(PLAYERS,"");
        Type type = new TypeToken<List<PlayerModel>>(){}.getType();
        List<PlayerModel> objects = gson.fromJson(json, type);
        return objects;
    }

    public List<PlayerModel> retrievePlayersFreeList(){
        Gson gson = new Gson();
        String json = getCurrentSharedPreferences().getString(PLAYERS_FREE_AGENT,"");
        Type type = new TypeToken<List<PlayerModel>>(){}.getType();
        List<PlayerModel> objects = gson.fromJson(json, type);
        return objects;
    }


    public void savePlayer(){

        Call<List<PlayerModel>> call = NHLRetrofitBuilder().getPlayersActive();

        call.enqueue(new Callback<List<PlayerModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<PlayerModel>> call, retrofit2.Response<List<PlayerModel>> response) {
                List<PlayerModel> playerModel = response.body();
                saveData(PLAYERS, playerModel);

                setSuccess(PLAYERS,"Players..");

            }
            @Override
            public void onFailure(Call<List<PlayerModel>> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                setErrors(PLAYERS,t.getMessage());
            }
        });
    }

    public void savePlayerFree(){

        Call<List<PlayerModel>> call = NHLRetrofitBuilder().getPlayersFreeAgent();

        call.enqueue(new Callback<List<PlayerModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<PlayerModel>> call, retrofit2.Response<List<PlayerModel>> response) {
                List<PlayerModel> playerModel = response.body();
                saveData(PLAYERS_FREE_AGENT, playerModel);
                setSuccess(PLAYERS_FREE_AGENT,"Players..");
            }
            @Override
            public void onFailure(Call<List<PlayerModel>> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                setErrors(PLAYERS_FREE_AGENT,t.getMessage());
            }
        });
    }

    public void saveActiveTeams() {
        Call<List<TeamsActiveModel>> call = NHLRetrofitBuilder().getTeams();

        call.enqueue(new Callback<List<TeamsActiveModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<TeamsActiveModel>> call, retrofit2.Response<List<TeamsActiveModel>> response) {

                List<TeamsActiveModel> teamModel = response.body();
                saveData(TEAM, teamModel);

                setSuccess(TEAM,"Teams..");
            }
            @Override
            public void onFailure(Call<List<TeamsActiveModel>> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                setErrors(TEAM,t.getMessage());
            }
        });
    }

    public void clearSharedPreferences(){
        getEditor().clear();
        getEditor().commit();
    }




    public void saveNews() {
        Call<List<NewsModel>> call = NHLRetrofitBuilder().getNews();

        call.enqueue(new Callback<List<NewsModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<NewsModel>> call, retrofit2.Response<List<NewsModel>> response) {
                List<NewsModel> newsModel = response.body();
                saveData(NEWS, newsModel);
                setSuccess(TEAM,"News..");
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                setErrors(NEWS,t.getMessage());
            }
        });
    }

    public NHLapi NHLRetrofitBuilder() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NHLapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NHLapi api = retrofit.create(NHLapi.class);
        return api;
    }
    public NHLstatApi NHLStatsRetrofitBuilder() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NHLstatApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NHLstatApi api = retrofit.create(NHLstatApi.class);
        return api;
    }
}


