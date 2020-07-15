package com.example.sookhtjet;

import android.graphics.Matrix;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.transition.Slide;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    //***********************************************//
    private RecyclerView StoryRecyclerView;
    private StoryItemAdapter adapter;
    private ArrayList<StoryItem> storyItems = new ArrayList<>();
    //**********************************************//
    private RecyclerView TrainingCourseRecyclerView;
    private TrainingCourseAdapter CourseAdapter;
    private ArrayList<TrainingCourseItem> courseItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//////////////////****************************Auto Scroll view pager****************/////////////////
        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerMain2);
        //here we are preparing list of images from drawable.
        //you can get it from api as well.
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.a));
        sliderItems.add(new SliderItem(R.drawable.b));
        sliderItems.add(new SliderItem(R.drawable.c));
        sliderItems.add(new SliderItem(R.drawable.d));
        sliderItems.add(new SliderItem(R.drawable.e));


        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });


////////////***************************story setion*****************************//////////////////////////


        storyItems.add(new StoryItem(R.drawable.a));
        storyItems.add(new StoryItem(R.drawable.b));
        storyItems.add(new StoryItem(R.drawable.c));
        storyItems.add(new StoryItem(R.drawable.d));
        storyItems.add(new StoryItem(R.drawable.e));
        storyItems.add(new StoryItem(R.drawable.a));
        storyItems.add(new StoryItem(R.drawable.b));
        storyItems.add(new StoryItem(R.drawable.c));
        storyItems.add(new StoryItem(R.drawable.d));
        storyItems.add(new StoryItem(R.drawable.e));

        StoryRecyclerView = (RecyclerView) findViewById(R.id.StoryRecyclerView);
        StoryRecyclerView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        adapter = new StoryItemAdapter(storyItems, MainActivity.this);
        LinearLayoutManager linearLayoutManagerStoryItems = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        StoryRecyclerView.setLayoutManager(linearLayoutManagerStoryItems);
        StoryRecyclerView.setAdapter(adapter);



       //****************************************trainingCourse/////////**********************///////////
        courseItemList.add(new TrainingCourseItem(R.drawable.a,"قدرت نهفته",240));
        courseItemList.add(new TrainingCourseItem(R.drawable.b,"قدرت نهفته",240));
        courseItemList.add(new TrainingCourseItem(R.drawable.c,"قدرت نهفته",240));

        TrainingCourseRecyclerView = (RecyclerView)findViewById(R.id.CourseRecyclerView);
        TrainingCourseRecyclerView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        CourseAdapter = new TrainingCourseAdapter(courseItemList,MainActivity.this);
        LinearLayoutManager linearLayoutManagerCourseItems = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        TrainingCourseRecyclerView.setLayoutManager(linearLayoutManagerCourseItems);
        TrainingCourseRecyclerView.setAdapter(CourseAdapter);


        ///////////**********************************************************************////////////////////////////////
        //وقتی اسلاید میکنیم عکس هارا یه حالت بالا پایین داره عکس ها.یعنی اونی که میخوایم ببینیم بالاتر قرار میگیره و بقیه اسلاید ها پایین تر
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1- Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
//            }
//        });
//        viewPager2.setPageTransformer(compositePageTransformer);

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

        }
    };


    //این دوتا تابع برای اینه که وقتی برنامه رو استوپ کردیم و دوباره ادامه دادیم بازم کار کنه.
    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }
}