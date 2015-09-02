package com.softtanck.framework.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softtanck.framework.R;
import com.softtanck.framework.imageview.CircleImageView;

import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 9/2/2015
 */
public class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public CommentAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView = View.inflate(context, R.layout.item_comment, null);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    private class ViewHolder {
        CircleImageView head;
        TextView content;
    }
}
