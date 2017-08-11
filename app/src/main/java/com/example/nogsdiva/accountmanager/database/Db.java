package com.example.nogsdiva.accountmanager.database;

import android.util.Log;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.activity.DrawalActivity;
import com.example.nogsdiva.accountmanager.modele.Account;
import com.example.nogsdiva.accountmanager.modele.BusinessAccount;
import com.example.nogsdiva.accountmanager.modele.CheckingAccount;
import com.example.nogsdiva.accountmanager.modele.SavingAccount;

import java.util.concurrent.Callable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

import static com.example.nogsdiva.accountmanager.R.id.code;

/**
 * Created by nogsdiva on 03-Aug-17.
 */

public class Db
{

    public static final Account ac =  new Account(10,0,800000);

    public static final CheckingAccount checking =  new CheckingAccount(11,0,800000);

    public static final SavingAccount saving =  new SavingAccount(12,0,900000);

   public static final BusinessAccount business =  new BusinessAccount(13,0,500000);


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
                   int solde = 0;
                     for(CheckingAccount account:results){
                       solde+=account.getSolde();
        }
                          return ""+ solde;
    }
    // recupere donnees table savingAccount
       public String recoveS (){
        Realm realm = Realm.getDefaultInstance();
          RealmResults<SavingAccount> results = realm.where(SavingAccount.class)
           .findAllAsync();
             results.load();
              int solde=0;
                 for(SavingAccount account:results){
                   solde+=account.getSolde();
        }
                      return "" + solde;
    }
  //recupere donnees table BusinessAccount
      public String recoveB (){
        Realm realm = Realm.getDefaultInstance();
          RealmResults <BusinessAccount> results = realm.where(BusinessAccount.class)
           .findAllAsync();
             results.load();
              int solde=0;
               for(BusinessAccount account:results){
                 solde+=account.getSolde();
        }
                   return ""+ solde;
    }
        //paymen for checkingAccount
                             public void paymenC(int montant){
                                 Realm realm = Realm.getDefaultInstance();
                                 realm.beginTransaction();
                                 //CheckingAccount check = new CheckingAccount();
                                 int solde=checking.getSolde()+montant;
                                 checking.setSolde(solde);
                                 realm.copyToRealmOrUpdate(checking);
                                 realm.commitTransaction();
                            }

        //paymen for savingAccount
                            public void paymenS(int montant){
                                Realm realm = Realm.getDefaultInstance();
                                realm.beginTransaction();
                                int solde=saving.getSolde()+montant;
                                saving.setSolde(solde);
                                realm.copyToRealmOrUpdate(saving);
                                realm.commitTransaction();
                                }

        //paymen for bussinesAccount
                                public void paymenB(int montant){
                                    Realm realm = Realm.getDefaultInstance();
                                    realm.beginTransaction();
                                    int solde=business.getSolde()+montant;
                                    business.setSolde(solde);
                                    realm.copyToRealmOrUpdate(business);
                                    realm.commitTransaction();
                                }


                 // Gestion d'affichage chechingAccount
        public String displayC(){
          Realm realm = Realm.getDefaultInstance();
            RealmResults<CheckingAccount> results = realm.where(CheckingAccount.class)
             .findAllAsync();
               results.load();
                 int code = 0;
                   int solde=0;
                    for(CheckingAccount account:results){
                     solde+=account.getSolde();
                       code+=account.getCode();
        }
                          return "numero compte: " + code +" \n solde actuel: " + solde +"";
    }
            //Gestion d'affichage savingAccount
         public String displayS(){
           Realm realm = Realm.getDefaultInstance();
             RealmResults<SavingAccount> results = realm.where(SavingAccount.class)
             .findAllAsync();
                results.load();
                  int code=0;
                    int solde=0;
                      for(SavingAccount account:results){
                        solde+=account.getSolde();
                         code+=account.getCode();
    }
                           return "numero compte: " + code +" \n solde actuel: " + solde;
    }
         //Gestion d'affichage businessAccount
         public String displayB(){
           Realm realm = Realm.getDefaultInstance();
             RealmResults<BusinessAccount> results = realm.where(BusinessAccount.class)
              .findAllAsync();
                results.load();
                  int code=0;
                    int solde=0;
                      for(BusinessAccount account:results){
                        solde+=account.getSolde();
                          code+=account.getCode();
        }
                            return "numero compte: " + code +" \n solde actuel: " + solde;
    }

    //drawal for checkingAccount
    public void drawalC(int montant){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        //CheckingAccount check = new CheckingAccount();
        int solde=checking.getSolde()-montant;
        checking.setSolde(solde);
        realm.copyToRealmOrUpdate(checking);
        realm.commitTransaction();
    }

    //drawal for savingAccount
    public void drawalS(int montant){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        int solde=saving.getSolde()-montant;
        saving.setSolde(solde);
        realm.copyToRealmOrUpdate(saving);
        realm.commitTransaction();
    }

    //drawal for bussinesAccount
    public void drawalB(int montant){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        int solde=business.getSolde()-montant;
        business.setSolde(solde);
        realm.copyToRealmOrUpdate(business);
        realm.commitTransaction();
    }







}