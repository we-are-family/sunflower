package com.example.admin.sunflower.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.sunflower.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 2016/5/8.
 */
public class Activity_inform_v extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyAdapter adapter = new MyAdapter(Activity_inform_v.this,getData());//获取将要绑定的数据传入其中
        setListAdapter(adapter);
    }
    //要传入的数据
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "活动  1 Invitation");
        map.put("info", "志愿组织 1");
        map.put("img", R.drawable.i1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "活动  2 Invitation");
        map.put("info", "志愿组织 2");
        map.put("img", R.drawable.i2);
        list.add(map);

        return list;
    }

    /**
     * listview中点击按键弹出对话框
     */
    public void showInfo(){
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确定接受邀请？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }


    //ViewHolder静态类
    public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private List<Map<String, Object>> mData;

        public MyAdapter(Context context,List<Map<String, Object>> mData){
            //根据context上下文加载布局
            this.mInflater = LayoutInflater.from(context);
            //将传入的数据保存在mData中
            this.mData=mData;
        }
        @Override
        public int getCount() {
            //How many items are in the data set represented by this Adapter.
            //在此适配器中所代表的数据集中的条目数
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            // Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
            return position;
        }

        @Override
        public long getItemId(int position) {
            //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position;
        }

        @Override
        //Get a View that displays the data at the specified position in the data set.
        //获取一个在数据集中指定索引的视图来显示数据
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                //自定义的一个类用来缓存convertview
                holder=new ViewHolder();

                //根据自定义的Item布局加载布局
                convertView = mInflater.inflate(R.layout.activity_inform_v, null);

                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.title = (TextView)convertView.findViewById(R.id.title);
                holder.info = (TextView)convertView.findViewById(R.id.info);
                holder.viewBtn = (Button)convertView.findViewById(R.id.accept_btn);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


            holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
            holder.title.setText((String)mData.get(position).get("title"));
            holder.info.setText((String)mData.get(position).get("info"));

            //为BTN设置点击监听事件
            holder.viewBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInfo();
                }
            });


            return convertView;
        }

    }

}
