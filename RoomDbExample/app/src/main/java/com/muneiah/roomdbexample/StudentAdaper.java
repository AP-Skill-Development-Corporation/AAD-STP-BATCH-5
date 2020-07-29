package com.muneiah.roomdbexample;

import android.content.Context;
import android.content.Intent;
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
        holder.stu_dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.studentDAO().delete(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView stud_name,stu_rollnumber,stu_edit,stu_dele;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            stud_name=itemView.findViewById(R.id.tv_sName);
            stu_rollnumber=itemView.findViewById(R.id.tv_srollnumber);
            stu_edit=itemView.findViewById(R.id.edit);
            stu_dele=itemView.findViewById(R.id.delete);
            stu_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n=stud_name.getText().toString();
                    String r=stu_rollnumber.getText().toString();
                    Intent i=new Intent(ctx,UpdateActivity.class);
                    i.putExtra("name",n);
                    i.putExtra("roll",r);
                   ctx.startActivity(i);


                }
            });

        }
    }
}
