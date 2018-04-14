package com.example.jocelyn.hw1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextActivityBtn = (Button) findViewById(R.id.button);

        nextActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText input = (EditText) findViewById(R.id.input);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("input", input.getText().toString());
                intent.setClass(MainActivity.this, Result.class);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
    }


}
