package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class icedcoffee extends AppCompatActivity {

    TextView txthot;
    TextView Iteam1;
    ImageView im1;
    ImageView card;

    SharedPreferences sharedPreferences ;

    private static String shared_ref = "mypref";
    private static final String Key_nom = "nom";

    PanierDB db  = new PanierDB(icedcoffee.this);
    panier panier ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_icedcoffee);

        sharedPreferences = getSharedPreferences(shared_ref, MODE_PRIVATE);

        String Tel = sharedPreferences.getString(Key_nom,null);

        Toast.makeText(icedcoffee.this,Tel,Toast.LENGTH_SHORT).show();


        txthot=(TextView)findViewById(R.id.bhot);
        txthot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {
                Intent act20 = new Intent(icedcoffee.this ,hotcoffee.class);
                startActivity(act20);

            }

        });

        card=(ImageView)findViewById(R.id.Icard);
        card.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {
                Intent act2 = new Intent(icedcoffee.this ,orders.class);
                startActivity(act2);
            }

        });


        im1=(ImageView) findViewById(R.id.buy1);
        im1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {
                String i1 = "Iced latte";
                db.open();
                panier p1 = new panier(Tel,i1);
                db.insertPanier(p1);
                db.close();
                Toast.makeText(icedcoffee.this,"Iteam added with success",Toast.LENGTH_SHORT).show();

            }

        });


    }
}