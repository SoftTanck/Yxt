package com.softtanck.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.softtanck.framework.R;
import com.softtanck.framework.bean.ChildCourseAndSignUpInfo;
import com.softtanck.framework.bean.CourseAndSignUpInfo;
import com.softtanck.framework.view.RoundProgressView;

import java.util.List;

/**
 * 我的书包和闪电报名的Expand适配器
 * Created by herui on 8/27/2015.
 */
public class SchoolBagAndSignUpExpandAdapter extends BaseExpandableListAdapter {
    private static final int TITLE = 0;
    private static final int DOC = 1;
    private static final int VIDEO = 2;
    private static final int SIGNUP = 3;
    private Context context;
    List<CourseAndSignUpInfo> parentInfo;
    private LayoutInflater inflater;

    public SchoolBagAndSignUpExpandAdapter(Context context, List<CourseAndSignUpInfo> parentInfo) {
        this.context = context;
        this.parentInfo = parentInfo;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * 获取的群体数量，得到父元素的个数
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        return parentInfo.size();
    }

    /**
     * 取得指定组中的儿童人数，就是父元素每一个对应的个数
     *
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return parentInfo.get(groupPosition).getList().size();
    }

    /**
     * 获取与给定的组相关的数据，得到数组父元素的数据
     *
     * @param groupPosition
     * @return
     */
    @Override
    public CourseAndSignUpInfo getGroup(int groupPosition) {
        return parentInfo.get(groupPosition);
    }

    /**
     * 获取父元素中对应的子元素的数据
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public ChildCourseAndSignUpInfo getChild(int groupPosition, int childPosition) {
        return parentInfo.get(groupPosition).getList().get(childPosition);
    }

    /**
     * 获取组在给定的位置编号，即父元素元素的ID
     *
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取在给定的组的儿童的ID
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * 表示孩子是否和组ID是跨基础数据的更改稳定
     *
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 孩子在指定的位置是可选的
     *
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    /**
     * 获取一个视图显示给定组，存放父元素
     *
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.course_and_signup_parent_item, null);
        }
        ParentViewHolder holder = getParentViewHolder(convertView);
        RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.relative);
        if (isExpanded) {
            relativeLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.course_top_title_shape));
        }else {
            relativeLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.course_signup_parent_item_bg));
        }
        try {
            //父标题左上角内容
            holder.leftTv.setText(getGroup(groupPosition).getParentType());
            //父标题右上角内容
            holder.rightTv.setText(getGroup(groupPosition).getParentTime());
            //父标题内容
            holder.content.setText(getGroup(groupPosition).getParentContent());
            //父标题百分比
            holder.roundProgress.setProgress(groupPosition);
        } catch (Exception e) {

        }
        return convertView;
    }

    /**
     * 获取一个视图显示在给定的组的儿童的数据，就是存放子元素
     *
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildCourseAndSignUpInfo child = getChild(groupPosition, childPosition);
        int childType = child.getChildType();
       /* if (convertView==null ){
            convertView=getChildrenView(child);
            Log.d("ruihe","---->childView无视图<-----");
            }*/
        TextView content;
        ImageView leftImage;
        convertView = getChildrenView(child);
        if (isLastChild) {
            RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.relative);
            if (childType == SIGNUP) {
                relativeLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.sign_up_bottle_title_shape));
            } else {
                relativeLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.course_bottle_title_shape));
            }
        }
        // ChildViewHolder childHolder= getChildHolder(convertView, childType);
        try {
            switch (childType) {
                case TITLE:
                    content = (TextView) convertView.findViewById(R.id.sign_up_item_content);
                    content.setText(child.getChildContent());
                    break;
                case DOC:
                    leftImage = (ImageView) convertView.findViewById(R.id.sign_up_item_left);
                    content = (TextView) convertView.findViewById(R.id.childDoc_content);
                    leftImage.setImageResource(R.drawable.ratio_4);
                    content.setText(child.getChildContent());
                    break;
                case VIDEO:
                    leftImage = (ImageView) convertView.findViewById(R.id.childVideo_left);
                    content = (TextView) convertView.findViewById(R.id.childVideo_Content);
                    leftImage.setImageResource(R.drawable.ratio_100);
                    content.setText(child.getChildContent());
                    break;
                case SIGNUP:
                    leftImage = (ImageView) convertView.findViewById(R.id.sign_up_item_left);
                    content = (TextView) convertView.findViewById(R.id.sign_up_item_content);
                    leftImage.setImageResource(R.drawable.task_apply_system);
                    content.setText(child.getChildContent());
                    break;
            }
        } catch (Exception e) {

        }

        return convertView;
    }

    /**
     * 获取子view
     *
     * @param child
     * @return
     */
    private View getChildrenView(ChildCourseAndSignUpInfo child) {

        int childType = child.getChildType();
        switch (childType) {
            case DOC:
                return inflater.inflate(R.layout.course_child_item_doc, null);
            case VIDEO:
                return inflater.inflate(R.layout.course_child_item_video, null);
            case TITLE:
                return inflater.inflate(R.layout.course_child_item_title, null);
            case SIGNUP:
                return inflater.inflate(R.layout.signup_child_item_title, null);
            default:
                return null;
        }
    }


    public ParentViewHolder getParentViewHolder(View view) {
        ParentViewHolder parentViewHolder = (ParentViewHolder) view.getTag();
        if (parentViewHolder == null) {
            parentViewHolder = new ParentViewHolder(view);
            view.setTag(parentViewHolder);
        }
        return parentViewHolder;
    }

    public class ParentViewHolder {
        TextView leftTv;
        TextView rightTv;
        TextView content;
        RoundProgressView roundProgress;

        public ParentViewHolder(View v) {
            leftTv = (TextView) v.findViewById(R.id.parentType);
            rightTv = (TextView) v.findViewById(R.id.parentTime);
            content = (TextView) v.findViewById(R.id.parentContent);
            roundProgress=(RoundProgressView)v.findViewById(R.id.roundProgress);
        }
    }

    public ChildViewHolder getChildHolder(View view, int type) {
        ChildViewHolder childViewHolder = (ChildViewHolder) view.getTag();
        if (childViewHolder == null) {
            childViewHolder = new ChildViewHolder(view, type);
            view.setTag(childViewHolder);
        }

        return childViewHolder;

    }

    public class ChildViewHolder {
        TextView content;
        ImageView leftImage;
        ImageView rightImage;

        public ChildViewHolder(View v, int type) {
            switch (type) {
                case TITLE:
                    content = (TextView) v.findViewById(R.id.sign_up_item_content);
                    break;
                case DOC:
                    leftImage = (ImageView) v.findViewById(R.id.sign_up_item_left);
                    content = (TextView) v.findViewById(R.id.childDoc_content);
                    break;
                case VIDEO:
                    leftImage = (ImageView) v.findViewById(R.id.childVideo_left);
                    rightImage = (ImageView) v.findViewById(R.id.childVideo_right);
                    content = (TextView) v.findViewById(R.id.childVideo_Content);
                    break;
            }
        }

    }


}