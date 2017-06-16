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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.UserBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.common.util.ACache;
import com.xxh.mobilehelper.common.util.UIUtils;
import com.xxh.mobilehelper.ui.adapter.MyPagerAdapter;
import com.xxh.mobilehelper.ui.fragment.CategoryFragment;
import com.xxh.mobilehelper.ui.fragment.GamingFragment;
import com.xxh.mobilehelper.ui.fragment.RankingFragment;
import com.xxh.mobilehelper.ui.fragment.RecommendFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

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
    private UserBean mUser;
    private ImageView mIvUserIcon;
    private TextView mTvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerMain = (DrawerLayout) findViewById(R.id.drawer_main);
        titles = getResources().getStringArray(R.array.main_tab);
        EventBus.getDefault().register(this);
        initPermission();
    }

    private void initPermission() {
        if (ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            //权限授予
            initDrawerLayout();
            initFragments();
            initViewPager();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{READ_PHONE_STATE}, READ_PHONE_STATE_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == READ_PHONE_STATE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //权限打开
                //权限授予
                initDrawerLayout();
                initFragments();
                initViewPager();
            } else {
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
        mIvUserIcon = (ImageView) headerView.findViewById(R.id.iv_user_icon);
        mTvUserName = (TextView) headerView.findViewById(R.id.tv_user_name);

        try {
            mUser = (UserBean) ACache.get(this).getAsObject(Constant.USER);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mUser == null) {
            showLogout();
        } else {
            showLogin();
        }

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
                    case R.id.menu_logout:
                        UIUtils.showToast("退出登录成功");
                        ACache.get(MainActivity.this).put(Constant.TOKEN, "");
                        ACache.get(MainActivity.this).put(Constant.USER, "");

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

    @Subscribe
    public void loginEvent(UserBean userBean) {
        mUser = userBean;
        showLogin();
    }

    private void showLogin() {
        if (mUser == null) {
            return;
        }
        try {
            mNagigationMain.getMenu().findItem(R.id.menu_logout).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String logo_url = mUser.getLogo_url();
        String username = mUser.getUsername();
        Glide.with(this).load(logo_url).bitmapTransform(new CropCircleTransformation(this)).into(mIvUserIcon);
        mTvUserName.setText(username);
        mIvUserIcon.setEnabled(false);
    }

    /**
     * 显示 未登录状态
     */
    private void showLogout() {
        try {
            mNagigationMain.getMenu().findItem(R.id.menu_logout).setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mIvUserIcon.setImageResource(R.drawable.ic_account_circle_black_24dp);
        mTvUserName.setText("请点击头像登录");
        mIvUserIcon.setEnabled(true);
        mIvUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
