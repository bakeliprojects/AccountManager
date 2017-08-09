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


public class VersementActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGEV = "com.example.nogsdiva.accountmanager.MESSAGEV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versement);


        Button bttn7 = (Button) findViewById(R.id.btverse);
        bttn7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v7) {



               Intent intverserca = getIntent();
                String versementca = intverserca.getStringExtra(OperationActivity.EXTRA_VERSEMENTCA);

                Intent intversersa = getIntent();
                String versementsa = intversersa.getStringExtra(OperationActivity.EXTRA_VERSEMENTSA);

                Intent intverserba = getIntent();
                String versementba = intverserba.getStringExtra(OperationActivity.EXTRA_VERSEMENTBA);


                if (versementca != null) {

                    Toast.makeText(VersementActivity.this, "versement CheckingAccount", Toast.LENGTH_SHORT).show();
                    Intent intcheck = new Intent(VersementActivity.this, DisplayActivity.class);
                    EditText message = (EditText) findViewById(R.id.editnum);
                    String mess = message.getText().toString();
                    int mtt = Integer.parseInt(mess);
                    int code1 = Db.checking.getCode();
                    Db.checking.verser(mtt);
                    //System.out.println(a1.afficher(code3));
                    intcheck.putExtra(EXTRA_MESSAGEV,"solde post_versement:\n" + Db.checking.afficher(code1));
                    startActivity(intcheck);
                    finish();
                }

         /**       else if (versementsa != null) {
                    Toast.makeText(VersementActivity.this, "versement SavingAccount", Toast.LENGTH_SHORT).show();
                    Intent ints = new Intent(VersementActivity.this, DisplayActivity.class);
                    EditText messag = (EditText) findViewById(R.id.editnum);
                    String mes = messag.getText().toString();
                    int mtt1 = Integer.parseInt(mes);
                    int code2 = Db.saving.getCode();
                    // System.out.println("le montant a verser est :" + mtt+ "f");
                    Db.saving.verser(mtt1);
                    //System.out.println(a1.afficher(code3));
                    ints.putExtra(EXTRA_MESSAGEV, Db.saving.afficher(code2));
                    startActivity(ints);
                    finish();
                }

                //  Businessaccount
                else if (versementba != null) {
                    Toast.makeText(VersementActivity.this, "versement BusinessAccount", Toast.LENGTH_SHORT).show();
                    Intent intenb = new Intent(VersementActivity.this, DisplayActivity.class);
                    EditText mt2 = (EditText) findViewById(R.id.editnum);
                    String messa = mt2.getText().toString();
                    int mtt2 = Integer.parseInt(messa);
                    int code3 = Db.business.getCode();
                    Db.business.verser(mtt2);
                    //System.out.println(a1.afficher(code3));
                    intenb.putExtra(EXTRA_MESSAGEV, Db.business.afficher(code3));
                    startActivity(intenb);
                    finish();
                }*/

            }


        });


    }
}