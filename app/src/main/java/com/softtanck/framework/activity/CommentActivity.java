package com.softtanck.framework.activity;

import com.softtanck.framework.R;
import com.softtanck.framework.adapter.CommentAdapter;
import com.softtanck.framework.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO 评论界面 包含emoji.IM这块儿.
 * @date 9/2/2015
 */
public class CommentActivity extends BaseActivity {

    private PullToRefreshListView listView;

    private CommentAdapter adapter;
    private List<String> list;

    @Override
    protected int getViewId() {
        return R.layout.activity_comment;
    }

    @Override
    protected void onActivityCreate() {

        initList();

    }

    private void initList() {
        listView = (PullToRefreshListView) findViewById(R.id.pl_comment);

        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("----");
        }

        adapter = new CommentAdapter(CommentActivity.this, list);
        listView.setAdapter(adapter);
    }
}
