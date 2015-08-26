package com.softtanck.framework.activity;


import android.support.v4.app.FragmentTransaction;

import com.softtanck.framework.R;
import com.softtanck.framework.fragment.AboutMeFragment;
import com.softtanck.framework.fragment.RankFragment;
import com.softtanck.framework.fragment.MyTaskFragment;
import com.softtanck.framework.utils.ScreenUtils;


public class MainActivity extends BaseActivity {


    private FragmentTransaction fragmentTransaction;


    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityCreate() {
        initMenu();
    }

    private void initMenu() {
        ScreenUtils.setChenjin(findViewById(R.id.rl), MainActivity.this);

        MyTaskFragment taskFragment = new MyTaskFragment();
        RankFragment rankFragment = new RankFragment();
        AboutMeFragment aboutMeFragment = new AboutMeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_content, taskFragment)
                .add(R.id.fl_home_content, rankFragment)
                .add(R.id.fl_home_content, aboutMeFragment).
                hide(rankFragment).
                hide(aboutMeFragment);
        fragmentTransaction.commit();
    }

}
