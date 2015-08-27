package com.softtanck.framework.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.softtanck.framework.R;
import com.softtanck.framework.activity.YiQuanerActivity;
import com.softtanck.framework.adapter.NewsPagerAdapter;
import com.softtanck.framework.ui.KJScrollView;
import com.softtanck.framework.view.ViewpagerScroll;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 8/26/2015
 */
public class MyTaskFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {
    private ViewPager viewPager;
    private KJScrollView scrollView;
    private ImageView point;
    private List<ImageView> list;
    private NewsPagerAdapter adapter;
    private int currentItem;
    private int currentIndex;


    private boolean isTouch;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (!isTouch && !scrollView.getisMoved())
                viewPager.setCurrentItem(currentItem++);
            handler.sendEmptyMessageDelayed(currentItem, 3000);
        }
    };

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_mytask;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initNews(view);
    }

    /**
     * 初始化新闻布局
     *
     * @param view
     */
    private void initNews(View view) {
        scrollView = (KJScrollView) view.findViewById(R.id.sc_home_task);
        viewPager = (ViewPager) view.findViewById(R.id.home_news_vp);
        point = (ImageView) view.findViewById(R.id.iv_home_news_point);
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) { // TODO 小于4的Bug尚未解决
            ImageView imageView = new ImageView(view.getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            list.add(imageView);
        }
        adapter = new NewsPagerAdapter(list);
        viewPager.setAdapter(adapter);
        currentItem = Integer.MAX_VALUE / 2;
        currentItem = currentItem - ((Integer.MAX_VALUE / 2) % list.size());
        viewPager.setCurrentItem(currentItem);
        viewPager.setOnPageChangeListener(this);
        viewPager.setOnTouchListener(this);
        new ViewpagerScroll(view.getContext(), viewPager, 1500);
        drawPoint();
        handler.sendEmptyMessageDelayed(currentItem++, 1500);
    }

    /**
     * 画圆点
     */
    private void drawPoint() {
        int radius = 10; // 半径
        int spacing = 50; // 点之间间隔
        Bitmap points = Bitmap.createBitmap(radius * 2 + spacing * (list.size() - 1), radius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(points);
        Paint paint = new Paint();
        paint.setAntiAlias(true); // 设置画笔为无锯齿
        paint.setStyle(Paint.Style.FILL); // 实心
        for (int i = 0; i < list.size(); i++) {
            paint.setColor(Color.GRAY);
            if (currentIndex == i) // 设置选中项为白色
                paint.setColor(Color.WHITE);
            canvas.drawCircle(radius + spacing * i, radius, radius, paint);
        }
        point.setImageBitmap(points);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentItem = position;//假位置更新
        currentIndex = position % list.size();//真实位置
        drawPoint();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isTouch = true;
                scrollView.setIsCanMove(isTouch);
                break;
            case MotionEvent.ACTION_UP:
                isTouch = false;
                scrollView.setIsCanMove(isTouch);
                scrollView.requestDisallowInterceptTouchEvent(false);
                break;
            default:
                scrollView.requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_home_news_count:
            case R.id.tv_home_news_top_one:
                Intent YiQuaner = new Intent(context, YiQuanerActivity.class);
                startActivity(YiQuaner);
                break;
        }
    }


}
