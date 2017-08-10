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
import com.example.nogsdiva.accountmanager.modele.Account;
import com.example.nogsdiva.accountmanager.modele.BusinessAccount;
import com.example.nogsdiva.accountmanager.modele.CheckingAccount;
import com.example.nogsdiva.accountmanager.modele.SavingAccount;


import io.realm.Realm;

    public class LoginActivity extends AppCompatActivity {
        private static final String TAG = "LoginActivity";
    public final static String EXTRA_CODE = "com.example.nogsdiva.accountmanager.CODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ajout table realm
        Realm realm = Realm.getDefaultInstance();
        Account account = new Account();
      //  Account account = realm.createObject(Account.class, 10);
        //  MyTestRealm test = new MyTestRealm();
          realm.beginTransaction();
          account.setCode( 10);
          account.setSolde(50000);
         // test.createAccount(account);
        Account account1 = realm.copyToRealmOrUpdate(account);
        if(account1!=null){
            Log.d(TAG, "la table est bien enregistrer: ");
            realm.commitTransaction(); }
        else
        Toast.makeText(LoginActivity.this, "account1 is null", Toast.LENGTH_SHORT).show();
        //ajout table Checking
        CheckingAccount check = new CheckingAccount();
          realm.beginTransaction();
            check.setCode( 11);
              check.setSolde(800000);
                CheckingAccount check1 = realm.copyToRealmOrUpdate(check);
                  if(check1!=null){
                    Log.d(TAG, "la table est bien enregistrer: ");
                      realm.commitTransaction(); }

        //ajout table Saving
        SavingAccount save = new SavingAccount();
          realm.beginTransaction();
            save.setCode( 12);
             save.setSolde(900000);
              SavingAccount save1 = realm.copyToRealmOrUpdate(save);
               if(save1!=null){
                Log.d(TAG, "la table est bien enregistrer: ");
                 realm.commitTransaction(); }

        //ajout table Saving
        BusinessAccount busines = new BusinessAccount();
         realm.beginTransaction();
          busines.setCode( 13);
           busines.setSolde(500000);
            BusinessAccount busines1 = realm.copyToRealmOrUpdate(busines);
             if(busines1!=null){
              Log.d(TAG, "la table est bien enregistrer: ");
               realm.commitTransaction(); }

        

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