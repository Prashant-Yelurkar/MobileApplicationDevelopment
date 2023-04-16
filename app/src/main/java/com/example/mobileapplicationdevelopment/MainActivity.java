package com.example.mobileapplicationdevelopment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.mobileapplicationdevelopment.component.elements.All_Element;
import com.example.mobileapplicationdevelopment.component.elements.ArchitectureDiagram;
import com.example.mobileapplicationdevelopment.component.elements.Life_Cycle;
import com.example.mobileapplicationdevelopment.component.layouts.All_Layout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout  drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView loader = findViewById(R.id.main);
        Glide.with(this).load(R.drawable.mobile_application_development).into(loader);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView =findViewById(R.id.navigation);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_open,R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId())
                {
                    case R.id.home:
                        intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    break;
                    case R.id.layouts:
                        intent = new Intent(MainActivity.this, All_Layout.class);
                        startActivity(intent);
                        break;
                    case R.id.elements:
                        intent = new Intent(MainActivity.this, All_Element.class);
                        startActivity(intent);
                        break;
                    case R.id.architecture:
                        intent = new Intent(MainActivity.this, ArchitectureDiagram.class);
                        startActivity(intent);
                        break;
                    case R.id.lifecycle:
                    intent = new Intent(MainActivity.this, Life_Cycle.class);
                    startActivity(intent);
                    break;
                }
                return true;
            }
        });

    }

}