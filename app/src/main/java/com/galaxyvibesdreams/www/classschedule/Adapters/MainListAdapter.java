package com.galaxyvibesdreams.www.classschedule.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.galaxyvibesdreams.www.classschedule.Pojo.ClassData;
import com.galaxyvibesdreams.www.classschedule.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Ray on 1/25/2017.
 */

public class MainListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ClassData> classDatas;


    private Calendar mCalender;

    public MainListAdapter(Context context, ArrayList<ClassData> classDatas) {
        this.context = context;
        this.classDatas = classDatas;
        mCalender = Calendar.getInstance();
    }

    @Override
    public int getCount() {
        return classDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return classDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.row_layout, viewGroup, false);
        ViewHolder mHolder = new ViewHolder();

        mHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        mHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        mHolder.tvEndTime = (TextView) convertView.findViewById(R.id.tvEndTime);
        mHolder.tvInstitute = (TextView) convertView.findViewById(R.id.tvInstitute);


        mHolder.tvTitle.setText(classDatas.get(i).getClassTitle());
        mHolder.tvInstitute.setText(classDatas.get(i).getClassInstitute());
        mHolder.tvEndTime.setText(classDatas.get(i).getClassEndTime());


        long timeInMills = (Long.parseLong(classDatas.get(i).getClassStartTime()));
        mCalender.setTimeInMillis(timeInMills);

        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String time = dateFormat.format(mCalender.getTime());
        mHolder.tvTime.setText(time);


        convertView.setTag(mHolder);


        return convertView;
    }

    public class ViewHolder {

        TextView tvTitle;
        TextView tvInstitute;
        TextView tvTime;
        TextView tvEndTime;

    }
}
