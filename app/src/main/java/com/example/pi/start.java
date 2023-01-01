package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

        Button home = findViewById(R.id.btnmenu);
        Button profile = findViewById(R.id.btnprofile);
        Button beans = findViewById(R.id.btnbeans);
        Button contact = findViewById(R.id.btncontact);

                home.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)  {
                        Intent act20 = new Intent(start.this ,hotcoffee.class);
                        startActivity(act20);
                    }




                });

                profile.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent act20 = new Intent(start.this ,profileuser.class);
                        startActivity(act20);
                    }
                }));


    }
}