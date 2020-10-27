package com.ivandeveloper.hockeyapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<NewsModel> news;
    NewsModel newsModelID;
    Activity activity;
    int newsID;
    Context context;
    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView updated;
        private TextView content;
        private TextView source;
        private ImageView teamPic;
        private ImageView playerPic;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            updated = itemView.findViewById(R.id.news_updated);
            content = itemView.findViewById(R.id.news_content);
            source = itemView.findViewById(R.id.news_source);
            teamPic = itemView.findViewById(R.id.news_team);
            playerPic = itemView.findViewById(R.id.news_player);
        }
    }
    public NewsAdapter(Context context, List<NewsModel> news) {
        this.news = news;
        this.context = context;
        this.activity = (Activity) this.context;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list,parent,false);
        return new NewsViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        newsModelID = news.get(position);
        holder.title.setText(newsModelID.getTitle());
        holder.updated.setText(dateConverter(newsModelID.getUpdated()));
        holder.content.setText(newsModelID.getContent());
        holder.source.setText(newsModelID.getSource());

        String teamPicHolder = newsModelID.getPlayerTeamPic();
        String playerPic = newsModelID.getPlayerPic();
        if(playerPic != null) {
            if (playerPic.contains("/0.png")) {
                playerPic = null;
            }
        }
        if(playerPic != null) {
            if(newsModelID.getPlayerPic().substring(newsModelID.getPlayerPic().length()-3).contains("svg")){
                SvgLoader.pluck()
                        .with(activity)
                        .load(Uri.parse(newsModelID.getPlayerPic()), holder.playerPic);
            }else{
                Picasso.get().load(newsModelID.getPlayerPic()).into(holder.playerPic);
            }
        }

        if(teamPicHolder != null){
            if(newsModelID.getPlayerTeamPic().substring(newsModelID.getPlayerTeamPic().length()-3).contains("svg")){
                SvgLoader.pluck()
                        .with(activity)
                        .load(Uri.parse(newsModelID.getPlayerTeamPic()), holder.teamPic);
            }else{
                Picasso.get().load(newsModelID.getPlayerTeamPic()).into(holder.teamPic);
            }
        }


//        if(playerPic == null && teamPicHolder == null){
//            Picasso.get().load(R.drawable.nhl).into(holder.teamPic);
//        }else{
//            if(playerPic == null){
//                holder.playerPic.setVisibility(View.GONE);
//                if(newsModelID.getPlayerTeamPic().substring(newsModelID.getPlayerTeamPic().length()-3).contains("svg")){
//                    GlideToVectorYou.justLoadImage((Activity) context, Uri.parse(newsModelID.getPlayerTeamPic()),holder.teamPic);
//                }else{
//                    Picasso.get().load(newsModelID.getPlayerTeamPic()).into(holder.teamPic);
//                }
//
//            }else if(teamPicHolder == null){
//                holder.teamPic.setVisibility(View.GONE);
//                holder.playerPic.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
//                if(newsModelID.getPlayerPic().substring(newsModelID.getPlayerPic().length()-3).contains("svg")){
//                    GlideToVectorYou.justLoadImage((Activity) context, Uri.parse(newsModelID.getPlayerPic()),holder.playerPic);
//                }else{
//                    Picasso.get().load(newsModelID.getPlayerPic()).into(holder.playerPic);
//                }
//            }else{
//
//
//            }
//        }

        this.newsID = newsModelID.getNewsID();
    }

    public String dateConverter(String date){
        String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String newDate = "";
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + date.substring(5,7));
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + date.substring(8,9));
        int monthNumber = Integer.parseInt(date.substring(5,7));
        String dayNumber = date.substring(8,10);

        newDate = month[monthNumber] + " " + dayNumber + " " + date.substring(0,4);

        return newDate;
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
