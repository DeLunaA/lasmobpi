package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class profileuser extends AppCompatActivity {


    EditText textviewname ;
    EditText lastname ;
    EditText textviewtel ;
    EditText textviewemail ;
    EditText textviewmdp ;
     ;
        Button M;


    SharedPreferences sharedPreferences ;

    private static String shared_ref = "mypref";
    private static final String Key_nom = "nom";
    UserDB db  = new UserDB(profileuser.this);
        User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profileuser);

        sharedPreferences = getSharedPreferences(shared_ref, MODE_PRIVATE);

                String Tel = sharedPreferences.getString(Key_nom,null);

        db.open();
        user = db.getUserWithTelephone(Tel) ;
        db.close();
         textviewname = findViewById(R.id.enom);
        lastname = findViewById(R.id.eprenom);
        textviewtel = findViewById(R.id.etel);
        textviewemail = findViewById(R.id.eemail);
        textviewmdp = findViewById(R.id.emdp);



        textviewname.setText(user.getNom());
        lastname.setText(user.getPrenom());
        textviewtel.setText(user.getTel());
        textviewemail.setText(user.getEmail());
        textviewmdp.setText(user.getMdp());

        String Nom = textviewname.getText().toString();
        String prennom = lastname.getText().toString();
        String tel = textviewtel.getText().toString();
        String email = textviewemail.getText().toString();
        String mps = textviewmdp.getText().toString();

            M = findViewById(R.id.update);



            M.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                                db.open();
                            db.updateuser(email,mps,Nom,email,prennom) ;
                                    db.close();
                    Toast.makeText(profileuser.this, "account updated successfuly",Toast.LENGTH_SHORT).show();



                }
            });



    }
}