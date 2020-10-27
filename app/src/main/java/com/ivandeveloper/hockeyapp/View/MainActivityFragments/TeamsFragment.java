package com.ivandeveloper.hockeyapp.View.MainActivityFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Adapter.TeamsAdapter;
import com.ivandeveloper.hockeyapp.Controller.TeamsController;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamsFragment extends Fragment {
    RecyclerView recyclerView;
    GridLayoutManager grid;
    TeamsController teamsController;
    Extras extras;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TeamsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamsFragment newInstance(String param1, String param2) {
        TeamsFragment fragment = new TeamsFragment();
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
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        teamsController = new TeamsController(getActivity().getIntent(),getContext(),getActivity(),view);
        extras = new Extras(getContext(),getActivity().getIntent(),getActivity());
        recyclerView = view.findViewById(R.id.teams_recycler);
        grid = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(grid);
        getActiveTeams();
        return view;
    }
    public void getActiveTeams() {
        extras.netChecker();
        Call<List<TeamsActiveModel>> call = extras.NHLRetrofitBuilder().getTeams();

        call.enqueue(new Callback<List<TeamsActiveModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<TeamsActiveModel>> call, retrofit2.Response<List<TeamsActiveModel>> response) {

                List<TeamsActiveModel> teamModel = response.body();
                List<TeamsActiveModel> teamListResponse  = teamModel;
                List<TeamsActiveModel> teams = new ArrayList<>();

                for (int i = 0; i < teamListResponse.size(); i++) {
                    teams.add(new TeamsActiveModel(
                            teamListResponse.get(i).getKey(),
                            teamListResponse.get(i).getName(),
                            teamListResponse.get(i).getConference(),
                            teamListResponse.get(i).getDivision(),
                            teamListResponse.get(i).getPrimaryColor(),
                            teamListResponse.get(i).getSecondaryColor(),
                            teamListResponse.get(i).getTertiaryColor(),
                            teamListResponse.get(i).getWikipediaLogoUrl(),
                            teamListResponse.get(i).getCity()
                    ));
                }
                TeamsAdapter adapter = new TeamsAdapter(getContext(), teams);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TeamsActiveModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}