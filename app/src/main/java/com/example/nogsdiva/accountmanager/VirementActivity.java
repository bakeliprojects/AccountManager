package com.example.nogsdiva.accountmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VirementActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGEM = "com.example.nogsdiva.accountmanager.virementactivity.MESSAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virement);

        Button bz = (Button)findViewById(R.id.btok);
        bz.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                Intent intent= getIntent();
                String virementca = intent.getStringExtra(OperationActivity.EXTRA_VIREMENTCA) ;

                Intent inten= getIntent();
                String virementsa = inten.getStringExtra(OperationActivity.EXTRA_VIREMENTSA) ;

                Intent inte= getIntent();
                String virementba = inte.getStringExtra(OperationActivity.EXTRA_VIREMENTBA) ;
                if(virementca!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==2){
                        Toast.makeText(VirementActivity.this, "virement vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        CheckingAccount a1 = new CheckingAccount(10,0,800000);
                        SavingAccount a2 = new SavingAccount(10,0,600000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a1.virement(a2,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}

                    else if(num==3){
                        Toast.makeText(VirementActivity.this, "virement vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        CheckingAccount a1 = new CheckingAccount(10,0,800000);
                        BusinessAccount a2 = new BusinessAccount(10,0,50000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a1.virement(a2,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

                    }

                if(virementsa!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==1){
                        Toast.makeText(VirementActivity.this, "virement vers CheckingAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        CheckingAccount a1 = new CheckingAccount(10,0,800000);
                        SavingAccount a2 = new SavingAccount(10,0,600000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a2.virement(a1,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}

                    else if(num==3){
                        Toast.makeText(VirementActivity.this, "virement vers BusinessAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        BusinessAccount a1 = new BusinessAccount(10,0,50000);
                        SavingAccount a2 = new SavingAccount(10,0,600000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a2.virement(a1,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

                }

                if(virementba!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==2){
                        Toast.makeText(VirementActivity.this, "virement vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        BusinessAccount a1 = new BusinessAccount(10,0,50000);
                        SavingAccount a2 = new SavingAccount(10,0,600000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a1.virement(a2,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}

                    else if(num==1){
                        Toast.makeText(VirementActivity.this, "virement vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        CheckingAccount a1 = new CheckingAccount(10,0,800000);
                        BusinessAccount a2 = new BusinessAccount(10,0,50000);
                        int code2= a2.getCode();
                        int code1 = a1.getCode();
                        // System.out.println("le montant a verser est :" + mtt+ "f");
                        a2.virement(a1,mtt);
                        //System.out.println(a1.afficher(code3));
                        ca.putExtra(EXTRA_MESSAGEM, a1.afficher(code1));
                        ca.putExtra(EXTRA_MESSAGEM, a2.afficher(code2));
                        startActivity(ca);}
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

            }
            }

        });




}}
