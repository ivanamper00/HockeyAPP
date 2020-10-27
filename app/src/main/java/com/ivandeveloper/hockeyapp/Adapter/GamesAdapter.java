package com.ivandeveloper.hockeyapp.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.hockeyapp.Model.GameModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

 List<GameModel> gameList;
 GameModel game;

    public static class GamesViewHolder extends RecyclerView.ViewHolder {
        public TextView scores;
        public TextView date;
        public TextView gameId;
        public TextView teamHome;
        public TextView teamAway;
//        public ImageView picHome;
//        public ImageView picAway;

        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
            gameId = itemView.findViewById(R.id.game_id);
            teamHome = itemView.findViewById(R.id.home_team_name);
            teamAway = itemView.findViewById(R.id.away_team_name);
            date = itemView.findViewById(R.id.game_date);
            scores = itemView.findViewById(R.id.scores);
//            picHome = itemView.findViewById(R.id.team_one_image);
//            picAway = itemView.findViewById(R.id.team_two_image);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//                @Override
//                public void onClick(View v) {
//                    MinorController minorController = new MinorController();
//                    minorController.NextIntent(v.getContext(), FullGameDetailsActivity.class, gameId.getText().toString());
//                }
//            });
        }
    }

    public GamesAdapter(Context context, List<GameModel> gameList) {
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public GamesAdapter.GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_list,parent,false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesAdapter.GamesViewHolder holder, int position) {
        game = gameList.get(position);
        holder.gameId.setText(game.getGameID());
        holder.teamHome.setText(game.getHomeTeam());
        holder.teamAway.setText(game.getAwayTeam());
        holder.date.setText(game.getDay().substring(0,9));
        holder.scores.setText(game.getHomeTeamScore() + " - " + game.getAwayTeamScore());
//        Picasso.get().load().into(holder.picHome);
//        Picasso.get().load(gameID.getTeams().getAway().getLogo()).into(holder.picAway);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
