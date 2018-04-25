package com.example.jocelyn.homework1_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

public class Hw1 extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;
    //LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);
       // layoutManager = new LinearLayoutManager(this); //?????
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(100);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //this要做什麼

    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int itemID = item.getItemId();
            if(itemID == R.id.action_select) {
                Toast.makeText(this,mAdapter.getOutput()+" are selected.",Toast.LENGTH_LONG).show();
            }return true;

    }
}

