package com.softtanck.framework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.softtanck.framework.R;
import com.softtanck.framework.adapter.RankAdapter;
import com.softtanck.framework.bean.RankInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 8/26/2015
 */
public class RankFragment extends BaseFragment {

    private ListView rankList;
    private List<RankInfo> list;

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_rank;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        rankList=(ListView)view.findViewById(R.id.rank_list);
        initListView();
    }

    private void initListView() {
        list=new ArrayList<>();
        for (int i=0;i<25;i++){
            RankInfo rankInfo=new RankInfo();
            if (i==0){
                rankInfo.setNumber("序号");
                rankInfo.setStaffNumber("工号");
                rankInfo.setStaffName("姓名");
                rankInfo.setScore("分值");
            }else{
                rankInfo.setNumber(Integer.toString(i));
                rankInfo.setStaffNumber("E00E"+(new Random().nextInt(50)+1));
                rankInfo.setStaffName("张三" + i);
                rankInfo.setScore(""+(new Random().nextInt(1000)+1));
            }
            list.add(rankInfo);
        }
        rankList.setAdapter(new RankAdapter(context, list));
        View headView= LayoutInflater.from(context).inflate(R.layout.fragment_rank_head,null);
        rankList.addHeaderView(headView);


    }


}
