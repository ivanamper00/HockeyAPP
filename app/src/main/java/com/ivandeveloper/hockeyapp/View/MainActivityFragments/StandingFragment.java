package com.ivandeveloper.hockeyapp.View.MainActivityFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Adapter.GamesAdapter;
import com.ivandeveloper.hockeyapp.Adapter.StandingsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.TeamsAdapter;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.GameModel;
import com.ivandeveloper.hockeyapp.Model.StandingModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandingFragment extends Fragment {
RecyclerView recyclerView;
Extras extras;
    LinearLayoutManager llm;
HashMap<String,String> urls;
List<StandingModel> standingModelData;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StandingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandingFragment newInstance(String param1, String param2) {
        StandingFragment fragment = new StandingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_standing, container, false);
        extras = new Extras(getContext(),getActivity().getIntent(),getActivity());
        extras.netChecker();
        recyclerView = view.findViewById(R.id.standing_recycler);
        llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        urls = new HashMap<>();
        standingModelData = new ArrayList<>();

        extras.startLoading();
        getTeamLogo();

        return view;
    }

    public void addUrl(String key, String value){
        urls.put(key,value);
    }
    public HashMap<String,String> getUrl(){
        return urls;
    }
    public void addStanding(String key, String name, String conference, String division, Integer wins, Integer losses, String teamPicture, int season){
        standingModelData.add(new StandingModel(key, name, conference, division, wins, losses, teamPicture, season));
    }
    public List<StandingModel> getStanding(){
        return standingModelData;
    }

    public void getTeamLogo(){
        Call<List<TeamsActiveModel>> call = extras.NHLRetrofitBuilder().getTeams();

        call.enqueue(new Callback<List<TeamsActiveModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<TeamsActiveModel>> call, retrofit2.Response<List<TeamsActiveModel>> response) {

                List<TeamsActiveModel> teamModel = response.body();
                List<TeamsActiveModel> teamListResponse  = teamModel;
                List<TeamsActiveModel> teams = new ArrayList<>();

                for (int i = 0; i < teamListResponse.size(); i++) {
                    addUrl(teamListResponse.get(i).getKey(),
                            teamListResponse.get(i).getWikipediaLogoUrl());
                }
                getStandings(Integer.toString(extras.getCurrentSeason()));
//
//                System.out.println(getUrl().get("BOS"));
            }

            @Override
            public void onFailure(Call<List<TeamsActiveModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getStandings(String season){

        Call<List<StandingModel>> call = extras.NHLRetrofitBuilder().getStanding(season);

        call.enqueue(new Callback<List<StandingModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<StandingModel>> call, retrofit2.Response<List<StandingModel>> response) {

                List<StandingModel> standingResponse = response.body();
                List<StandingModel> standingList = standingResponse;

                for (int i = 0; i < standingList.size(); i++) {
                    addStanding(
                            standingList.get(i).getKey(),
                            standingList.get(i).getName(),
                            standingList.get(i).getConference(),
                            standingList.get(i).getDivision(),
                            standingList.get(i).getWins(),
                            standingList.get(i).getLosses(),
                            getUrl().get(standingList.get(i).getKey()),
                            standingList.get(i).getSeason());
                }
                List<StandingModel> standingList1 =  getStanding();

                StandingsAdapter adapter = new StandingsAdapter(getActivity(), standingList1);
                recyclerView.setAdapter(adapter);
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + getStanding().get(2).getTeamPicture());
                extras.stopLoading();
            }

            @Override
            public void onFailure(Call<List<StandingModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                extras.stopLoading();
            }
        });
    }
}