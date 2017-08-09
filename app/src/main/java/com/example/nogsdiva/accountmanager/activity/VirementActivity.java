package com.example.nogsdiva.accountmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.database.Db;

import io.realm.Realm;
import io.realm.RealmObject;

public class VirementActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGEM1 = "com.example.nogsdiva.accountmanager.virementactivity.MESSAGEM1";
    public final static String EXTRA_MESSAGEM2 = "com.example.nogsdiva.accountmanager.virementactivity.MESSAGEM2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virement);

        Button bz = (Button)findViewById(R.id.btok);
        bz.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

         /**       Intent intent= getIntent();
                String virementca = intent.getStringExtra(OperationActivity.EXTRA_VIREMENTCA) ;

                Intent inten= getIntent();
                String virementsa = inten.getStringExtra(OperationActivity.EXTRA_VIREMENTSA) ;

                Intent inte= getIntent();
                String virementba = inte.getStringExtra(OperationActivity.EXTRA_VIREMENTBA) ;

               //virement dans chechingAccount
                if(virementca!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==2){


                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.checking.getCode();
                        int code2 = Db.saving.getCode();
                            if(Db.checking.getSolde()<=mtt)
                            Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                           else{
                        Toast.makeText(VirementActivity.this, "checkingAccount vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Db.checking.virement(Db.saving,mtt);
                        ca.putExtra(EXTRA_MESSAGEM1,"solde restant:\n " + Db.checking.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, "solde du compte beneficiaire:\n" + Db.saving.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                       }
                    }

                    else if(num==3){

                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.checking.getCode();
                        int code2 = Db.business.getCode();
                            if(Db.checking.getSolde()<=mtt)
                            Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                            else{
                        Toast.makeText(VirementActivity.this, "ChechingAccount vers BusinessAccount", Toast.LENGTH_SHORT).show();
                        Db.checking.virement(Db.business,mtt);
                        ca.putExtra(EXTRA_MESSAGEM1,"solde restant:\n" + Db.checking.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, " solde compte beneficiaire:\n" + Db.business.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                     }
                    }
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

                    }

           //virement dans savingAccount
             if(virementsa!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==1){

                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.saving.getCode();
                        int code2 = Db.checking.getCode();
                            if(Db.saving.getSolde()<=mtt)
                            Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                            else{
                         Toast.makeText(VirementActivity.this, "SavingAccount vers CheckingAccount", Toast.LENGTH_SHORT).show();
                         Db.saving.virement(Db.checking,mtt);
                        ca.putExtra(EXTRA_MESSAGEM1, "solde restant:\n" + Db.saving.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, "solde compte beneficiaire:\n" + Db.checking.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                      }
                    }

                    else if(num==3){

                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.saving.getCode();
                        int code2 = Db.business.getCode();
                             if(Db.saving.getSolde()<=mtt)
                             Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                             else{
                        Toast.makeText(VirementActivity.this, "SavingAccount vers BusinessAccount", Toast.LENGTH_SHORT).show();
                        Db.saving.virement(Db.business,mtt);
                        ca.putExtra(EXTRA_MESSAGEM1, "solde restant:\n" + Db.saving.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, "solde compte beneficiaire:\n" + Db.business.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                      }
                    }
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

                }
             // virement dans BusinessAccount
                if(virementba!=null){

                    EditText editText = (EditText) findViewById(R.id.choix);
                    String e = editText.getText().toString();
                    int num = Integer.parseInt(e);
                    if(num==2){

                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.business.getCode();
                        int code2 = Db.saving.getCode();
                             if(Db.business.getSolde()<=mtt)
                             Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                             else{
                        Toast.makeText(VirementActivity.this, "BusinessAccount vers SavingAccount", Toast.LENGTH_SHORT).show();
                        Db.business.virement(Db.saving,mtt);

                        ca.putExtra(EXTRA_MESSAGEM1, "solde restant:\n" + Db.business.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, "solde compte beneficiaire:\n" + Db.saving.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                     }
                    }

                    else if(num==1){

                        Intent ca = new Intent(VirementActivity.this, DisplayActivity.class);
                        EditText mt = (EditText) findViewById(R.id.mntt);
                        String mg = mt.getText().toString();
                        int mtt = Integer.parseInt(mg);
                        int code1= Db.business.getCode();
                        int code2 = Db.checking.getCode();
                            if(Db.business.getSolde()<=mtt)
                            Toast.makeText(VirementActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                            else{
                        Toast.makeText(VirementActivity.this, "Business vers CheckingAccount", Toast.LENGTH_SHORT).show();

                        Db.business.virement(Db.checking,mtt);

                        ca.putExtra(EXTRA_MESSAGEM1, "solde restant:\n" + Db.business.afficher(code1) + "FCFA");
                        ca.putExtra(EXTRA_MESSAGEM2, "solde compte beneficiaire:\n" + Db.checking.afficher(code2) + "FCFA");
                        startActivity(ca);
                        finish();
                      }
                    }
                    else
                        Toast.makeText(VirementActivity.this, "choisir un compte valide", Toast.LENGTH_SHORT).show();

            }*/
            }

        });


}}
