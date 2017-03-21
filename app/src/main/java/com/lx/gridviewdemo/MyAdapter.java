package com.lx.gridviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixiang on 2017/3/2.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<User> users;
    public DisplayImageOptions options;
    private ExecutorService executors;

    public MyAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
        inflater = LayoutInflater.from(context);
//        options =new DisplayImageOptions.Builder()
//                .showStubImage(R.mipmap.ic_launcher)//下载期间
//                .showImageForEmptyUri(R.mipmap.ic_launcher)//下载错误
//                .showImageOnFail(R.mipmap.ic_launcher)//解码错误
//                .cacheInMemory(true)//内存
//                .cacheOnDisk(true)//内存卡
//                .displayer(new RoundedBitmapDisplayer(10))//圆角
//                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)//编码方式
//                .bitmapConfig(Bitmap.Config.RGB_565)//图片质量
//                .handler(new Handler())
//                .build();
        executors = Executors.newFixedThreadPool(3);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Temp temp = null;
        if (view==null){
            temp = new Temp();
            view = inflater.inflate(R.layout.item,null);
            temp.iv = (ImageView) view.findViewById(R.id.image);
            temp.tv = (TextView) view.findViewById(R.id.text);
            view.setTag(temp);
        }else {
            temp = (Temp) view.getTag();
        }
        User user = users.get(i);
        temp.tv.setText(user.getName());
        temp.iv.setImageResource(user.getId());
        return view;
    }


    class Temp{
        private TextView tv;
        private ImageView iv;

    }
}
