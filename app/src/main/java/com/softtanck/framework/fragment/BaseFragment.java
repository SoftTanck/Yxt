package com.softtanck.framework.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.softtanck.framework.activity.BaseActivity;
import com.softtanck.framework.utils.VolleyUtils;

/**
 * @author Tanck
 * @Description ������Ƭ�Ļ���
 * @date Jan 16, 2015 8:52:21 PM
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /** ��Ƭ����*/
    private BaseActivity holder;
    /** ͼƬ����*/
    private ImageLoader imageLoader;
    /** ������*/
    private Context context;
    /** �������*/
    private RequestQueue requestQueue;
    /** Volley������*/
    private VolleyUtils volleyUtils;
    /** gson����*/
    private Gson gson;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        holder = (BaseActivity) activity;

        imageLoader = holder.imageLoader;

        context = holder.getApplicationContext();

//        dialogUtils = holder.dialogUtils;

        requestQueue = holder.requestQueue;

        volleyUtils = holder.volleyUtils;

        gson = holder.gson;


        onAttaching();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutView(), container, false);
    }

    /**
     * ��ȡFragment��䲼��
     */
    protected abstract int getLayoutView();

    /**
     * ��Fragment�����ӵ�ʱ��
     */
    protected abstract void onAttaching();

}
