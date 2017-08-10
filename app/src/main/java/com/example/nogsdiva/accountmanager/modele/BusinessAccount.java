package com.example.nogsdiva.accountmanager.modele;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nogsdiva on 26-Jul-17.
 */

public class BusinessAccount extends RealmObject {


    @PrimaryKey private int code;
    private int montant;
    private int solde;


    public BusinessAccount() {
    }

    public int getCode() {

        return code;
    }


    public int getMontant() {
        return montant;
    }

    public int getSolde() {
        return solde;
    }
    //setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public BusinessAccount(int code, int montant, int solde) {
        this.code = code;
        this.montant = montant;
        this.solde = solde;
    }


    public void retirer(int montant){

        if( montant<solde){
            solde-=montant;
        }
        else
            System.out.println("votre solde est insuffissant");

    }


    public void verser(int montant){

        solde+=montant;
    }

    public String afficher(int code){

        return "Numero compte:" + code + "\nSolde Compte:" + solde;

    }


    public void virement(Account acc,int montant){
        if(montant<=solde)  {
            acc.verser( montant);
            this.retirer( montant);
        }
        else
            System.out.println("le montant saisie est superieur a votre solde");
    }


    }


