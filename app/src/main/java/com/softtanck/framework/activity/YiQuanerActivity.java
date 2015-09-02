package com.softtanck.framework.activity;

import android.view.View;
import android.widget.AdapterView;

import com.softtanck.framework.R;
import com.softtanck.framework.adapter.QuanerAdapter;
import com.softtanck.framework.pulltorefresh.PullToRefreshBase;
import com.softtanck.framework.pulltorefresh.PullToRefreshListView;
import com.softtanck.framework.utils.ScreenUtils;

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

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("----");
        }
        adapter = new QuanerAdapter(context, list);
        listView.setAdapter(adapter);
        listView.setOnRefreshListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
        public void onRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeAc(WebContentActivity.class);
    }
}
