package com.example.king.dsjweek03;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.king.dsjweek03.fragment.DanFragment;
import com.example.king.dsjweek03.fragment.HomeFragment;
import com.example.king.dsjweek03.fragment.ShoppingFragment;

public class HomeActivity extends AppCompatActivity {

    private ViewPager pager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    pager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    pager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    private HomeFragment homeFragment;
    private ShoppingFragment shoppingFragment;
    private DanFragment danFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        pager =  findViewById(R.id.pager);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment = new HomeFragment();
        shoppingFragment = new ShoppingFragment();
        danFragment = new DanFragment();
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return homeFragment;
                    case 1:
                        return shoppingFragment;
                    case 2:
                        return danFragment;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        shoppingFragment.setGoodsIdCallBack(new ShoppingFragment.GoodsIdCallBack() {
            @Override
            public void toID(String id) {
                homeFragment.getActivityData(id);
                pager.setCurrentItem(0);
            }
        });

        shoppingFragment.setToDanCallBack(new ShoppingFragment.toDanCallBack() {
            @Override
            public void toDan() {
                pager.setCurrentItem(2);
            }
        });
    }

}
