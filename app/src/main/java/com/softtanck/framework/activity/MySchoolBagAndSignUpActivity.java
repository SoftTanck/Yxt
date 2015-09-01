
package com.softtanck.framework.activity;

import android.view.View;
import android.widget.ExpandableListView;

import com.softtanck.framework.ConValue;
import com.softtanck.framework.R;
import com.softtanck.framework.adapter.SchoolBagAndSignUpExpandAdapter;
import com.softtanck.framework.bean.ChildCourseAndSignUpInfo;
import com.softtanck.framework.bean.CourseAndSignUpInfo;
import com.softtanck.framework.pulltorefresh.PullToRefreshExpandableListView;
import com.softtanck.framework.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 我的书包和闪电报名的页面
 */
public class MySchoolBagAndSignUpActivity extends BaseActivity implements ExpandableListView.OnGroupExpandListener,ExpandableListView.OnChildClickListener{

    private PullToRefreshExpandableListView pullRefreshExpandableList;
    private SchoolBagAndSignUpExpandAdapter adapter;
    private List<CourseAndSignUpInfo> list = new ArrayList<>();
    private ExpandableListView expandableListView;
    /**
     * 我的书包和闪电报名类型
     */
    private String type;

    @Override
    protected int getViewId() {
        return R.layout.activity_my_school_bag_and_sign_up;
    }

    @Override
    protected void onActivityCreate() {
        type = getIntent().getStringExtra(ConValue.FUNCTION_TYPE_TAG);
        initTitle();
        initExpandListView();
    }

    private void initTitle() {
        ScreenUtils.setChenjin(findViewById(R.id.course_linear), MySchoolBagAndSignUpActivity.this);
        if (!"".equals(type)&&type.equals("mySchoolBag")) {
            titleView.setTitle("课程");
        } else if (!"".equals(type)&&type.equals("quicklySignUp")) {
            titleView.setTitle("报名");
        }
    }


    private void initExpandListView() {
        pullRefreshExpandableList = (PullToRefreshExpandableListView) findViewById(R.id.pull_refresh_expandable_list);
        //expandableListView=(ExpandableListView)findViewById(R.id.expand);
       if (type.equals("mySchoolBag")) {
           adapter = new SchoolBagAndSignUpExpandAdapter(this, getCourseInfo());
       }else {
           adapter = new SchoolBagAndSignUpExpandAdapter(this, getSignUpInfo());
       }
        //setListAdapter(adapter);
        expandableListView = pullRefreshExpandableList.getLv();
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupExpandListener(this);
        expandableListView.setOnChildClickListener(this);
    }




    private List<CourseAndSignUpInfo>getCourseInfo(){
        list.clear();
        CourseAndSignUpInfo info = new CourseAndSignUpInfo();
        info.setParentType("其他");
        info.setParentTime("3天后过期");
        info.setParentContent("MOTO x拆装机教程");
        ChildCourseAndSignUpInfo child0 = new ChildCourseAndSignUpInfo();
        child0.setChildType(0);
        child0.setChildContent("MOTO x拆装机教程");
        ChildCourseAndSignUpInfo child1 = new ChildCourseAndSignUpInfo();
        child1.setChildType(2);
        child1.setChildContent("wifi下观看视频moto拆装");
        List<ChildCourseAndSignUpInfo> childCourseAndSignUpInfo = new ArrayList<>();
        childCourseAndSignUpInfo.add(child0);
        childCourseAndSignUpInfo.add(child1);
        info.setList(childCourseAndSignUpInfo);


        CourseAndSignUpInfo info1 = new CourseAndSignUpInfo();
        info1.setParentType("其他");
        info1.setParentTime("2015-10-31过期");
        info1.setParentContent("必修课：A330产品功能介绍");
        ChildCourseAndSignUpInfo c0 = new ChildCourseAndSignUpInfo();
        c0.setChildType(0);
        c0.setChildContent("A330产品功能介绍");
        ChildCourseAndSignUpInfo c1 = new ChildCourseAndSignUpInfo();
        c1.setChildType(1);
        c1.setChildContent("1、A330产品功能介绍(一)");
        ChildCourseAndSignUpInfo c2 = new ChildCourseAndSignUpInfo();
        c2.setChildType(1);
        c2.setChildContent("2、A330产品功能介绍(二)");
        ChildCourseAndSignUpInfo c3 = new ChildCourseAndSignUpInfo();
        c3.setChildType(1);
        c3.setChildContent("3、A330产品功能介绍(三)");
        List<ChildCourseAndSignUpInfo> childInfo = new ArrayList<>();
        childInfo.add(c0);
        childInfo.add(c1);
        childInfo.add(c2);
        childInfo.add(c3);
        info1.setList(childInfo);
        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                list.add(info);
            } else {
                list.add(info1);
            }
        }

        return list;

    }

    private List<CourseAndSignUpInfo> getSignUpInfo(){
        list.clear();
        CourseAndSignUpInfo info = new CourseAndSignUpInfo();
        info.setParentType("其他");
        info.setParentTime("2015-09-30过期");
        info.setParentContent("1500元申购妩媚红16GMotoX+1开放版");
        ChildCourseAndSignUpInfo child0 = new ChildCourseAndSignUpInfo();
        child0.setChildType(3);
        child0.setChildContent("1500元申购妩媚红16GMotoX+1开放版");
        List<ChildCourseAndSignUpInfo> childCourseAndSignUpInfo = new ArrayList<>();
        childCourseAndSignUpInfo.add(child0);
        info.setList(childCourseAndSignUpInfo);

        CourseAndSignUpInfo info1 = new CourseAndSignUpInfo();
        info1.setParentType("其他");
        info1.setParentTime("2015-09-30过期");
        info1.setParentContent("2800元申购黑色64GMotoXT1115开放版");
        ChildCourseAndSignUpInfo child1 = new ChildCourseAndSignUpInfo();
        child1.setChildType(3);
        child1.setChildContent("2800元申购黑色64GMotoXT1115开放版");
        List<ChildCourseAndSignUpInfo> childCourseAndSignUpInfo1 = new ArrayList<>();
        childCourseAndSignUpInfo1.add(child1);
        info1.setList(childCourseAndSignUpInfo1);

        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                list.add(info);
            } else {
                list.add(info1);
            }

        }
        return list;

    }


    /**选中子视图的监听
     * @param expandableListView
     * @param view
     * @param groupPosition
     * @param childPosition
     * @param l
     * @return
     */
    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
        String content=list.get(groupPosition).getList().get(childPosition).getChildContent();
        showToast("选中的子视图："+content);

        return false;
    }

    /**父视图展开的监听
     * @param groupPosition
     */
    @Override
    public void onGroupExpand(int groupPosition) {
        for (int i = 0; i < list.size(); i++) {
            if (i != groupPosition && expandableListView.isGroupExpanded(i)) {
                expandableListView.collapseGroup(i);
            }
        }
    }
}