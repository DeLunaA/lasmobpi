package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class hotcoffee extends AppCompatActivity {

    TextView txticed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotcoffee);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        txticed=(TextView)findViewById(R.id.ticed);
        txticed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {
                Intent act20 = new Intent(hotcoffee.this , icedcoffee.class);
                startActivity(act20);
            }

        });
    }
}