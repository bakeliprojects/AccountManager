package com.example.nogsdiva.accountmanager;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


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
//pour compte checking
                if(check!= null){
               // Log.d(TAG, "onClick: check = "+check);
                Toast.makeText(OperationActivity.this, " versement CheickingAccount", Toast.LENGTH_SHORT).show();

                Intent intverserca = new Intent(OperationActivity.this, VersementActivity.class);
                Button b = (Button)findViewById(R.id.btn4);
                String versementca = b.getText().toString();
                intverserca.putExtra(EXTRA_VERSEMENTCA, versementca);
                startActivity(intverserca); }
               // else Log.d(TAG, "onClick: is nulll");
//pour compte saving
                else if(save!=null){
                    Toast.makeText(OperationActivity.this, "versement SAVINGACCOUNT", Toast.LENGTH_SHORT).show();

                    Intent intversersa = new Intent(OperationActivity.this, VersementActivity.class);
                    Button be = (Button)findViewById(R.id.btn4);
                    String versementsa = be.getText().toString();
                    intversersa.putExtra(EXTRA_VERSEMENTSA, versementsa);
                    startActivity(intversersa);}
//pour compte Bussines
                else if(buss!=null){
                    Toast.makeText(OperationActivity.this, " versement BusinessAccount", Toast.LENGTH_SHORT).show();
                    Intent intverserba = new Intent(OperationActivity.this, VersementActivity.class);
                    Button bo= (Button)findViewById(R.id.btn4);
                    String versementba = bo.getText().toString();
                    intverserba.putExtra(EXTRA_VERSEMENTBA, versementba);
                    startActivity(intverserba); }
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

 //verifivationretirer

     // pour ChechingAccount
                if(check!=null ){
                    Toast.makeText(OperationActivity.this, "retrait CheickingAccount", Toast.LENGTH_SHORT).show();
                    Intent intretrait = new Intent(OperationActivity.this, RetraitActivity.class);
                    Button bi = (Button)findViewById(R.id.btn5);
                    String retirerca = bi.getText().toString();
                    intretrait.putExtra(EXTRA_RETIRERCA, retirerca);
                    startActivity(intretrait);  }
//POUR SAVING
                else if(save!=null){
                    Toast.makeText(OperationActivity.this, " retrait SavingAccount", Toast.LENGTH_SHORT).show();
                Intent intretrait = new Intent(OperationActivity.this, RetraitActivity.class);
                Button bz = (Button)findViewById(R.id.btn5);
                String retirersa = bz.getText().toString();
                intretrait.putExtra(EXTRA_RETIRERSA, retirersa);
                startActivity(intretrait); }
//pour bussiness
                else if (buss!=null){
                    Toast.makeText(OperationActivity.this, " retrait BussinessAccount", Toast.LENGTH_SHORT).show();
                    Intent intretrait = new Intent(OperationActivity.this, RetraitActivity.class);
                    Button bz = (Button)findViewById(R.id.btn5);
                    String retirerba = bz.getText().toString();
                    intretrait.putExtra(EXTRA_RETIRERBA, retirerba);
                    startActivity(intretrait); }
                Log.d(TAG, "onClick: compte non trouver");

            }
        });
   //operation virement
        //pour cheching ACCOUNT

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

                if(check!=null ){
                    Toast.makeText(OperationActivity.this, "virement CheickingAccount", Toast.LENGTH_SHORT).show();

                    // sendMessage(view);
                    Intent intvire = new Intent(OperationActivity.this, VirementActivity.class);
                    Button bu = (Button)findViewById(R.id.btn6);
                    String virementca = bu.getText().toString();
                    intvire.putExtra(EXTRA_VIREMENTCA, virementca);
                    startActivity(intvire); }

                else if(save!=null ){
                    Toast.makeText(OperationActivity.this, "virement SavingAccount", Toast.LENGTH_SHORT).show();
                Intent intvire = new Intent(OperationActivity.this, VirementActivity.class);
                Button bs = (Button)findViewById(R.id.btn6);
                String virementsa = bs.getText().toString();
                intvire.putExtra(EXTRA_VIREMENTSA, virementsa);
                startActivity(intvire); }

               else if(buss!=null ){
                    Toast.makeText(OperationActivity.this, "virement BussinessAccount", Toast.LENGTH_SHORT).show();
                Intent intvire = new Intent(OperationActivity.this, VirementActivity.class);
                Button bj = (Button)findViewById(R.id.btn4);
                String virementba = bj.getText().toString();
                intvire.putExtra(EXTRA_VIREMENTBA, virementba);
                startActivity(intvire); }
                Log.d(TAG, "onClick: compte non trouver");
            }
        });




    }}
