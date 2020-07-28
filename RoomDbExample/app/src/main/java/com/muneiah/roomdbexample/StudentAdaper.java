package com.muneiah.roomdbexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdaper extends RecyclerView.Adapter<StudentAdaper.StudentViewHolder> {
   Context ctx;
   List<Student_Entity> list;

   /*alt + insert
   * or
   * right click then select generate create constructor*/

    public StudentAdaper(Context ctx, List<Student_Entity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(ctx).inflate(R.layout.every_row_design,parent,false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.stud_name.setText(list.get(position).getName());
        holder.stu_rollnumber.setText(list.get(position).getRollnumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView stud_name,stu_rollnumber;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            stud_name=itemView.findViewById(R.id.tv_sName);
            stu_rollnumber=itemView.findViewById(R.id.tv_srollnumber);
        }
    }
}
