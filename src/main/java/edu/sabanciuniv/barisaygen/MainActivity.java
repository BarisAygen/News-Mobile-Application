package edu.sabanciuniv.barisaygen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    TabItem economicsItem, sportsItem, politicsItem;
    PagerAdeptor pagerAdeptor;

    String api = "9a2961d567494506b3cd83ae628b63f3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Loading loading = new Loading(MainActivity.this);
        loading.StartDialog();
        setContentView(R.layout.activity_main);
        economicsItem = findViewById(R.id.economics);
        sportsItem = findViewById(R.id.sports);
        politicsItem = findViewById(R.id.politics);
        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pagerAdeptor = new PagerAdeptor(getSupportFragmentManager(), 3);
        viewPager.setAdapter(pagerAdeptor);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdeptor.notifyDataSetChanged();
                }
                else if (tab.getPosition() == 1){
                    pagerAdeptor.notifyDataSetChanged();
                }
                else if(tab.getPosition() == 2){
                    pagerAdeptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.DismissDialog();
            }
        }, 1400);

    }
}