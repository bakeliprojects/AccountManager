package com.example.nogsdiva.accountmanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.database.Db;
import com.example.nogsdiva.accountmanager.modele.CheckingAccount;

import io.realm.Realm;


public class PaymentActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGEV = "com.example.nogsdiva.accountmanager.MESSAGEV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versement);


        Button bttn7 = (Button) findViewById(R.id.btverse);
        bttn7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v7) {

               Intent paymenIntent = getIntent();
                String paymentca = paymenIntent.getStringExtra(OperationActivity.EXTRA_VERSEMENTCA);

                Intent paymenIntent1 = getIntent();
                String paymensa = paymenIntent1.getStringExtra(OperationActivity.EXTRA_VERSEMENTSA);

                Intent paymenIntent2 = getIntent();
                String paymenba = paymenIntent2.getStringExtra(OperationActivity.EXTRA_VERSEMENTBA);

                if (paymentca != null) {
                    Toast.makeText(PaymentActivity.this, "versement CheckingAccount", Toast.LENGTH_SHORT).show();
                    Intent intcheck = new Intent(PaymentActivity.this, DisplayActivity.class);
                    EditText message = (EditText) findViewById(R.id.editnum);
                    String mess = message.getText().toString();
                    int mtt = Integer.parseInt(mess);
                    Db db = new Db();
                    db.paymenC(mtt);
                    intcheck.putExtra(EXTRA_MESSAGEV,"solde post_versement:\n" + db.displayC());
                    startActivity(intcheck);
                    finish();
                }

           else if (paymensa != null) {
                    Toast.makeText(PaymentActivity.this, "versement SavingAccount", Toast.LENGTH_SHORT).show();
                    Intent ints = new Intent(PaymentActivity.this, DisplayActivity.class);
                    EditText messag = (EditText) findViewById(R.id.editnum);
                    String mes = messag.getText().toString();
                    int mtt1 = Integer.parseInt(mes);
                    Db db = new Db();
                    db.paymenS(mtt1);
                    ints.putExtra(EXTRA_MESSAGEV,"solde post_versement:\n"+ db.displayS());
                    startActivity(ints);
                    finish();
                }

                //  Businessaccount
                else if (paymenba != null) {
                    Toast.makeText(PaymentActivity.this, "versement BusinessAccount", Toast.LENGTH_SHORT).show();
                    Intent intenb = new Intent(PaymentActivity.this, DisplayActivity.class);
                    EditText mt2 = (EditText) findViewById(R.id.editnum);
                    String messa = mt2.getText().toString();
                    int mtt2 = Integer.parseInt(messa);
                    Db db = new Db();
                    db.paymenB(mtt2);
                    intenb.putExtra(EXTRA_MESSAGEV,"solde post_versement:\n " + db.displayB());
                    startActivity(intenb);
                    finish();
                }

            }


        });


    }
}