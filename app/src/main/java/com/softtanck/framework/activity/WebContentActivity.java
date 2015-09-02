package com.softtanck.framework.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.softtanck.framework.R;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 9/2/2015
 */
public class WebContentActivity extends BaseActivity {

    private LinearLayout commentView;

    @Override
    protected int getViewId() {
        return R.layout.activity_web;
    }

    @Override
    protected void onActivityCreate() {

        initView();
    }

    private void initView() {
        commentView = (LinearLayout) findViewById(R.id.ll_web_comment);
        commentView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll_web_comment: // 评论
                changeAc(CommentActivity.class);
                break;
        }
    }
}
