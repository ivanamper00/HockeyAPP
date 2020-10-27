package com.ivandeveloper.hockeyapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.PlayerStatsModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerDetailsAdapter extends RecyclerView.Adapter<PlayerDetailsAdapter.PlayerDetailsViewHolder> {

    PlayerStatsModel playerStats;
    Context context;
    Activity activity;
    String jersey;
    public static class PlayerDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView team;
        TextView position;
        TextView minutes;
        TextView seconds;
        TextView goals;
        TextView assists;
        TextView shotsOnGoal;
        TextView powerPlayGoals;
        TextView shortHandedGoals;
        TextView emptyNetGoals;
        TextView powerPlayAssists;
        TextView shortHandedAssists;
        TextView hatTricks;
        TextView shootoutGoals;
        TextView plusMinus;
        TextView penaltyMinutes;
        TextView blocks;
        TextView hits;
        TextView takeaways;
        TextView giveaways;
        TextView faceoffsWon;
        TextView faceoffsLost;
        TextView goaltendingMinutes;
        TextView goaltendingSeconds;
        TextView goaltendingShotsAgainst;
        TextView goaltendingGoalsAgainst;
        TextView goaltendingSaves;
        TextView goaltendingWins;
        TextView goaltendingLosses;
        TextView goaltendingShutouts;
        TextView started;
        TextView benchPenaltyMinutes;
        ImageView playerPic;
        ImageView playerTeamPic;
        TextView jerseyNumber;

        public PlayerDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.player_details_name_season);
            team = itemView.findViewById(R.id.player_details_team_name);
            position = itemView.findViewById(R.id.player_details_position);
            minutes = itemView.findViewById(R.id.player_details_min);
            seconds = itemView.findViewById(R.id.player_details_sec);
            goals = itemView.findViewById(R.id.player_details_goals);
            assists = itemView.findViewById(R.id.player_details_assist);
            shotsOnGoal = itemView.findViewById(R.id.player_details_sog);
            powerPlayGoals = itemView.findViewById(R.id.player_details_ppgoals);
            shortHandedGoals = itemView.findViewById(R.id.player_details_shgoals);
            emptyNetGoals = itemView.findViewById(R.id.player_details_engoals);
            powerPlayAssists = itemView.findViewById(R.id.player_details_ppassist);
            shortHandedAssists = itemView.findViewById(R.id.player_details_shassist);
            hatTricks = itemView.findViewById(R.id.player_details_hattricks);
            shootoutGoals = itemView.findViewById(R.id.player_details_sogoals);
            plusMinus = itemView.findViewById(R.id.player_details_plus_minus);
            penaltyMinutes = itemView.findViewById(R.id.player_details_pminutes);
            blocks = itemView.findViewById(R.id.player_details_blocks);
            hits = itemView.findViewById(R.id.player_details_hits);
            takeaways = itemView.findViewById(R.id.player_details_take_away);
            giveaways = itemView.findViewById(R.id.player_details_give_away);
            faceoffsWon = itemView.findViewById(R.id.player_details_fo_won);
            faceoffsLost = itemView.findViewById(R.id.player_details_fo_lost);
            goaltendingMinutes = itemView.findViewById(R.id.player_details_gmin);
            goaltendingSeconds = itemView.findViewById(R.id.player_details_gsec);
            goaltendingShotsAgainst = itemView.findViewById(R.id.player_details_shot_against);
            goaltendingGoalsAgainst = itemView.findViewById(R.id.player_details_goal_against);
            goaltendingWins = itemView.findViewById(R.id.player_details_gwins);
            goaltendingLosses = itemView.findViewById(R.id.player_details_glosses);
            goaltendingShutouts = itemView.findViewById(R.id.player_details_shutouts);
            started = itemView.findViewById(R.id.player_details_started);
            benchPenaltyMinutes = itemView.findViewById(R.id.player_details_bpm);
            playerPic = itemView.findViewById(R.id.player_details_picture);
            playerTeamPic = itemView.findViewById(R.id.player_details_team_logo);
            jerseyNumber = itemView.findViewById(R.id.player_details_number);
        }
    }
    public PlayerDetailsAdapter(Context context, PlayerStatsModel playerStats, String jersey) {
        this.playerStats = playerStats;
        this.context = context;
        this.activity = (Activity) this.context;
        this.jersey = jersey;
    }
    @NonNull
    @Override
    public PlayerDetailsAdapter.PlayerDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_full_list,parent,false);
        return new PlayerDetailsViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PlayerDetailsAdapter.PlayerDetailsViewHolder holder, int position) {

        holder.name.setText(nullable(playerStats.getName().toUpperCase()));
        holder.team.setText(nullable(playerStats.getTeam()));
        holder.position.setText("Position: "+ positionConverter(nullable(playerStats.getPosition())));
//        holder.updated.setText(nullable(playerStats.getUpdated()));
//        holder.games.setText(nullable(playerStats.getGames()).toString());
        holder.minutes.setText(nullable(playerStats.getMinutes()).toString());
        holder.seconds.setText(nullable(playerStats.getSeconds()).toString());
        holder.goals.setText(nullable(playerStats.getGoals().toString()));
        holder.assists.setText(nullable(playerStats.getAssists().toString()));
//        holder.shotsOnGoal.setText(playerStats.getShotsOnGoal().toString());
        holder.powerPlayGoals.setText(nullable(playerStats.getPowerPlayGoals().toString()));
        holder.shortHandedGoals.setText(nullable(Double.toString(playerStats.getShortHandedGoals())));
        holder.emptyNetGoals.setText(nullable(playerStats.getEmptyNetGoals().toString()));
        holder.powerPlayAssists.setText(nullable(playerStats.getPowerPlayAssists().toString()));
        holder.shortHandedAssists.setText(nullable(playerStats.getShortHandedAssists().toString()));
        holder.hatTricks.setText(nullable(playerStats.getHatTricks().toString()));
        holder.shootoutGoals.setText(nullable(playerStats.getShootoutGoals().toString()));
        holder.plusMinus.setText(nullable(playerStats.getPlusMinus().toString()));
        holder.penaltyMinutes.setText(nullable(playerStats.getPenaltyMinutes().toString()));
        holder.blocks.setText(nullable(playerStats.getBlocks().toString()));
        holder.hits.setText(nullable(playerStats.getHits().toString()));
        holder.takeaways.setText(nullable(playerStats.getTakeaways().toString()));
        holder.giveaways.setText(nullable(playerStats.getGiveaways().toString()));
        holder.faceoffsWon.setText(nullable(playerStats.getFaceoffsWon().toString()));
        holder.faceoffsLost.setText(nullable(playerStats.getFaceoffsLost().toString()));
        holder.goaltendingMinutes.setText(nullable(playerStats.getGoaltendingMinutes()).toString());
        holder.goaltendingSeconds.setText(nullable(playerStats.getGoaltendingSeconds()).toString());
        holder.goaltendingShotsAgainst.setText(nullable(playerStats.getGoaltendingShotsAgainst().toString()));
        holder.goaltendingGoalsAgainst.setText(nullable(playerStats.getGoaltendingGoalsAgainst().toString()));
        holder.goaltendingWins.setText(nullable(playerStats.getGoaltendingWins().toString()));
        holder.goaltendingLosses.setText(nullable(playerStats.getGoaltendingLosses().toString()));
        holder.goaltendingShutouts.setText(nullable(playerStats.getGoaltendingShutouts().toString()));
        holder.started.setText(nullable(playerStats.getStarted()).toString());
        holder.benchPenaltyMinutes.setText(nullable(playerStats.getBenchPenaltyMinutes()));
        holder.jerseyNumber.setText(this.jersey);

        if(playerStats.getPlayerPic().substring(playerStats.getPlayerPic().length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with(activity)
                    .load(Uri.parse(playerStats.getPlayerPic()), holder.playerPic);
        }else{
            Picasso.get().load(playerStats.getPlayerPic()).into(holder.playerPic);
        }

        if(playerStats.getPlayerTeamPic().substring(playerStats.getPlayerTeamPic().length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with(activity)
                    .load(Uri.parse(playerStats.getPlayerTeamPic()), holder.playerTeamPic);
        }else{
            Picasso.get().load(playerStats.getPlayerTeamPic()).into(holder.playerTeamPic);
        }
    }

    public Integer nullable(Integer object){
        object = (object == null) ? 0 : object;
        return object;
    }
    public String nullable(String object){
        object = (object == null) ?  "0" : object;
        return object;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public String positionConverter(String position){
        String newPosition = position;
        switch (position){
            case "G":
                newPosition = "Goalie";
                break;
            case "D":
                newPosition =  "Defenseman";
                break;
            case "C":
                newPosition =  "Center";
                break;
            case "RW":
                newPosition =  "Right Wing";
                break;
            case "LW":
                newPosition =  "Left Wing";
                break;
            default:
                newPosition = "Undefined";
                break;
        }
        return newPosition;
    }

}
