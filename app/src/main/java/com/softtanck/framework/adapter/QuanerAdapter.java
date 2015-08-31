package com.softtanck.framework.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softtanck.framework.R;

import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO :圈儿的适配
 * @date 8/27/2015
 */
public class QuanerAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public final static int HEADER = 1;
    public final static int CONTENT = 2;

    public QuanerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }

    @Override
    public int getViewTypeCount() {
        return 3; // 大于3即可
    }

    @Override
    public int getItemViewType(int position) {
        if (0 == position)
            return HEADER;
        return CONTENT;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            int type = getItemViewType(position);
            if (type == HEADER)
                convertView = View.inflate(context, R.layout.item_task_ad_top_header, null);
            else
                convertView = View.inflate(context, R.layout.item_quaner, null);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    private class ViewHolder {
        TextView textView;
    }
}
