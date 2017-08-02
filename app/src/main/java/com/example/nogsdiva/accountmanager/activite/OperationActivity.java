package com.example.nogsdiva.accountmanager.activite;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.java_class.BusinessAccount;
import com.example.nogsdiva.accountmanager.java_class.CheckingAccount;
import com.example.nogsdiva.accountmanager.java_class.SavingAccount;


public class OperationActivity extends AppCompatActivity {

    private static final String TAG = "OperationActivity";
    public final static String EXTRA_VERSEMENTCA = "com.example.nogsdiva.accountmanager..VERSEMENTCA";
    public final static String EXTRA_VERSEMENTBA = "com.example.nogsdiva.accountmanager..VERSEMENTBA";
    public final static String EXTRA_VERSEMENTSA = "com.example.nogsdiva.accountmanager..VERSEMENTSA";
    public final static String EXTRA_RETIRERCA = "com.example.nogsdiva.accountmanager.RETIRERCA";
    public final static String EXTRA_RETIRERSA = "com.example.nogsdiva.accountmanager.RETIRERSA";
    public final static String EXTRA_RETIRERBA = "com.example.nogsdiva.accountmanager.RETIRERBA";
    public final static String EXTRA_VIREMENTCA = "com.example.nogsdiva.accountmanager.VIREMENTCA";
    public final static String EXTRA_VIREMENTSA = "com.example.nogsdiva.accountmanager.VIREMENTSA";
    public final static String EXTRA_VIREMENTBA = "com.example.nogsdiva.accountmanager.VIREMENTBA";
    public final static String EXTRA_SOLDE = "com.example.nogsdiva.accountmanager.SOLDE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        //operation pour versement
          Button bttn4 = (Button) findViewById(R.id.btn4);
          bttn4.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v4){

                   Intent intent= getIntent();
                   String check = intent.getStringExtra(MainActivity.EXTRA_CHECK);

                   Intent intsave= getIntent();
                   String save = intsave.getStringExtra(MainActivity.EXTRA_SAVE);

                    Intent intbus= getIntent();
                    String buss = intbus.getStringExtra(MainActivity.EXTRA_BUSS);
// versement pour compte checking
       if(check!= null){

           Toast.makeText(OperationActivity.this, " versement CheickingAccount", Toast.LENGTH_SHORT).show();
            Intent verserca = new Intent(OperationActivity.this, VersementActivity.class);
             CheckingAccount ac = new CheckingAccount(10, 0, 800000);
              verserca.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
               Button b = (Button)findViewById(R.id.btn4);
                String versementca = b.getText().toString();
                 verserca.putExtra(EXTRA_VERSEMENTCA, versementca);
                  startActivity(verserca);
                    finish();}

// versement pour compte saving
      else if(save!=null){

        Toast.makeText(OperationActivity.this, "versement SAVINGACCOUNT", Toast.LENGTH_SHORT).show();
          Intent versersa = new Intent(OperationActivity.this, VersementActivity.class);
           SavingAccount ac = new SavingAccount(11, 0, 600000);
            versersa.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
             Button be = (Button)findViewById(R.id.btn4);
              String versementsa = be.getText().toString();
               versersa.putExtra(EXTRA_VERSEMENTSA, versementsa);
                 startActivity(versersa);
                  finish();
               }
// versement pour compte Bussines
     else if(buss!=null){

       Toast.makeText(OperationActivity.this, " versement BusinessAccount", Toast.LENGTH_SHORT).show();
         Intent verserba = new Intent(OperationActivity.this, VersementActivity.class);
           BusinessAccount ac = new BusinessAccount(12,0,50000);
            verserba.putExtra(EXTRA_SOLDE, "solde initial:\n" + ac.getSolde() + "FCFA");
             Button bo= (Button)findViewById(R.id.btn4);
              String versementba = bo.getText().toString();
                verserba.putExtra(EXTRA_VERSEMENTBA, versementba);
                 startActivity(verserba);
                  finish();
                }

                else
                   Log.d(TAG, "onClick: compte non trouver");
            }
        });

 //operation retirer pour les trois compte

      Button bttn5 = (Button) findViewById(R.id.btn5);
        bttn5.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v5){
                //recup intent
               Intent intent= getIntent();
               String check = intent.getStringExtra(MainActivity.EXTRA_CHECK);

                Intent t= getIntent();
                String save = t.getStringExtra(MainActivity.EXTRA_SAVE);

                 Intent i= getIntent();
                 String buss = i.getStringExtra(MainActivity.EXTRA_BUSS);

     // pour ChechingAccount
       if(check!=null ){
         Toast.makeText(OperationActivity.this, "retrait CheickingAccount", Toast.LENGTH_SHORT).show();
          Intent retraitac = new Intent(OperationActivity.this, RetraitActivity.class);
            CheckingAccount ac = new CheckingAccount(10, 0, 800000);
              retraitac.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
               Button bi = (Button)findViewById(R.id.btn5);
                 String retirerca = bi.getText().toString();
                   retraitac.putExtra(EXTRA_RETIRERCA, retirerca);
                     startActivity(retraitac);
                       finish();
                    }

//POUR SAVING
      else if(save!=null){
        Toast.makeText(OperationActivity.this, " retrait SavingAccount", Toast.LENGTH_SHORT).show();
          Intent retraitsa = new Intent(OperationActivity.this, RetraitActivity.class);
           SavingAccount ac = new SavingAccount(11, 0, 600000);
            retraitsa.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
              Button bz = (Button)findViewById(R.id.btn5);
               String retirersa = bz.getText().toString();
                retraitsa.putExtra(EXTRA_RETIRERSA, retirersa);
                 startActivity(retraitsa);
                   finish();
               }

//pour bussiness
     else if (buss!=null){
       Toast.makeText(OperationActivity.this, " retrait BussinessAccount", Toast.LENGTH_SHORT).show();
         Intent retraitba = new Intent(OperationActivity.this, RetraitActivity.class);
           BusinessAccount ac = new BusinessAccount(12,0,50000);
            retraitba.putExtra(EXTRA_SOLDE, "solde initial:\n" + ac.getSolde() + "FCFA");
              Button bz = (Button)findViewById(R.id.btn5);
                String retirerba = bz.getText().toString();
                  retraitba.putExtra(EXTRA_RETIRERBA, retirerba);
                    startActivity(retraitba);
                      finish();
                  }
                   else
                    Log.d(TAG, "onClick: compte non trouver");
            }
        });
   //operation virement


        Button bttn6 = (Button) findViewById(R.id.btn6);
           bttn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v6){
                //recup intent
                Intent intent= getIntent();
                String check = intent.getStringExtra(MainActivity.EXTRA_CHECK);

                Intent nt= getIntent();
                String save = nt.getStringExtra(MainActivity.EXTRA_SAVE);

                Intent bi= getIntent();
                String buss = bi.getStringExtra(MainActivity.EXTRA_BUSS);

//virement pour cheching ACCOUNT
      if(check!=null ){
        Toast.makeText(OperationActivity.this, "virement CheickingAccount", Toast.LENGTH_SHORT).show();
          Intent vireac = new Intent(OperationActivity.this, VirementActivity.class);
            CheckingAccount ac = new CheckingAccount(10, 0, 800000);
              vireac.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
                 Button bu = (Button)findViewById(R.id.btn6);
                   String virementca = bu.getText().toString();
                    vireac.putExtra(EXTRA_VIREMENTCA, virementca);
                      startActivity(vireac);
                    }
//virement saving Account
    else if(save!=null ){
      Toast.makeText(OperationActivity.this, "virement SavingAccount", Toast.LENGTH_SHORT).show();
        Intent viresa = new Intent(OperationActivity.this, VirementActivity.class);
          SavingAccount ac = new SavingAccount(11, 0, 600000);
           viresa.putExtra(EXTRA_SOLDE,"solde initial:\n" + ac.getSolde() + "FCFA");
             Button bs = (Button)findViewById(R.id.btn6);
              String virementsa = bs.getText().toString();
                viresa.putExtra(EXTRA_VIREMENTSA, virementsa);
                 startActivity(viresa);
                  finish();
                }

    else if(buss!=null ){
      Toast.makeText(OperationActivity.this, "virement BussinessAccount", Toast.LENGTH_SHORT).show();
        Intent vireba = new Intent(OperationActivity.this, VirementActivity.class);
          BusinessAccount ac = new BusinessAccount(12,0,50000);
            vireba.putExtra(EXTRA_SOLDE, "solde initial:\n" + ac.getSolde() + "FCFA");
              Button bj = (Button)findViewById(R.id.btn4);
                String virementba = bj.getText().toString();
                 vireba.putExtra(EXTRA_VIREMENTBA, virementba);
                  startActivity(vireba);
                     finish();
                 }
                      else
                       Log.d(TAG, "onClick: compte non trouver");
            }
        });




    }}
