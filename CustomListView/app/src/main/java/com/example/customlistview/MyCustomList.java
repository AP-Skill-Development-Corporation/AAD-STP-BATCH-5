package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomList extends ArrayAdapter<String> {

    Context ct;
    int[] myImage;
    String[] mynames;
    public MyCustomList(MainActivity mainActivity, int[] images, String[] names) {
        super(mainActivity,R.layout.row_design,names);
        ct = mainActivity;
        myImage = images;
        mynames = names;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(ct).inflate(R.layout.row_design,parent,false);

        TextView tv = v.findViewById(R.id.textview);
        ImageView iv = v.findViewById(R.id.imageview);

        tv.setText(mynames[position]);
        iv.setImageResource(myImage[position]);
        return v;
    }
}
