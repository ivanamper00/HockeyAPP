package com.ivandeveloper.hockeyapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.ivandeveloper.hockeyapp.View.TeamsDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    public static List<TeamsActiveModel> teamsList;
    TeamsActiveModel team;
    Activity activity;
    public static Context context;

    public static class TeamsViewHolder extends RecyclerView.ViewHolder{

        private TextView teamKey;
        private ImageView teamLogo;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            teamKey = itemView.findViewById(R.id.team_list_key);
            teamLogo = itemView.findViewById(R.id.team_list_logo);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0 ; i < teamsList.size() ; i++) {
                        if(teamKey.getText() == teamsList.get(i).getKey()){
                            Intent intent = new Intent(context, TeamsDetailsActivity.class);
                            intent.putExtra("key", teamsList.get(i).getKey());
                            intent.putExtra("teamName", teamsList.get(i).getName());
                            intent.putExtra("conference", teamsList.get(i).getConference());
                            intent.putExtra("division", teamsList.get(i).getDivision());
                            intent.putExtra("primary", teamsList.get(i).getPrimaryColor());
                            intent.putExtra("secondary", teamsList.get(i).getSecondaryColor());
                            intent.putExtra("tertiary", teamsList.get(i).getTertiaryColor());
                            intent.putExtra("url", teamsList.get(i).getWikipediaLogoUrl());
                            intent.putExtra("city", teamsList.get(i).getCity());
                            context.startActivity(intent);
                            break;
                        }
                    }
                }
            });
        }
    }
    public TeamsAdapter(Context context, List<TeamsActiveModel> teamsList) {
        this.teamsList = teamsList;
        this.context = context;
        this.activity = (Activity) this.context;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_list,parent,false);
        return new TeamsAdapter.TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        team = teamsList.get(position);

        holder.teamKey.setText(team.getKey());

        if(team.getWikipediaLogoUrl().substring(team.getWikipediaLogoUrl().length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with(activity)
                    .load(Uri.parse(team.getWikipediaLogoUrl()), holder.teamLogo);
        }else if(team.getWikipediaLogoUrl().isEmpty()){
            holder.teamLogo.setImageResource(R.drawable.no_image);
        }
        else{
            Picasso.get().load(team.getWikipediaLogoUrl()).into(holder.teamLogo);
        }

    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }
}
