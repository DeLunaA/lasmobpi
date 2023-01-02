package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class orders extends AppCompatActivity {

    EditText iteams ;
    EditText tels ;
    Button co;
    Button an;

    SharedPreferences sharedPreferences ;

    private static String shared_ref = "mypref";
    private static final String Key_nom = "nom";

    PanierDB db  = new PanierDB(orders.this);
    panier panier ;


    Button m ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_orders);

        sharedPreferences = getSharedPreferences(shared_ref, MODE_PRIVATE);

        String Tel = sharedPreferences.getString(Key_nom,null);


        db.open();
        panier = db.getpanierWithTelephone(Tel) ;
        db.close();

        tels = findViewById(R.id.ztel);
        iteams = findViewById(R.id.zorder);

        tels.setText(panier.getTel());
        iteams.setText(panier.getIteam());

        co=(Button) findViewById(R.id.confirm);
        co.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {
                Intent intent = new Intent(orders.this ,icedcoffee.class);
                startActivity(intent);
                Toast.makeText(orders.this, "Order successfully delivered",Toast.LENGTH_SHORT).show();
            }

        });

        m = findViewById(R.id.cancel);

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orders.this ,icedcoffee.class);
                startActivity(intent);
            }
        });





    }
}