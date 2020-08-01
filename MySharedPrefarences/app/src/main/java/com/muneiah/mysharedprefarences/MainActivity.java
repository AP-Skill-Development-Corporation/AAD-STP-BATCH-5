package com.muneiah.mysharedprefarences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences sp;
SharedPreferences.Editor editor;
EditText et_name,et_pass;
    String name;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.username);
        et_pass=findViewById(R.id.password);
        sp=getSharedPreferences("muni",MODE_PRIVATE);

    }

    public void showData(View view) {
         name=et_name.getText().toString();
         pwd=et_pass.getText().toString();
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        Toast.makeText(this, ""+name+"\n"+pwd, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {

        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        String resName=sp.getString("n","");
        String resPass=sp.getString("p","");
        et_name.setText(resName);
        et_pass.setText(resPass);
        super.onResume();
    }
}
/*Here Data is in the form of KEY and VALUE Pair
* SharedPrefarences sp=getsharePrefarences("filename",MODE_PRIVATE)
* SharedPrefarence.Editor edit=sp.edit()
* store:edit.putString("key","Value")
* retrive:sp.getString("key","")
* */