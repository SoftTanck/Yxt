package com.softtanck.framework.activity;

import com.softtanck.framework.ConValue;
import com.softtanck.framework.R;
import com.softtanck.framework.utils.ScreenUtils;

/**
 * 个人信息界面和系统设置界面
 */
public class PersonInfoAndSystemSettingActivity extends BaseActivity {

    /**
     * 用户信息界面和系统设置界面得类型
     */
    private String type;
    private final String PERSONINFO="PersonInfo";
    private final String MORESETTING="MoreSetting";
    @Override
    protected int getViewId() {
        type=getIntent().getStringExtra(ConValue.FUNCTION_TYPE_TAG);
        return type.equals(PERSONINFO)?R.layout.person_info:R.layout.system_setting;
    }

    @Override
    protected void onActivityCreate() {
        initTitle();

    }

    private void initTitle() {
        ScreenUtils.setChenjin(findViewById(R.id.personInfoOrSystemSetting), PersonInfoAndSystemSettingActivity.this);
        String title=type.equals(PERSONINFO)?"个人信息":"系统设置";
        titleView.setTitle(title);
    }
}
