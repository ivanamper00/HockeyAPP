package com.ivandeveloper.hockeyapp.View.MainActivityFragments.MainFragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Adapter.NewsAdapter;
import com.ivandeveloper.hockeyapp.Extras.DataController;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.Model.PlayerModel;
import com.ivandeveloper.hockeyapp.Model.TeamsActiveModel;
import com.ivandeveloper.hockeyapp.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    RecyclerView recyclerView;
    Extras extras;
    List<NewsModel> newNewsModel;
    HashMap<Integer, String> playerPic;
    HashMap<Integer, String> playerTeamPic;
    DataController dataController;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.sample1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4, R.drawable.sample5};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        dataController = new DataController(getContext());
        extras = new Extras(getContext(),getActivity().getIntent(),getActivity());
        recyclerView = view.findViewById(R.id.news_recycler);
        carouselView = view.findViewById(R.id.carousel_hockey);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(llm);
        extras.netChecker();
        playerTeamPic = new HashMap<>();
        playerPic = new HashMap<>();
        newNewsModel = new ArrayList<>();



//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaatanginatanginataninataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        getPlayerPic();
        return view;

    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void setPlayer(Integer key, String value){
        playerPic.put(key,value);
    }
    public HashMap<Integer,String> getPlayer(){
       return playerPic;
    }
    public void setPlayerTeamPic(Integer key, String value){
        playerTeamPic.put(key,value);
    }
    public HashMap<Integer,String> getPlayerTeamPic(){
        return playerTeamPic;
    }
    public void setNewNewsModel(int newsID, int playerID, int teamID, String team, String title, String content, String url, String source, String termsOfUse, String updated, String playerPic, String playerTeamPic){
        newNewsModel.add(new NewsModel(newsID,  playerID,  teamID,  team,  title,  content,  url,  source,  termsOfUse,  updated,  playerPic,  playerTeamPic));
    }
    public List<NewsModel> getNewNewsModel(){
        return newNewsModel;
    }


    public void getPlayerPic(){
                List<PlayerModel> playerModel = dataController.retrievePlayersList();
                    for (int i = 0; i < playerModel.size(); i++) {
                        setPlayer(playerModel.get(i).getPlayerID(), playerModel.get(i).getPhotoUrl());
                    }
                getPlayerPic2();
    }
    public void getPlayerPic2(){
                List<PlayerModel> playerModel = dataController.retrievePlayersFreeList();
                    for (int i = 0; i < playerModel.size(); i++) {
                        setPlayer(playerModel.get(i).getPlayerID(),playerModel.get(i).getPhotoUrl());
                }
                getTeamPicture();

    }

    public void getTeamPicture(){
                List<TeamsActiveModel> playerModel = dataController.retrieveTeamsList();
                for (int i = 0; i < playerModel.size(); i++) {
                    setPlayerTeamPic(playerModel.get(i).getTeamID(),playerModel.get(i).getWikipediaLogoUrl());
                }
                getNews();

    }
    public void getNews() {
        List<NewsModel> newsModel = dataController.retrieveNewsList();

        for (int i = 0; i < newsModel.size(); i++) {
            setNewNewsModel(
                    newsModel.get(i).getNewsID(),
                    newsModel.get(i).getPlayerID(),
                    newsModel.get(i).getTeamID(),
                    newsModel.get(i).getTeam(),
                    newsModel.get(i).getTitle(),
                    newsModel.get(i).getContent(),
                    newsModel.get(i).getUrl(),
                    newsModel.get(i).getSource(),
                    newsModel.get(i).getTermsOfUse(),
                    newsModel.get(i).getUpdated(),
                    getPlayer().get(newsModel.get(i).getPlayerID()),
                    getPlayerTeamPic().get(newsModel.get(i).getTeamID()));
        }
        List<NewsModel> news = getNewNewsModel();
        NewsAdapter adapter = new NewsAdapter(getActivity(), news);
        recyclerView.setAdapter(adapter);
    }
}