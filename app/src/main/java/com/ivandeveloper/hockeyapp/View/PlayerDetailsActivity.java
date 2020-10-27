package com.ivandeveloper.hockeyapp.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Adapter.PlayerDetailsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.PlayersAdapter;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.PlayerStatsModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PlayerDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager llm;
    Extras extras;
    HashMap<String, String> teamPic;
    TeamsActiveModel teamModel;
    String playerId;
    String teamName;
    String playerPic;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        extras = new Extras(PlayerDetailsActivity.this, PlayerDetailsActivity.this.getIntent(), PlayerDetailsActivity.this);
        recyclerView = findViewById(R.id.player_details_recycler);
        getSupportActionBar().setTitle("Player Details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        setPlayerId(getIntent().getExtras().getString("id"));
        setTeamName(getIntent().getExtras().getString("teamName"));
        setPlayerPic(getIntent().getExtras().getString("playerLogoText"));
        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        teamPic = new HashMap<>();
        getTeamPics();

    }
    public String nullable(String string){
        return string == null ? "" : string;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setPlayerPic(String playerPic) {
        this.playerPic = playerPic;
    }

    public String getPlayerPic() {
        return playerPic;
    }

    public String getTeamName() {
        return teamName;
    }

    public HashMap<String, String> getTeamPic() {
        return teamPic;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setTeamPic(String key, String value) {
        this.teamPic.put(key,value);
    }


    public void getTeamPics(){
        extras.startLoading();
        Call<List<TeamsActiveModel>> call = extras.NHLRetrofitBuilder().getTeams();

        call.enqueue(new Callback<List<TeamsActiveModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<TeamsActiveModel>> call, retrofit2.Response<List<TeamsActiveModel>> response) {
                List<TeamsActiveModel> teamsModel = response.body();

                for(int i = 0; i < teamsModel.size(); i++){
                    setTeamPic(teamsModel.get(i).getKey(),teamsModel.get(i).getWikipediaLogoUrl());
                    if(getTeamName().equalsIgnoreCase(teamsModel.get(i).getKey())){
                        setTeamName(teamsModel.get(i).getName());
                    }
                }

                getPlayer(Integer.toString(extras.getCurrentSeason()),getPlayerId());
            }
            @Override
            public void onFailure(Call<List<TeamsActiveModel>> call, Throwable t) {
                Toast.makeText(PlayerDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }


    public void getPlayer(String season, String playerId){

        Call<PlayerStatsModel> call = extras.NHLStatsRetrofitBuilder().getPlayerStats(season,playerId);

        call.enqueue(new Callback<PlayerStatsModel>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<PlayerStatsModel> call, retrofit2.Response<PlayerStatsModel> response) {
                PlayerStatsModel playerModel = response.body();
                PlayerStatsModel newPlayerModel = new PlayerStatsModel(
                        playerModel.getName(),
                        getTeamName(),
                        playerModel.getPosition(),
                        playerModel.getMinutes(),
                        playerModel.getSeconds(),
                        playerModel.getGoals(),
                        playerModel.getAssists(),
                        playerModel.getShotsOnGoal(),
                        playerModel.getPowerPlayGoals(),
                        playerModel.getShortHandedGoals(),
                        playerModel.getEmptyNetGoals(),
                        playerModel.getPowerPlayAssists(),
                        playerModel.getShortHandedAssists(),
                        playerModel.getHatTricks(),
                        playerModel.getShootoutGoals(),
                        playerModel.getPlusMinus(),
                        playerModel.getPenaltyMinutes(),
                        playerModel.getBlocks(),
                        playerModel.getHits(),
                        playerModel.getTakeaways(),
                        playerModel.getGiveaways(),
                        playerModel.getFaceoffsWon(),
                        playerModel.getFaceoffsLost(),
                        playerModel.getGoaltendingMinutes(),
                        playerModel.getGoaltendingSeconds(),
                        playerModel.getGoaltendingShotsAgainst(),
                        playerModel.getGoaltendingGoalsAgainst(),
                        playerModel.getGoaltendingSaves(),
                        playerModel.getGoaltendingWins(),
                        playerModel.getGoaltendingLosses(),
                        playerModel.getGoaltendingShutouts(),
                        playerModel.getStarted(),
                        playerModel.getBenchPenaltyMinutes(),
                        getPlayerPic(),
                        getTeamPic().get(playerModel.getTeam()));

                PlayerDetailsAdapter adapter = new PlayerDetailsAdapter(PlayerDetailsActivity.this, newPlayerModel, getIntent().getExtras().getString("number"));
                recyclerView.setAdapter(adapter);
                extras.stopLoading();
            }
            @Override
            public void onFailure(Call<PlayerStatsModel> call, Throwable t) {
                Toast.makeText(PlayerDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }

}