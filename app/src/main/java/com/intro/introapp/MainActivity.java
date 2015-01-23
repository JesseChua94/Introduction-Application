package com.intro.introapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import static com.intro.introapp.R.layout.activity_main;


public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));


    }

}

class MyAdapter extends FragmentPagerAdapter
{
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FirstScreen();
        }
        if (position == 1) {
            fragment = new SecondScreen();
        }
        if (position == 2) {
            fragment = new LogInScreen();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
