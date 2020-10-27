package com.ivandeveloper.hockeyapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ivandeveloper.hockeyapp.Extras.DataController;
import com.ivandeveloper.hockeyapp.Extras.Extras;
import com.ivandeveloper.hockeyapp.R;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.MainFragment;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.PlayersFragment;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.StandingFragment;
import com.ivandeveloper.hockeyapp.View.MainActivityFragments.TeamsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Extras extras;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    DataController dataController;
    public static int counterFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataController = new DataController(MainActivity.this);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + dataController.retrieveNewsList().get(0).getContent());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterFlag = 0;
        extras = new Extras(MainActivity.this, MainActivity.this.getIntent(), MainActivity.this);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Goaltender");
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout,toolbar,(R.string.Open),(R.string.Close));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        switch(counterFlag) {
            case 0:
                counterFlag ++;
            break;
            case 1:
                counterFlag ++;
                Toast.makeText(MainActivity.this, "Press Back Again to Exit.", Toast.LENGTH_SHORT).show();
            break;
            default:
                finish();
            break;
        }
    }
//    public void goHomeFragment(){
//        extras.netChecker();
//        getSupportActionBar().setTitle("Hockey");
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout, new MainFragment());
//        fragmentTransaction.commit();
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.teams_button:
                counterFlag = 0;
                extras.netChecker();
                getSupportActionBar().setTitle("NHL Teams");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new TeamsFragment());
                fragmentTransaction.commit();
                break;
            case R.id.home_button:
                counterFlag = 0;
                finish();
                startActivity(getIntent());
                break;
            case R.id.standing_button:
                counterFlag = 0;
                extras.netChecker();
                getSupportActionBar().setTitle("Standings");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new StandingFragment());
                fragmentTransaction.commit();
                break;
            case R.id.player_button:
                counterFlag = 0;
                extras.netChecker();
                getSupportActionBar().setTitle("Players");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new PlayersFragment());
                fragmentTransaction.commit();
                break;
        }
        return true;
    }
}