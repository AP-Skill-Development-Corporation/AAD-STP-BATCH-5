package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    int[] images = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,
                    R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,
                    R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat,R.drawable.marshmallow};

    String[] versions = {"Alpha","Beta","CupCake","Sai Sankar",
                            "Swathi","Anusha","Muni","Meghana",
                            "Ganesh","Siva","Ajay","Raghava"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);

        rv.setAdapter(new MyDataAdapter(this,images,versions));
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,2));
        //rv.setLayoutManager(new StaggeredGridLayoutManager(2,1));

    }
}