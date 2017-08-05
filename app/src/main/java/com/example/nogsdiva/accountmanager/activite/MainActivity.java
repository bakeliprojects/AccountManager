package com.example.nogsdiva.accountmanager.activite;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.java_class.Db;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_CHECK = "com.example.nogsdiva.accountmanager.CHECK";
    public final static String EXTRA_SAVE = "com.example.nogsdiva.accountmanager.SAVE";
    public final static String EXTRA_BUSS = "com.example.nogsdiva.accountmanager.BUSS";
    public final static String EXTRA_SOLDE = "com.example.nogsdiva.accountmanager.SOLDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= getIntent();
        String code = intent.getStringExtra(LoginActivity.EXTRA_CODE);

        Toast.makeText(MainActivity.this, "votre code identifiant est" +code , Toast.LENGTH_SHORT).show();

        // ca c pour le boutton checkingAccount
        Button bttn1 = (Button) findViewById(R.id.btn1);
        bttn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                intent.putExtra(EXTRA_SOLDE,"solde initial:\n" + Db.checking.getSolde() + "FCFA");
                Button c = (Button) findViewById(R.id.btn1);
                String check = c.getText().toString();
                intent.putExtra(EXTRA_CHECK, check);
                startActivity(intent);
            }

        });

         Button bttn2 = (Button) findViewById(R.id.btn2);
         bttn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                intent.putExtra(EXTRA_SOLDE,"solde initial:\n" + Db.saving.getSolde() + "FCFA");
                Button c = (Button) findViewById(R.id.btn2);
                String save = c.getText().toString();
                intent.putExtra(EXTRA_SAVE, save);
                startActivity(intent);
            }

        });
         Button bttn3 = (Button) findViewById(R.id.btn3);
        bttn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                intent.putExtra(EXTRA_SOLDE,"solde initial:\n" + Db.business.getSolde() + "FCFA");
              Button c = (Button) findViewById(R.id.btn3);
                String buss = c.getText().toString();
                intent.putExtra(EXTRA_BUSS, buss);
                startActivity(intent);
            }

        });

    }
}
