package com.example.nogsdiva.accountmanager.app;

import android.app.Activity;
import android.os.Bundle;

import com.example.nogsdiva.accountmanager.modele.Account;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nogsdiva on 08-Aug-17.
 */

public class MyTestRealm {
    Realm realm ;

    public  MyTestRealm(){
        realm.getDefaultInstance();
    }
    // methode enregistrer des donnees dans une table
    public void verifID (Account account){
        int nextCode;
        Number num =  realm.where(Account.class).max("code");
        if(num == null) {
            nextCode = 10;
         }  else {
            nextCode = num.intValue() + 1;
         }

        account.setCode(nextCode);
        realm.copyToRealmOrUpdate(account);
        realm.commitTransaction();
    }

    //recuperer des donnees dans la base realm
    public String recover (Account account){

    RealmResults<Account> res =realm.where(Account.class)
         .EqualTo("solde",account.getSolde())
            .findAll();

     return null;
}




    }

