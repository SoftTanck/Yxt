package com.softtanck.framework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.softtanck.framework.ConValue;
import com.softtanck.framework.R;
import com.softtanck.framework.activity.PersonInfoAndSystemSettingActivity;

/**关于我的界面
 * @author : herui
 * @Description : TODO
 * @date 8/26/2015
 */
public class AboutMeFragment extends BaseFragment{
    private RelativeLayout personInfo,moreSetting;

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_about_me;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View v) {
        personInfo=(RelativeLayout)v.findViewById(R.id.personInfo);
        moreSetting=(RelativeLayout)v.findViewById(R.id.moreSetting);
        personInfo.setOnClickListener(this);
        moreSetting.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.personInfo:
                Intent intent=new Intent(holder, PersonInfoAndSystemSettingActivity.class);
                intent.putExtra(ConValue.FUNCTION_TYPE_TAG,"PersonInfo");
                holder.startActivity(intent);
                break;
            case R.id.moreSetting:
                Intent it=new Intent(holder, PersonInfoAndSystemSettingActivity.class);
                it.putExtra(ConValue.FUNCTION_TYPE_TAG,"MoreSetting");
                holder.startActivity(it);
                break;
        }
    }
}
