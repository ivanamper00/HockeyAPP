package com.ivandeveloper.hockeyapp.View.MainActivityFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Adapter.PlayersAdapter;
import com.ivandeveloper.hockeyapp.Extras.DataController;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayersFragment extends Fragment {
RecyclerView recyclerViewPlayers;
RecyclerView recyclerViewSearch;
LinearLayoutManager llm;
LinearLayoutManager llm1;
Extras extras;
List<PlayerModel> allPlayers;
List<PlayerModel> searchPlayer;
SearchView searchView;
DataController dataController;
CardView cardView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayersFragment newInstance(String param1, String param2) {
        PlayersFragment fragment = new PlayersFragment();
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
        final View view = inflater.inflate(R.layout.fragment_players, container, false);
        dataController = new DataController(getContext());
        extras = new Extras(getContext(),getActivity().getIntent(),getActivity());
        searchView = view.findViewById(R.id.search_player);
        cardView = view.findViewById(R.id.no_search_result);
        recyclerViewPlayers = view.findViewById(R.id.players_list_recycler);
        llm = new LinearLayoutManager(getContext());
        recyclerViewPlayers.setLayoutManager(llm);
        recyclerViewSearch = view.findViewById(R.id.players_search_recycler);
        llm1 = new LinearLayoutManager(getContext());
        recyclerViewSearch.setLayoutManager(llm1);
        searchPlayer = new ArrayList<>();
        allPlayers = new ArrayList<>();
        getPlayerPic();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    if(cardView.getVisibility() != cardView.GONE){
                        cardView.setVisibility(cardView.GONE);
                    }
                    if(recyclerViewPlayers.getVisibility() != recyclerViewPlayers.VISIBLE){
                        recyclerViewPlayers.setVisibility(recyclerViewPlayers.VISIBLE);
                    }
                    if(recyclerViewSearch.getVisibility() != recyclerViewSearch.GONE){
                        recyclerViewSearch.setVisibility(recyclerViewSearch.GONE);
                    }
                }else{
                    search(newText);

                }
                return false;
            }
        });
        return view;
    }
    public void search(String query){
        cleanSearch();
        for(int i = 0; i < getAllPlayers().size(); i++){
            if(getAllPlayers().get(i).getFirstName().concat(" " + getAllPlayers().get(i).getLastName()).toLowerCase().contains(query.toLowerCase())){
                System.out.println("");
                setSearchData(getAllPlayers().get(i).getPlayerID(),
                        getAllPlayers().get(i).getFirstName(),
                        getAllPlayers().get(i).getLastName(),
                        getAllPlayers().get(i).getTeam(),
                        getAllPlayers().get(i).getPosition(),
                        getAllPlayers().get(i).getJersey(),
                        getAllPlayers().get(i).getPhotoUrl());
            }
        }
        if(getSearchPlayer().size() != 0){
            recyclerViewPlayers.setVisibility(View.GONE);
            cardView.setVisibility(View.GONE);
            if(recyclerViewSearch.getVisibility() != View.VISIBLE){
                recyclerViewSearch.setVisibility(View.VISIBLE);
            }
            PlayersAdapter adapter = new PlayersAdapter(getActivity(), getSearchPlayer());
            recyclerViewSearch.setAdapter(adapter);
        }
        else{
            recyclerViewSearch.setVisibility(View.GONE);
            recyclerViewPlayers.setVisibility(View.GONE);
            cardView.setVisibility(View.VISIBLE);
        }
    }

    public void cleanSearch(){
        searchPlayer.clear();
    }
    public void setSearchData(Integer playerID, String firstName, String lastName, String team, String position, Integer jersey, String photoUrl){
        searchPlayer.add(new PlayerModel( playerID,  firstName,  lastName,  team,  position,  jersey,  photoUrl));
    }
    public void setPlayer(Integer playerID, String firstName, String lastName, String team, String position, Integer jersey, String photoUrl){
        allPlayers.add(new PlayerModel( playerID,  firstName,  lastName,  team,  position,  jersey,  photoUrl));
    }

    public List<PlayerModel> getSearchPlayer() {
        return searchPlayer;
    }

    public List<PlayerModel> getAllPlayers() {
        return allPlayers;
    }

    public void getPlayerPic(){

                List<PlayerModel> playerModel = dataController.retrievePlayersList();
                for (int i = 0; i < playerModel.size(); i++) {
                    setPlayer(
                            playerModel.get(i).getPlayerID(),
                            playerModel.get(i).getFirstName(),
                            playerModel.get(i).getLastName(),
                            playerModel.get(i).getTeam(),
                            playerModel.get(i).getPosition(),
                            playerModel.get(i).getJersey(),
                            playerModel.get(i).getPhotoUrl());
                }

                PlayersAdapter adapter = new PlayersAdapter(getActivity(), getAllPlayers());
                recyclerViewPlayers.setAdapter(adapter);
                extras.stopLoading();
    }
}