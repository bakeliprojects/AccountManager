package com.example.nogsdiva.accountmanager.database;

import android.util.Log;

import com.example.nogsdiva.accountmanager.modele.Account;
import com.example.nogsdiva.accountmanager.modele.BusinessAccount;
import com.example.nogsdiva.accountmanager.modele.CheckingAccount;
import com.example.nogsdiva.accountmanager.modele.SavingAccount;

import java.util.concurrent.Callable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by nogsdiva on 03-Aug-17.
 */

public class Db
{

    public static final Account checking =  new Account(10,0,800000);

  //  public static final CheckingAccount checking =  new CheckingAccount(10,0,800000);

  //  public static final SavingAccount saving =  new SavingAccount(11,0,600000);

  //  public static final BusinessAccount business =  new BusinessAccount(12,0,50000);


    public  Db(){
        Realm.getDefaultInstance();
    }
/**    public void verifID (Account account){
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
    }*/

    //recuperer des donnees dans la table checkingAccount realm
       public String recoveC (){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CheckingAccount> results = realm.where(CheckingAccount.class)
                .findAllAsync();
        results.load();
        String output="";
        for(CheckingAccount account:results){
            output+=account.getSolde();
        }
        return output;
        // tv.setText("votre solde initial est: " + output + "FCFA");
    }

    public String recoveS (){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<SavingAccount> results = realm.where(SavingAccount.class)
                .findAllAsync();
        results.load();
        String output="";
        for(SavingAccount account:results){
            output+=account.getSolde();
        }
        return output;
        // tv.setText("votre solde initial est: " + output + "FCFA");
    }

    public String recoveB (){
        Realm realm = Realm.getDefaultInstance();
        RealmResults <BusinessAccount> results = realm.where(BusinessAccount.class)
                .findAllAsync();
        results.load();
        String output="";
        for(BusinessAccount account:results){
            output+=account.getSolde();
        }
        return output;
        // tv.setText("votre solde initial est: " + output + "FCFA");
    }
    //update for checkingAccount
     public void updateCheick(int montant){

        Realm realm = Realm.getDefaultInstance();
          realm.beginTransaction();
       // RealmResults <CheckingAccount> toEdit = realm.where(CheckingAccount.class)
      //         // .equalTo("no", card.getNo())
             //   .findAllAsync();
       // for (CheckingAccount checking: toEdit)
        // toEdit.setsolde(checking.verser(montant));
        realm.commitTransaction();



    }







}