package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class profileuser extends AppCompatActivity {


    EditText textviewname ;
    SharedPreferences sharedPreferences ;

    private static String shared_ref = "mypref";
    private static final String Key_nom = "nom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileuser);

         textviewname = findViewById(R.id.enom);
        sharedPreferences = getSharedPreferences(shared_ref, MODE_PRIVATE);


        String Tel = sharedPreferences.getString(Key_nom,null);

            textviewname.setText(Tel);


    }
}