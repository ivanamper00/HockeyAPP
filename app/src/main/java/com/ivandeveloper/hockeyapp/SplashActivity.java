package com.ivandeveloper.hockeyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import com.ivandeveloper.hockeyapp.Extras.DataController;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.Model.NewsModel;
import com.ivandeveloper.hockeyapp.View.MainActivity;

import java.util.List;

public class SplashActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    Extras extras;
    DataController dataController;
    TextView textView;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        extras = new Extras(SplashActivity.this, SplashActivity.this.getIntent(), SplashActivity.this);
        dataController = new DataController(SplashActivity.this);
        textView = findViewById(R.id.loading_text);
        dataController.clearSharedPreferences();

//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + dataController.retrieveNewsList(dataController.getNEWS()).get(0).getPlayerPic());
        extras.netChecker();
        if(extras.isConnected()){
            dataController.saveNews();
            dataController.saveActiveTeams();
            dataController.savePlayer();
            dataController.savePlayerFree();
            endSplash();
        }




    }
    //Counter for next intent
    public void endSplash(){
        countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(flag == 0){
                    if(dataChecker()){
                        loop();
                    }else{
                        extras.NextIntent(SplashActivity.this, MainActivity.class);
                        finish();
                    }
                }
            }
        }.start();
    }

    public TextView getTextView() {
        return textView;
    }



    public void loop(){
        endSplash();
    }

    public boolean dataChecker(){
        successChecker();
        errorChecker();
        return (((dataController.retrieveNewsList() == null || dataController.retrievePlayersFreeList() == null)
        || (dataController.retrievePlayersList() == null || dataController.retrieveTeamsList() == null)));

    }

    public void failedToConnect(){

        if(flag < 1){
            flag++;
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SplashActivity.this);
            alertDialog.setCancelable(false);
            alertDialog.setMessage("Failed To Connect, Try To Restart the Application!");
            alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            AlertDialog alert = alertDialog.create();
            alert.show();
        }

    }

    public void errorChecker(){
        if(dataController.getErrors().get(DataController.PLAYERS) != null){
            Toast.makeText(SplashActivity.this, dataController.getErrors().get(DataController.PLAYERS), Toast.LENGTH_SHORT).show();
            if(dataController.getErrors().get(DataController.PLAYERS).toLowerCase().contains("timeout")){
                dataController.savePlayer();
            }else{
                failedToConnect();
            }
        }
        if(dataController.getErrors().get(DataController.TEAM) != null){
            Toast.makeText(SplashActivity.this, dataController.getErrors().get(DataController.TEAM), Toast.LENGTH_SHORT).show();
            if(dataController.getErrors().get(DataController.PLAYERS).toLowerCase().contains("timeout")){
                dataController.saveActiveTeams();
            }else{
                failedToConnect();
            }
        }
        if(dataController.getErrors().get(DataController.PLAYERS_FREE_AGENT) != null){
            Toast.makeText(SplashActivity.this,dataController.getErrors().get(DataController.PLAYERS_FREE_AGENT), Toast.LENGTH_SHORT).show();
            if(dataController.getErrors().get(DataController.PLAYERS).toLowerCase().contains("timeout")){
                dataController.savePlayerFree();
            }else{
                failedToConnect();
            }
        }
        if(dataController.getErrors().get(DataController.NEWS) != null){
            Toast.makeText(SplashActivity.this, dataController.getErrors().get(DataController.NEWS), Toast.LENGTH_SHORT).show();
            if(dataController.getErrors().get(DataController.PLAYERS).toLowerCase().contains("timeout")){
                dataController.saveNews();
            }else{
                failedToConnect();
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void successChecker(){
        if(dataController.getSuccess().get(DataController.PLAYERS) != null){
           getTextView().setText("Loading "+dataController.getSuccess().get(DataController.PLAYERS));
        }
        if(dataController.getSuccess().get(DataController.TEAM) != null){
            getTextView().setText("Loading "+dataController.getSuccess().get(DataController.TEAM));
        }
        if(dataController.getSuccess().get(DataController.PLAYERS_FREE_AGENT) != null){
            getTextView().setText("Loading "+dataController.getSuccess().get(DataController.PLAYERS_FREE_AGENT));
        }
        if(dataController.getSuccess().get(DataController.NEWS) != null){
            getTextView().setText("Loading "+dataController.getSuccess().get(DataController.NEWS));
        }
    }

}