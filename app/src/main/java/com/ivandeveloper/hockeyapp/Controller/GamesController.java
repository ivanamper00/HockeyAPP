package com.ivandeveloper.hockeyapp.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.hockeyapp.Adapter.GamesAdapter;
import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.GameModel;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.R;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.MainFragments.GamesFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GamesController extends GamesFragment {
    RecyclerView recyclerView;
    Extras extras;
    Intent intent;
    Context context;
    Activity activity;
    View view;
    boolean isGameOn = false;

    public GamesController(Intent intent,Context context,Activity activity, View view){
        this.view = view;
        this.context = context;
        this.activity = activity;
        this.intent = intent;
        this.recyclerView = view.findViewById(R.id.news_recycler);
        this.extras = new Extras(this.context,this.intent,this.activity);
    }

    public void getCurrentGame() {
        Call<GameModel.CurrentGame> call = extras.NHLRetrofitBuilder().isGameOngoing();

        call.enqueue(new Callback<GameModel.CurrentGame>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<GameModel.CurrentGame> call, retrofit2.Response<GameModel.CurrentGame> response) {

                GameModel.CurrentGame newsModel = response.body();
//                Collections.sort(news, new DateSorter().thenComparing(new DateSorter()));
                setGameOn(newsModel.isGameOngoing());
            }

            @Override
            public void onFailure(Call<GameModel.CurrentGame> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }

    public void getAllGames(String season) {


        Call<List<GameModel>> call = extras.NHLRetrofitBuilder().getGamesPerSeason(season);

        call.enqueue(new Callback<List<GameModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<GameModel>> call, retrofit2.Response<List<GameModel>> response) {

                List<GameModel> gameResponse = response.body();
                List<GameModel> gameModelList = gameResponse;
                List<GameModel> gameList = new ArrayList<>();

                for (int i = 0; i < gameModelList.size(); i++) {
                    gameList.add(new GameModel(
                            gameModelList.get(i).getGameID(),
                            gameModelList.get(i).getSeason(),
                            gameModelList.get(i).getDay(),
                            gameModelList.get(i).getAwayTeam(),
                            gameModelList.get(i).getHomeTeam(),
                            gameModelList.get(i).getAwayTeamID(),
                            gameModelList.get(i).getHomeTeamID(),
                            gameModelList.get(i).getAwayTeamScore(),
                            gameModelList.get(i).getHomeTeamScore()
                    ));
                }


                GamesAdapter adapter = new GamesAdapter(getActivity(), gameList);
                recyclerView.setAdapter(adapter);
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                extras.stopLoading();
            }

            @Override
            public void onFailure(Call<List<GameModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }
    public void startResources() {
        extras.netChecker();
        extras.startLoading();
//        getCurrentGame();
//        if(getIsGameOn()){
        for (int i = 2016; i < getCurrentSeason(); i++) {
            getAllGames(Integer.toString(i));
        }
//    }
    }

    public boolean getIsGameOn() {
        return isGameOn;
    }

    public void setGameOn(boolean gameOn) {
        isGameOn = gameOn;
    }

    public int getCurrentSeason(){
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        String date;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return Integer.parseInt(date);
    }
}