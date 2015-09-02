package com.softtanck.framework.activity;

import com.softtanck.framework.R;
import com.softtanck.framework.utils.ScreenUtils;

/**
 * 报名详情界面
 */
public class SignUpActivity extends BaseActivity {

    @Override
    protected int getViewId() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void onActivityCreate() {
        initTitle();

    }

    private void initTitle() {
        ScreenUtils.setChenjin(findViewById(R.id.sign_up_first_linear), SignUpActivity.this);
        titleView.setTitle("报名");
        titleView.setTitleViewBackGround(R.color.white);
        titleView.setTitleColor(getResources().getColor(R.color.black));
    }
}
