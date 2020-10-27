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
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.StandingModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder> {

    List<StandingModel> standingsList;
    StandingModel standings;
    Context context;
    Activity activity;
    public static class StandingsViewHolder extends RecyclerView.ViewHolder{
         TextView teamName;
         TextView conference;
         TextView division;
         TextView wins;
         TextView losses;
         ImageView url;

        public StandingsViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.standing_team_name);
            conference = itemView.findViewById(R.id.standing_conference);
            division = itemView.findViewById(R.id.standing_division);
            wins = itemView.findViewById(R.id.standing_wins);
            losses = itemView.findViewById(R.id.standing_loss);
            url = itemView.findViewById(R.id.standing_team_logo);
        }
    }
    public StandingsAdapter(Context context, List<StandingModel> standingsList) {
        this.standingsList = standingsList;
        this.context = context;
        this.activity = (Activity) this.context;
    }


    @NonNull
    @Override
    public StandingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standing_list,parent,false);
        return new StandingsAdapter.StandingsViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StandingsViewHolder holder, int position) {
        standings = standingsList.get(position);
        holder.teamName.setText(standings.getName() +" '"+standings.getSeason().toString());
        holder.conference.setText(standings.getConference());
        holder.division.setText(standings.getDivision());
        holder.wins.setText(standings.getWins().toString());
        holder.losses.setText(standings.getLosses().toString());
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa + " + standings.getTeamPicture());
        if(standings.getTeamPicture().substring(standings.getTeamPicture().length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with(activity)
                    .load(Uri.parse(standings.getTeamPicture()), holder.url);
        }else if(standings.getTeamPicture().isEmpty()){
            holder.url.setImageResource(R.drawable.no_image);
        }
        else{
            Picasso.get().load(standings.getTeamPicture()).into(holder.url);
        }
    }

    @Override
    public int getItemCount() {
        return standingsList.size();
    }
}
