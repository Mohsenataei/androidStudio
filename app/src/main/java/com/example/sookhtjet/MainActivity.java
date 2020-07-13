package com.example.sookhtjet;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerMain;


    private String[] imageUrls = {
            "https://jahanebehtar.com/wp-content/uploads/2017/11/the-law-of-attraction-storent-1.jpg",
            "https://cdn.tabnak.ir/files/fa/news/1399/1/16/1156650_383.jpg",
            "https://relaxsomeone.com/wp-content/uploads/2018/09/%D9%82%D8%A7%D9%86%D9%88%D9%86-%D8%AC%D8%B0%D8%A8-7-1.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSH6J12x-FOs1a1Y7UVWsC5YjrtVsml7YteBw&usqp=CAU",
            "https://www.go-rich.net/wp-content/uploads/2016/12/%D8%AC%D8%B0%D8%A8-%D8%A7%D9%84%D9%85%D8%A7%D9%84-758x426.png"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPagerMain = (ViewPager) findViewById(R.id.viewPagerMain);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(),imageUrls);
        viewPagerMain.setAdapter(adapter);
    }


}