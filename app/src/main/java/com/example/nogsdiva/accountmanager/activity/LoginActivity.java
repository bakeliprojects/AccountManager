package com.example.nogsdiva.accountmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nogsdiva.accountmanager.R;
import com.example.nogsdiva.accountmanager.app.MyTestRealm;
import com.example.nogsdiva.accountmanager.modele.Account;

import io.realm.Realm;

    public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_CODE = "com.example.nogsdiva.accountmanager.CODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm realm = Realm.getDefaultInstance();
       // realm.beginTransaction();
        Account account = new Account();
      //  Account account = realm.createObject(Account.class, 10);
        //  MyTestRealm test = new MyTestRealm();
          realm.beginTransaction();
          account.setCode( 10);
          account.setSolde(50000);
         // test.createAccount(account);
        Account account1 = realm.copyToRealmOrUpdate(account);
        realm.commitTransaction();

        Button bt = (Button) findViewById(R.id.connect);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v4){

                EditText et = (EditText)findViewById(R.id.code);
                String code = et.getText().toString();
                int logg = Integer.parseInt(code);

                 if(logg==30){
                   Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra(EXTRA_CODE, code);

                      startActivity(intent);

                }
                else
                    Toast.makeText(LoginActivity.this, "mauvais identifiant", Toast.LENGTH_SHORT).show();

   }
});

        }
    }