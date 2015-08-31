
package com.softtanck.framework.activity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.softtanck.framework.R;
import com.softtanck.framework.adapter.SchoolBagAndSignUpExpandAdapter;
import com.softtanck.framework.bean.ChildCourseAndSignUpInfo;
import com.softtanck.framework.bean.CourseAndSignUpInfo;
import com.softtanck.framework.pulltorefresh.PullToRefreshExpandableListView;

import java.util.ArrayList;
import java.util.List;


/**
 * 我的书包和闪电报名的页面
 */
public class MySchoolBagAndSignUpActivity extends ExpandableListActivity {

    private PullToRefreshExpandableListView pullRefreshExpandableList;
    private SchoolBagAndSignUpExpandAdapter adapter;
    private List<CourseAndSignUpInfo>list=new ArrayList<>();
    private ExpandableListView expandableListView;

/*
    @Override
    protected int getViewId() {
        return R.layout.activity_my_school_bag_and_sign_up;
    }

    @Override
    protected void onActivityCreate() {
        initExpandListView();

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_school_bag_and_sign_up);
        initExpandListView();
    }

    private void initExpandListView() {
        pullRefreshExpandableList=(PullToRefreshExpandableListView)findViewById(R.id.pull_refresh_expandable_list);
        //expandableListView=(ExpandableListView)findViewById(R.id.expand);
        CourseAndSignUpInfo info=new CourseAndSignUpInfo();
        info.setParentType("其他");
        info.setParentTime("3天后过期");
        info.setParentContent("MOTO x拆装机教程");
        ChildCourseAndSignUpInfo child0=new ChildCourseAndSignUpInfo();
        child0.setChildType(0);
        child0.setChildContent("MOTO x拆装机教程");
        ChildCourseAndSignUpInfo child1=new ChildCourseAndSignUpInfo();
        child1.setChildType(2);
        child1.setChildContent("wifi下观看视频moto拆装");
        List<ChildCourseAndSignUpInfo>childCourseAndSignUpInfo=new ArrayList<>();
        childCourseAndSignUpInfo.add(child0);
        childCourseAndSignUpInfo.add(child1);
        info.setList(childCourseAndSignUpInfo);


        CourseAndSignUpInfo info1=new CourseAndSignUpInfo();
        info1.setParentType("其他");
        info1.setParentTime("2015-10-31过期");
        info1.setParentContent("必修课：A330产品功能介绍");
        ChildCourseAndSignUpInfo c0=new ChildCourseAndSignUpInfo();
        c0.setChildType(0);
        c0.setChildContent("A330产品功能介绍");
        ChildCourseAndSignUpInfo c1=new ChildCourseAndSignUpInfo();
        c1.setChildType(1);
        c1.setChildContent("1、A330产品功能介绍(一)");
        ChildCourseAndSignUpInfo c2=new ChildCourseAndSignUpInfo();
        c2.setChildType(1);
        c2.setChildContent("2、A330产品功能介绍(二)");
        ChildCourseAndSignUpInfo c3=new ChildCourseAndSignUpInfo();
        c3.setChildType(1);
        c3.setChildContent("3、A330产品功能介绍(三)");
        List<ChildCourseAndSignUpInfo>childInfo=new ArrayList<>();
        childInfo.add(c0);
        childInfo.add(c1);
        childInfo.add(c2);
        childInfo.add(c3);
        info1.setList(childInfo);
        for (int i=0;i<100;i++){
            if ((i%2)==0){
                list.add(info);
            }else{
                list.add(info1);
            }
        }
        adapter=new SchoolBagAndSignUpExpandAdapter(this,list);
        setListAdapter(adapter);
       // expandableListView.setAdapter(adapter);
}
}