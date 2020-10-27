package com.ivandeveloper.hockeyapp.Extras;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;

import androidx.appcompat.app.AlertDialog;

import com.ivandeveloper.hockeyapp.Database.NHLapi;
import com.ivandeveloper.hockeyapp.Database.NHLstatApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Extras {

    ProgressDialog pdLoading;
    Context context;
    Intent intent;
    Activity activity;
    CountDownTimer countDownTimer;

    public Extras(Context context,Intent intent,Activity activity){
        this.pdLoading = new ProgressDialog(context);
        this.context = context;
        this.intent = intent;
        this.activity = activity;
    }

    //Next Intent w/ Data Function
    public void NextIntent(Class toClass, String data) {
        Intent intent = new Intent(context, toClass);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }
    //Next Intent w/o Data Function
    public void NextIntent(Context context, Class toClass) {
        NextIntent(toClass, "");
    }

    //Retrofit Builder Function
    public NHLapi NHLRetrofitBuilder() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NHLapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NHLapi api = retrofit.create(NHLapi.class);
        return api;
    }
    public NHLstatApi NHLStatsRetrofitBuilder() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NHLstatApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NHLstatApi api = retrofit.create(NHLstatApi.class);
        return api;
    }

    // Loading Function
    public void startLoading(String text){
        pdLoading.setMessage("\t" + text);
        pdLoading.setCancelable(false);
        pdLoading.show();
    }
    public void startLoading(){
        startLoading("Please Wait...");
    }


    // Loading Function
    public void stopLoading(){
        pdLoading.dismiss();
    }

    public void checkingConnection(){
        startLoading("Checking Connection...");
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (isConnected()){
                    stopLoading();
                }
            }

            @Override
            public void onFinish() {
                stopLoading();
                netChecker();
            }
        }.start();
    }

    //Connection Checker Function
    public boolean isConnected() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else {
            connected = false;
        }
        return connected;
    }

    public void netChecker(){
        if(!isConnected()){
            noInternetDialog();
        }
    }

    public void noInternetDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setCancelable(false);
        alertDialog.setMessage("\tDisconnected to Network");
        alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishIntent();
            }
        });
        alertDialog.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                checkingConnection();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    public Intent getIntent() {
        return intent;
    }

    public void NextIntent(Context context, Class toClass, String data) {
        Intent intent = new Intent(context, toClass);
        intent.putExtra("data", data);
        context.startActivity(intent);
    }

    @SuppressLint("SimpleDateFormat")
    public int getCurrentSeason(){
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        String date;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return Integer.parseInt(date);
    }


    public void finishIntent(){
        activity.finish();
    }
}
