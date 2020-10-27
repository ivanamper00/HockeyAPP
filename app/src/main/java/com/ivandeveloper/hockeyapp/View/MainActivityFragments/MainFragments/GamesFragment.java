package com.ivandeveloper.hockeyapp.View.MainActivityFragments.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ivandeveloper.hockeyapp.Controller.GamesController;
import com.ivandeveloper.hockeyapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesFragment extends Fragment {
    RecyclerView recyclerView;
    GamesController gamesController;
    WebView webView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GamesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GamesFragment newInstance(String param1, String param2) {
        GamesFragment fragment = new GamesFragment();
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
        View view = inflater.inflate(R.layout.fragment_games, container, false);
//        recyclerView = view.findViewById(R.id.games_recycler);
//        gamesController = new GamesController(getActivity().getIntent(),getContext(),getActivity(),view);
//        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
//        recyclerView.setLayoutManager(llm);
////        gamesController.startResources();

        webView = view.findViewById(R.id.web_view);
//        webView.setScrollY(200);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.nhl.com/video/vegas-goes-gold-music-video/t-277350912/c-5420293");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {

//                view.loadUrl("javascript:getValue()");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('video--logobar ')[0].style.display='none';" +
                        "document.getElementsByClassName('section-banner section-banner--dark')[0].style.display='none';" +
                        "document.getElementsByClassName('site-footer')[0].style.display='none';" + "})()" );
            }
        });

//
        return view;

    }
}