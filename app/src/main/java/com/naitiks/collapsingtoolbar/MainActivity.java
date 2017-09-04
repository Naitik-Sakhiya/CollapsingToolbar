package com.naitiks.collapsingtoolbar;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> list;
    RecyclerViewAdapter adapter;
    String[] names = {"androidwithtea.info", "Beta", "CupCake", "Donut",
            "Eclair", "Froyo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop",
            "Marshmallow", "Nougat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        //Set collapse & expanded title color
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        //Set the title on collapsing toolbar
        collapsingToolbarLayout.setTitle("androidwithtea.info");

        setSupportActionBar(toolbar);

        //Enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Setting data to recyclerview which provides nested scrolling behaviour
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this, list);
        recyclerView.setAdapter(adapter);



        createModels();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            //default back behaviour
            onBackPressed();
            return true;
        } else if (id == R.id.option1){
            Toast.makeText(MainActivity.this, "Menu item 1 clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.option2){
            Toast.makeText(MainActivity.this, "Menu item 2 clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }

    private void createModels() {
        for (int i = 0; i < names.length; i++) {
            Model model = new Model(names[i]);
            list.add(model);
        }
    }

    class Model{
        public String name = null;
        public Model(String name){
            this.name = name;
        }
    }
}
