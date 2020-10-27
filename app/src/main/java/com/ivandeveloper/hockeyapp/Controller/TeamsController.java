package com.ivandeveloper.hockeyapp.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.TeamsAdapter;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.TeamsFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class TeamsController extends TeamsFragment {
    RecyclerView recyclerView;
    Extras extras;
    Intent intent;
    Context context;
    Activity activity;
    View view;

    public TeamsController(Intent intent,Context context,Activity activity, View view){
        this.view = view;
        this.context = context;
        this.activity = activity;
        this.intent = intent;
        this.recyclerView = view.findViewById(R.id.teams_recycler);
        this.extras = new Extras(this.context,this.intent,this.activity);

    }

//    public void getActiveTeams() {
//    extras.netChecker();
//
//        Call<List<TeamsActiveModel>> call = extras.NHLRetrofitBuilder().getTeams();
//
//        call.enqueue(new Callback<List<TeamsActiveModel>>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<List<TeamsActiveModel>> call, retrofit2.Response<List<TeamsActiveModel>> response) {
//
//                List<TeamsActiveModel> teamModel = response.body();
//                List<TeamsActiveModel> teamListResponse  = teamModel;
//                List<TeamsActiveModel> teams = new ArrayList<>();
//
//                for (int i = 0; i < teamListResponse.size(); i++) {
//                    teams.add(new TeamsActiveModel(
//                            teamListResponse.get(i).getTeamID(),
//                            teamListResponse.get(i).getWikipediaLogoUrl()
//                    ));
//                }
////                Collections.sort(news, new DateSorter().thenComparing(new DateSorter()));
//
//                TeamsAdapter adapter = new TeamsAdapter(getContext(), teams);
//                recyclerView.setAdapter(adapter);
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//
//            }
//
//            @Override
//            public void onFailure(Call<List<TeamsActiveModel>> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}
