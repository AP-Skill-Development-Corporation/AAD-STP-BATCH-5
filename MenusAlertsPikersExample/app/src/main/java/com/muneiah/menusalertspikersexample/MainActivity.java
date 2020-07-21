package com.muneiah.menusalertspikersexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //for adding a option menus in our activty
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //for inflating the menus
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                Toast.makeText(this, "you clicked Alert Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ap:
                Toast.makeText(this, "Hello Apssdc", Toast.LENGTH_SHORT).show();
            break;
            case R.id.search:
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Create an alert Dialog
    public void showAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("do you want close app..?");
        builder.setIcon(R.drawable.ic_add_alert_black_24dp);
       builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
               finish();
           }
       });
        builder.show();


    }

}
