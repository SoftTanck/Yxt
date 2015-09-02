package com.softtanck.framework.view;

/**
 * @author : Tanck
 * @Description : TODO WebView滑动的时候的接口
 * @date 9/2/2015
 */
public interface WebTouchListener {

    /**
     * 需要展示评论
     */
    public void needShow();

    /**
     * 需要隐藏评论
     */
    public void needHide();
}
