package com.muneiah.roomdbexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student_Entity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "rollnumber")
    private String rollnumber;

    @ColumnInfo(name = "name")
    private String name;
    /*alt+insert
    * or
    * right click select generate option
    * select the getters and setters*/

    @NonNull
    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(@NonNull String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
