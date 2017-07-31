package com.example.nogsdiva.accountmanager;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;





public class VersementActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGEV = "com.example.nogsdiva.accountmanager.MESSAGEV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versement);

        //on recupere l'intention Intent from OperationActivity

        Button bttn7 = (Button) findViewById(R.id.btverse);
        bttn7.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v7){

                Intent intverserca= getIntent();
                String versementca = intverserca.getStringExtra(OperationActivity.EXTRA_VERSEMENTCA);

                Intent intversersa= getIntent();
                String versementsa = intversersa.getStringExtra(OperationActivity.EXTRA_VERSEMENTSA);

                Intent intverserba= getIntent();
                String versementba = intverserba.getStringExtra(OperationActivity.EXTRA_VERSEMENTBA);


                if(versementca!=null){
                    // sendMessage(view);
                 Intent intcheck = new Intent(VersementActivity.this, DisplayActivity.class);
                 EditText message = (EditText) findViewById(R.id.editnum);
                  String mess = message.getText().toString();
                  int mtt = Integer.parseInt(mess);
                  CheckingAccount a1 = new CheckingAccount(10,0,800000);
                  int code1 = a1.getCode();
                 // System.out.println("le montant a verser est :" + mtt+ "f");
                  a1.verser(mtt);
                //System.out.println(a1.afficher(code3));
                  intcheck.putExtra(EXTRA_MESSAGEV, a1.afficher(code1));
                  startActivity(intcheck);  }


             else if(versementsa!=null){

                Intent ints = new Intent(VersementActivity.this, DisplayActivity.class);
                EditText messag = (EditText) findViewById(R.id.editnum);
                String mes = messag.getText().toString();
                int mtt1 = Integer.parseInt(mes);
                SavingAccount a2 = new SavingAccount(11,0,600000);
                int code2 = a2.getCode();
                // System.out.println("le montant a verser est :" + mtt+ "f");
                a2.verser(mtt1);
                //System.out.println(a1.afficher(code3));
                ints.putExtra(EXTRA_MESSAGEV, a2.afficher(code2));
                startActivity(ints);}

                //  Businessaccount
                 else if(versementba!=null){

                Intent intenb = new Intent(VersementActivity.this, DisplayActivity.class);
                EditText mt2 = (EditText) findViewById(R.id.editnum);
                String messa = mt2.getText().toString();
                int mtt2 = Integer.parseInt(messa);
                BusinessAccount a3 = new BusinessAccount(12,0,50000);
                int code3 = a3.getCode();
                // System.out.println("le montant a verser est :" + mtt+ "f");
                a3.verser(mtt2);
                //System.out.println(a1.afficher(code3));
                intenb.putExtra(EXTRA_MESSAGEV, a3.afficher(code3));
                startActivity(intenb);  }

            }


            });


    }
    }