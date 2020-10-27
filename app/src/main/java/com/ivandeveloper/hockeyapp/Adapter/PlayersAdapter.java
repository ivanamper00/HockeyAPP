package com.ivandeveloper.hockeyapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.ivandeveloper.hockeyapp.View.PlayerDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewholder> {
    List<PlayerModel> playerList;
    PlayerModel player;
    public static Context context;

    public static class PlayersViewholder extends RecyclerView.ViewHolder{

        TextView playerName;
        TextView jersey;
        TextView position;
        TextView id;
        TextView teamName;
        TextView playerLogoText;
        ImageView playerLogo;


        public PlayersViewholder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.player_team);
            playerName = itemView.findViewById(R.id.team_details_player_name);
            jersey = itemView.findViewById(R.id.team_details_player_number);
            position = itemView.findViewById(R.id.team_details_player_position);
            playerLogoText = itemView.findViewById(R.id.player_url);
            playerLogo = itemView.findViewById(R.id.team_details_player_image);
            id = itemView.findViewById(R.id.player_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayerDetailsActivity.class);
                    intent.putExtra("teamName", teamName.getText());
                    intent.putExtra("id", id.getText());
                    intent.putExtra("number", jersey.getText());
                    intent.putExtra("playerLogoText", playerLogoText.getText());
                    context.startActivity(intent);
                }
            });
        }
    }
    public PlayersAdapter(Context context, List<PlayerModel> playerList) {
        this.playerList = playerList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayersViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_players_list,parent,false);
        return new PlayersAdapter.PlayersViewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PlayersViewholder holder, int position) {
        player = playerList.get(position);

        holder.id.setText(player.getPlayerID().toString());
        holder.teamName.setText(player.getTeam());
        holder.playerLogoText.setText(player.getPhotoUrl());

        holder.playerName.setText((player.getFirstName() + " " + player.getLastName()).toUpperCase());
        holder.jersey.setText("Jersey Number: " + player.getJersey());
        holder.position.setText("Position: " + positionConverter(player.getPosition()));
        Picasso.get().load(player.getPhotoUrl()).into(holder.playerLogo);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
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
