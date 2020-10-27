package com.ivandeveloper.hockeyapp.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.PlayersAdapter;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class TeamsDetailsActivity extends AppCompatActivity {
    Extras extras;
    RecyclerView recyclerView;
    TextView teamName;
    TextView conference;
    TextView city;
    TextView division;
    TextView playerTag;
    ImageView teamLogo;
    LinearLayoutManager llm;
    CardView cardView;
    String primary;
    String secondary;
    String tertiary;
    String key;
    String teamNameText;
    String conferenceText;
    String cityText;
    String divisionText;
    String url;



    @SuppressLint({"RestrictedApi", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_details);

        key = getIntent().getExtras().getString("key");
        teamNameText = getIntent().getExtras().getString("teamName");
        conferenceText = getIntent().getExtras().getString("conference");
        cityText = getIntent().getExtras().getString("city");
        divisionText = getIntent().getExtras().getString("division");
        url = getIntent().getExtras().getString("url");
        primary = getIntent().getExtras().getString("primary");
        secondary = getIntent().getExtras().getString("secondary");
        tertiary= getIntent().getExtras().getString("tertiary");

        primary = primary.isEmpty()? "414753" : primary;
        secondary = secondary.isEmpty()? "414753" : secondary;
        tertiary = tertiary.isEmpty()? "414753" : tertiary;

        extras = new Extras(TeamsDetailsActivity.this,TeamsDetailsActivity.this.getIntent(), TeamsDetailsActivity.this);
        cardView = findViewById(R.id.teams_card_view);
        playerTag = findViewById(R.id.players_tag);
        playerTag.setTextColor(Color.parseColor(("#"+secondary)));
        teamName = findViewById(R.id.team_details_name);
        teamName.setTextColor(Color.parseColor(("#"+secondary)));
        conference = findViewById(R.id.team_details_conference);
        conference.setTextColor(Color.parseColor(("#"+secondary)));
        city = findViewById(R.id.team_details_city);
        city.setTextColor(Color.parseColor(("#"+secondary)));
        division = findViewById(R.id.team_details_division);
        division.setTextColor(Color.parseColor(("#"+secondary)));
        recyclerView = findViewById(R.id.player_team_list);
        teamLogo = findViewById(R.id.team_details_logo);
        recyclerView.setBackgroundColor(Color.parseColor(("#"+primary)));
        cardView.setBackgroundColor(Color.parseColor(("#"+tertiary)));
        llm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(llm);
        teamName.setText(teamNameText);
        conference.setText("Conference: "+conferenceText);
        city.setText("City: "+cityText);
        division.setText("Division: "+divisionText);
        if(url.substring(url.length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with(this)
                    .load(Uri.parse(url), teamLogo);
        }else if(url.isEmpty()){
            teamLogo.setImageResource(R.drawable.no_image);
        }
        else{
            Picasso.get().load(url).into(teamLogo);
        }


        getTeamPlayers(key);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void getTeamPlayers(String key){
        extras.netChecker();
        extras.startLoading();
        Call<List<PlayerModel>> call = extras.NHLRetrofitBuilder().getTeamPlayers(key);

        call.enqueue(new Callback<List<PlayerModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<PlayerModel>> call, retrofit2.Response<List<PlayerModel>> response) {

                List<PlayerModel> teamPlayerList = response.body();
                List<PlayerModel> teamPlayersList = teamPlayerList;
                List<PlayerModel> teamPlayers = new ArrayList<>();

                for (int i = 0; i < teamPlayersList.size(); i++) {
                    teamPlayers.add(new PlayerModel(teamPlayersList.get(i).getPlayerID(),
                            teamPlayersList.get(i).getFirstName(),
                            teamPlayersList.get(i).getLastName(),
                            teamPlayersList.get(i).getTeam(),
                            teamPlayersList.get(i).getPosition(),
                            teamPlayersList.get(i).getJersey(),
                            teamPlayersList.get(i).getPhotoUrl()));

                }

                PlayersAdapter adapter = new PlayersAdapter(TeamsDetailsActivity.this, teamPlayers);
                recyclerView.setAdapter(adapter);
                extras.stopLoading();
            }

            @Override
            public void onFailure(Call<List<PlayerModel>> call, Throwable t) {
                Toast.makeText(TeamsDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }
}