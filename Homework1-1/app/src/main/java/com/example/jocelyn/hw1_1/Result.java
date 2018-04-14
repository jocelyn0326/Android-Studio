package com.example.jocelyn.hw1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = (TextView) findViewById(R.id.show_result);
        Bundle bundleResult = this.getIntent().getExtras();
        result.setText("B10509040:" + bundleResult.getString("input"));

    }
}
