package com.example.nogsdiva.accountmanager;

/**
 * Created by nogsdiva on 26-Jul-17.
 */

public class Account extends MainActivity  {

    private int code;
    private int montant;
    private int solde;

    public int getCode() {
        return code;
    }

    public int getMontant() {
        return montant;
    }

    public int getSolde() {
        return solde;
    }

    public Account(int code, int montant, int solde) {
        this.code = code;
        this.montant = montant;
        this.solde = solde;
    }



    public void retirer(int montant){

        if( montant<solde){
            solde-=montant;
            solde--;
            System.out.println("operation reussie");
        }
        else
            System.out.println("votre solde est insuffissant");

    }


    public void verser(int montant){

        solde+=montant;
        solde++;
    }

    public String afficher(int code){

        return "Code du client : "+code+"\nSolde du Compte : "+solde;

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
