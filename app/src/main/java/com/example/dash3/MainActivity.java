package com.example.dash3;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);

       bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               int id = menuItem.getItemId();
               if(id==R.id.nav_home){
                    LoadFrag(new HomeFragment(),true);
               }
               else if(id==R.id.nav_message){
                    LoadFrag(new MessageFragment(), false);
               }
               else{
                    LoadFrag(new SettingFragment(),false);
               }
               return true;
           }
       });
       bnView.setSelectedItemId(R.id.nav_home);
    }
    public void LoadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.container, fragment);
        }
        else{
            ft.replace(R.id.container, fragment);
        }

        ft.commit();

    }
}