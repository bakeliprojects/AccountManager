package com.example.nogsdiva.accountmanager.activite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.java_class.BusinessAccount;
import com.example.nogsdiva.accountmanager.java_class.CheckingAccount;
import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.java_class.SavingAccount;

public class RetraitActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGER = "com.example.nogsdiva.accountmanager.retraitactivity.MESSAGER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrait);

        Intent sld = getIntent();
        String solde = sld.getStringExtra(OperationActivity.EXTRA_SOLDE);
        TextView tv = (TextView) findViewById(R.id.initialr);
        tv.setText(solde);

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
                  Toast.makeText(RetraitActivity.this, "retrait CheckingAccount", Toast.LENGTH_SHORT).show();
                Intent ca = new Intent(RetraitActivity.this, DisplayActivity.class);
                EditText mt = (EditText) findViewById(R.id.editretrait);
                String mg = mt.getText().toString();
                int mtt = Integer.parseInt(mg);
                CheckingAccount a1 = new CheckingAccount(10,0,800000);
                int code1 = a1.getCode();
                // System.out.println("le montant a verser est :" + mtt+ "f");
                a1.retirer(mtt);
                //System.out.println(a1.afficher(code3));
                ca.putExtra(EXTRA_MESSAGER, a1.afficher(code1));
                startActivity(ca);
                      finish();
                  }

                else if(retirersa!=null){
                      Toast.makeText(RetraitActivity.this, "retrait SavingAccount", Toast.LENGTH_SHORT).show();
                      Intent intrtt = new Intent(RetraitActivity.this, DisplayActivity.class);
                      EditText mtrtt = (EditText) findViewById(R.id.editretrait);
                      String message = mtrtt.getText().toString();
                      int intrt = Integer.parseInt(message);
                      SavingAccount c1 = new SavingAccount(11,0,600000);
                      int code1 = c1.getCode();
                      // System.out.println("le montant a verser est :" + mtt+ "f");
                      c1.retirer(intrt);
                      //System.out.println(a1.afficher(code3));
                      intrtt.putExtra(EXTRA_MESSAGER, c1.afficher(code1));
                      startActivity(intrtt);
                      finish();
                  }

                else if(retirerba!=null){
                Toast.makeText(RetraitActivity.this, "retrait BusinessAccount", Toast.LENGTH_SHORT).show();
            Intent intvrt = new Intent(RetraitActivity.this, DisplayActivity.class);
                EditText mtvrt = (EditText) findViewById(R.id.editretrait);
                String message = mtvrt.getText().toString();
                int intmrt = Integer.parseInt(message);
                BusinessAccount c2 = new BusinessAccount(12,0,50000);
                int code2 = c2.getCode();
                // System.out.println("le montant a verser est :" + mtt+ "f");
                c2.retirer(intmrt);
                //System.out.println(a1.afficher(code3));
                intvrt.putExtra(EXTRA_MESSAGER, c2.afficher(code2));
                startActivity(intvrt);
                      finish();
                  }
                           }
        });

    }
}
