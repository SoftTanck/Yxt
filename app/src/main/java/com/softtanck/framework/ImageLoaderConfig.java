package com.softtanck.framework;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 7/8/2015.
 */
public class ImageLoaderConfig {

    private Context context;

    private ImageLoaderConfiguration config;

    private int cacheSize;

    private File cacheDir;

    public ImageLoaderConfig(Context context) {
        init(context);
    }

    /**
     * ��ʼ������
     *
     * @param context
     */
    private void init(Context context) {
        cacheSize = (int) (Runtime.getRuntime().maxMemory() / 8);//�ڴ滺���С
        cacheDir = StorageUtils.getOwnCacheDirectory(context, ConValue.App.UNIVERSAL_IMAGE_PATH);//���ػ���Ŀ¼
        config = new ImageLoaderConfiguration.Builder(context)
                // max width, max height���������ÿ�������ļ�����󳤿�
                .memoryCacheExtraOptions(480, 800)
                        // �̳߳��ڼ��ص�����
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                        // You can pass your own memory cache
                        // implementation/�����ͨ���Լ����ڴ滺��ʵ��
                .memoryCache(new UsingFreqLimitedMemoryCache(1 * 1024 * 1024))
                        //���ش�ŵĴ�С
                .memoryCacheSize(cacheSize).diskCacheSize(50 * 1024 * 1024)
                        // �������ʱ���URI������MD5 ����
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())

                .tasksProcessingOrder(QueueProcessingType.LIFO)
                        // ������ļ�����
                .discCacheFileCount(100)
                        // �Զ��建��·��
                .discCache(new UnlimitedDiskCache(cacheDir))

                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                        // connectTimeout
                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
                        // (5
                        // s),
                        // readTimeout
                        // (30
                        // s)��ʱʱ��
                .writeDebugLogs() // Remove for release app
                .build();// ��ʼ����
    }


    /**
     * ��ȡImageLoader��������
     *
     * @return
     */
    public ImageLoaderConfiguration getConfig() {
        return config;
    }

    /**
     * ������ʾ����ͼ��ķ�ʽ
     *
     * @return
     */
    public DisplayImageOptions setImageLoaderByIcon() {
        DisplayImageOptions options = new DisplayImageOptions.Builder().
                showImageOnLoading(null) // �����е�
                .showImageForEmptyUri(null)
                .showImageOnFail(null)//����ʧ�ܵ�
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(100))//����ͼƬ���Ե�ʱ��
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
        return options;
    }

    /**
     * ������ʾ����ͼƬ�ķ�ʽ:��ʱ�ȿ�����565
     *
     * @return
     */
    public DisplayImageOptions setImageLoaderByNormal() {
        DisplayImageOptions options = new DisplayImageOptions.Builder().
                showImageOnLoading(null) // �����е�
                .showImageForEmptyUri(null)
                .showImageOnFail(null)//����ʧ�ܵ�
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(100))//����ͼƬ���Ե�ʱ��
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }
}
