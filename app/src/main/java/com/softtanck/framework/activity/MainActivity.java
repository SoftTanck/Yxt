package com.softtanck.framework.activity;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.softtanck.framework.R;
import com.softtanck.framework.fragment.AboutMeFragment;
import com.softtanck.framework.fragment.MyTaskFragment;
import com.softtanck.framework.fragment.RankFragment;
import com.softtanck.framework.utils.ScreenUtils;


public class MainActivity extends BaseActivity {


    private FragmentTransaction fragmentTransaction;

    private LinearLayout myTask, rank, aboutme;
    private MyTaskFragment taskFragment;
    private RankFragment rankFragment;
    private AboutMeFragment aboutMeFragment;


    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityCreate() {
        ScreenUtils.setChenjin(findViewById(R.id.rl), MainActivity.this);
        initView();
        initContent();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        myTask = (LinearLayout) findViewById(R.id.ll_home_mytask);
        rank = (LinearLayout) findViewById(R.id.ll_home_rank);
        aboutme = (LinearLayout) findViewById(R.id.ll_home_about_me);
        myTask.setOnClickListener(this);
        rank.setOnClickListener(this);
        aboutme.setOnClickListener(this);
    }

    /**
     * 初始化内容
     */
    private void initContent() {
        taskFragment = new MyTaskFragment();
        rankFragment = new RankFragment();
        aboutMeFragment = new AboutMeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_content, taskFragment)
                .add(R.id.fl_home_content, rankFragment)
                .add(R.id.fl_home_content, aboutMeFragment).
                hide(rankFragment).
                hide(aboutMeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll_home_mytask: // 我的任务
                showFragment(taskFragment);
                hideFragment(rankFragment, aboutMeFragment);
                break;
            case R.id.ll_home_rank: // 排行
                showFragment(rankFragment);
                hideFragment(taskFragment, aboutMeFragment);
                break;
            case R.id.ll_home_about_me://关于我
                showFragment(aboutMeFragment);
                hideFragment(taskFragment, rankFragment);
                break;
        }
    }
}
