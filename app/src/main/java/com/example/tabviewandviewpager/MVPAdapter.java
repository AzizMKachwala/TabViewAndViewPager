package com.example.tabviewandviewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MVPAdapter extends FragmentStateAdapter {

    public MVPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            case 3:
                return new StoriesFragment();
            case 0:
            default:
                return new ChatsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
