package com.ivandeveloper.hockeyapp.Adapter;

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
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsDetailsAdapter extends RecyclerView.Adapter<TeamsDetailsAdapter.TeamsViewHolder> {
    List<TeamsActiveModel> teamsList;
    TeamsActiveModel team;
    Context context;
    public static class TeamsViewHolder extends RecyclerView.ViewHolder{

        private TextView teamId;
        private ImageView teamLogo;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            teamId = itemView.findViewById(R.id.team_list_key);
            teamLogo = itemView.findViewById(R.id.team_list_logo);
        }
    }
    public TeamsDetailsAdapter(Context context, List<TeamsActiveModel> teamsList) {
        this.teamsList = teamsList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_list,parent,false);
        return new TeamsDetailsAdapter.TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        team = teamsList.get(position);

        holder.teamId.setText(team.getKey());

        if(team.getWikipediaLogoUrl().substring(team.getWikipediaLogoUrl().length()-3).contains("svg")){
            SvgLoader.pluck()
                    .with((Activity) context)
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
