package com.example.tabviewandviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ChatsFragment chats;
    StatusFragment status;
    CallsFragment calls;
    StoriesFragment stories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabMode);
        viewPager2 = findViewById(R.id.viewPager);

        chats = new ChatsFragment();
        status = new StatusFragment();
        calls = new CallsFragment();
        stories = new StoriesFragment();

       viewPager2.setAdapter(new MVPAdapter(MainActivity.this));

       new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
           @Override
           public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
               if (position == 0){
                   tab.setText("Chats");
               }
               else if (position == 1){
                   tab.setText("Status");
               } else if (position == 2) {
                   tab.setText("Calls");
               } else{
                   tab.setText("Stories");
               }
           }
       }).attach();

    }
}