package com.softtanck.framework.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.softtanck.framework.R;
import com.softtanck.framework.adapter.QuanerAdAdapter;
import com.softtanck.framework.adapter.QuanerAdapter;
import com.softtanck.framework.pulltorefresh.PullToRefreshBase;
import com.softtanck.framework.pulltorefresh.PullToRefreshListView;
import com.softtanck.framework.utils.ScreenUtils;
import com.softtanck.framework.view.ViewpagerScroll;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 8/27/2015
 */
public class YiQuanerActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener, AdapterView.OnItemClickListener {

    private PullToRefreshListView listView;

    private QuanerAdapter adapter;

    private List<String> list;

    private View header;

    private ViewPager quanerPager;
    private QuanerAdAdapter adAdapter;
    private List<View> adList;

    private int DEFAULT_TIME = 3000;//广告时间

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            quanerPager.setCurrentItem(msg.what++ % adList.size());
            handler.sendEmptyMessageDelayed(msg.what, DEFAULT_TIME);
        }
    };

    @Override
    protected int getViewId() {
        return R.layout.activity_quaner;
    }

    @Override
    protected void onActivityCreate() {
        ScreenUtils.setChenjin(findViewById(R.id.ll), YiQuanerActivity.this);
        findView();
    }

    private void findView() {
        listView = (PullToRefreshListView) findViewById(R.id.pl_quaner_list);
        header = View.inflate(context, R.layout.item_task_ad_top_header, null);
        listView.getRefreshableView().addHeaderView(header);
        initHeader(header);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("----");
        }
        adapter = new QuanerAdapter(context, list);
        listView.setAdapter(adapter);
        listView.setOnRefreshListener(this);
        listView.setOnItemClickListener(this);
    }

    /**
     * 初始化头部
     */
    private void initHeader(View header) {
        quanerPager = (ViewPager) header.findViewById(R.id.vp_quaner_ad);
        adList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.mipmap.ic_launcher);
            adList.add(imageView);
        }
        adAdapter = new QuanerAdAdapter(context, adList);
        quanerPager.setAdapter(adAdapter);
        new ViewpagerScroll(context, quanerPager, DEFAULT_TIME / 2);
        handler.sendEmptyMessageDelayed(0, DEFAULT_TIME);
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeAc(WebContentActivity.class);
    }
}
