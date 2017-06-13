package com.xxh.mobilehelper.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.ui.adapter.MyPagerAdapter;
import com.xxh.mobilehelper.ui.fragment.CategoryFragment;
import com.xxh.mobilehelper.ui.fragment.GamingFragment;
import com.xxh.mobilehelper.ui.fragment.RankingFragment;
import com.xxh.mobilehelper.ui.fragment.RecommendFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.Manifest.permission.READ_PHONE_STATE;

public class MainActivity extends AppCompatActivity {


    private static final int READ_PHONE_STATE_CODE = 1001;
    NavigationView mNagigationMain;

    DrawerLayout mDrawerMain;
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private ArrayList<Fragment> fragments;


    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerMain = (DrawerLayout) findViewById(R.id.drawer_main);
        titles = getResources().getStringArray(R.array.main_tab);
        initPermission();

    }

    private void initPermission() {
        if(ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            //权限授予
            initDrawerLayout();
            initFragments();
            initViewPager();
        }else {
            ActivityCompat.requestPermissions(this,new String[]{READ_PHONE_STATE},READ_PHONE_STATE_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==READ_PHONE_STATE_CODE) {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                //权限打开
                //权限授予
                initDrawerLayout();
                initFragments();
                initViewPager();
            }else {
                finish();
            }
        }
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(RecommendFragment.newInstance());
        fragments.add(RankingFragment.newInstance());
        fragments.add(GamingFragment.newInstance());
        fragments.add(CategoryFragment.newInstance());
    }


    private void initViewPager() {
        mViewpager.setOffscreenPageLimit(4);
        mViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments, titles));
        mTabLayout.setupWithViewPager(mViewpager);
    }

    private void initDrawerLayout() {
        mNagigationMain = (NavigationView) findViewById(R.id.nagigation_main);
        View headerView = mNagigationMain.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                //关闭侧滑菜单
                mDrawerMain.closeDrawer(GravityCompat.START);
            }
        });
        mNagigationMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(MainActivity.this, "点击菜单1", Toast.LENGTH_SHORT).show();
                        mDrawerMain.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu2:
                        Toast.makeText(MainActivity.this, "点击菜单2", Toast.LENGTH_SHORT).show();
                        mDrawerMain.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu3:
                        Toast.makeText(MainActivity.this, "点击菜单3", Toast.LENGTH_SHORT).show();
                        mDrawerMain.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

        mToolbar.inflateMenu(R.menu.menu_toolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(MainActivity.this, "点击菜单1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu2:
                        Toast.makeText(MainActivity.this, "点击菜单2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu3:
                        Toast.makeText(MainActivity.this, "点击菜单3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerMain, mToolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        mDrawerMain.addDrawerListener(actionBarDrawerToggle);

    }


}
