package com.softtanck.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softtanck.framework.R;
import com.softtanck.framework.bean.RankInfo;

import java.util.List;

/**������������
 * Created by herui on 8/26/2015.
 */
public class RankAdapter extends BaseAdapter{

    private Context context;
    private List<RankInfo>rankInfoList;
    public RankAdapter(Context context,List<RankInfo> list) {
        this.context=context;
        this.rankInfoList=list;
    }

    @Override
    public int getCount() {
        return rankInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return rankInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        RankInfo rankInfo=(RankInfo)getItem(i);
        if (view==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.fragment_rank_item,null);
            viewHolder.number=(TextView)view.findViewById(R.id.number);
            viewHolder.staffNumber=(TextView)view.findViewById(R.id.staffNumber);
            viewHolder.staffName=(TextView)view.findViewById(R.id.staffName);
            viewHolder.score=(TextView)view.findViewById(R.id.score);
            view.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder)view.getTag();
        }

        viewHolder.number.setText(rankInfo.getNumber());
        viewHolder.staffNumber.setText(rankInfo.getStaffNumber());
        viewHolder.staffName.setText(rankInfo.getStaffName());
        viewHolder.score.setText(rankInfo.getScore());

        return view;
    }

    static class ViewHolder{
        TextView number;
        TextView staffNumber;
        TextView staffName;
        TextView score;
    }
}
