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

public class DrawalActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGER = "com.example.nogsdiva.accountmanager.retraitactivity.MESSAGER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrait);

        Button br = (Button) findViewById(R.id.btnretrait);
        br.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent= getIntent();
                String retirerca = intent.getStringExtra(OperationActivity.EXTRA_RETIRERCA);

                Intent t= getIntent();
                String retirersa = t.getStringExtra(OperationActivity.EXTRA_RETIRERSA);

                Intent i= getIntent();
                String retirerba = i.getStringExtra(OperationActivity.EXTRA_RETIRERBA);

                  if(retirerca!=null){

                Intent ca = new Intent(DrawalActivity.this, DisplayActivity.class);
                EditText mt = (EditText) findViewById(R.id.editretrait);
                String mg = mt.getText().toString();
                int mtt = Integer.parseInt(mg);
                int code1 = Db.checking.getCode();
                   if(Db.checking.getSolde()<=mtt){
                   Toast.makeText(DrawalActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
        }
                   else{
               Toast.makeText(DrawalActivity.this, "retrait CheckingAccount", Toast.LENGTH_SHORT).show();
               Db.checking.retirer(mtt);
               ca.putExtra(EXTRA_MESSAGER, Db.checking.afficher(code1));
               startActivity(ca);
               finish();
             }
        }

          /**      else if(retirersa!=null){
                      Intent intrtt = new Intent(RetraitActivity.this, DisplayActivity.class);
                      EditText mtrtt = (EditText) findViewById(R.id.editretrait);
                      String message = mtrtt.getText().toString();
                      int sa = Integer.parseInt(message);
                      int code1 = Db.saving.getCode();
                          if(Db.saving.getSolde()<=sa)
                           Toast.makeText(RetraitActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                           else{
                      Toast.makeText(RetraitActivity.this, "retrait SavingAccount", Toast.LENGTH_SHORT).show();
                      Db.saving.retirer(sa);
                      intrtt.putExtra(EXTRA_MESSAGER, Db.saving.afficher(code1));
                      startActivity(intrtt);
                      finish();
                      }
                  }

                else if(retirerba!=null){
                Intent intvrt = new Intent(RetraitActivity.this, DisplayActivity.class);
                EditText mtvrt = (EditText) findViewById(R.id.editretrait);
                String message = mtvrt.getText().toString();
                int ba = Integer.parseInt(message);
                int code2 = Db.business.getCode();
                   if(Db.business.getSolde()<=ba)
                    Toast.makeText(RetraitActivity.this, "solde insuffisant", Toast.LENGTH_SHORT).show();
                    else{
                Toast.makeText(RetraitActivity.this, "retrait BusinessAccount", Toast.LENGTH_SHORT).show();
                Db.business.retirer(ba);
                intvrt.putExtra(EXTRA_MESSAGER, Db.business.afficher(code2));
                startActivity(intvrt);
                finish();}

                  }*/
                           }
        });


    }
}
