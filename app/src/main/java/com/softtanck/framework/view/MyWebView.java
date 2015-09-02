package com.softtanck.framework.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * @author : Tanck
 * @Description : TODO 自定义Web使其响应滑动
 * @date 9/2/2015
 */
public class MyWebView extends WebView {

    private float oldy;

    private WebTouchListener touchListener;

    /**
     * 设置webTouch的监听
     *
     * @param touchListener
     */
    public void setTouchListener(WebTouchListener touchListener) {
        this.touchListener = touchListener;
    }

    public MyWebView(Context context) {
        this(context, null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (null == touchListener)
            return super.onTouchEvent(event);

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN://按下
                oldy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE://滑动
                float newY = event.getY() - oldy;
                if (0 > newY) { // 上滑
                    touchListener.needHide();
                } else {  // 下滑
                    touchListener.needShow();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
