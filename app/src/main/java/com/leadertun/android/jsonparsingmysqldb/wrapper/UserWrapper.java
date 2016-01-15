package com.leadertun.android.jsonparsingmysqldb.wrapper;

import java.io.Serializable;

/**
 * Created by adnen on 15/01/16.
 */
public class UserWrapper implements Serializable {

    private int mId;
    private String mNom;
    private String mPrenom;
    private int mTel;
    private int mAge;
    private String mSexe;
    private String mPays;
    private String mAdresse;
    private String mMail;
    private String mImage;
    private String mNomUtilisateur;
    private String mMotDePasse;

    public UserWrapper() {}

    public UserWrapper(String mNomUtilisateur, String mMotDePasse) {
        this.mNomUtilisateur = mNomUtilisateur;
        this.mMotDePasse = mMotDePasse;
    }

    public UserWrapper(String nom, String prenom,
                       String nomUtilisateur, String motDePasse) {

        this.mNom = nom;
        this.mPrenom = prenom;
        this.mNomUtilisateur = nomUtilisateur;
        this.mMotDePasse = motDePasse;
    }

    public UserWrapper(int id, String nom, String prenom, int tel, int age,
                       String sexe, String pays, String adresse, String mail,
                       String image, String nomUtilisateur, String motDePasse) {
        this.mId = id;
        this.mNom = nom;
        this.mPrenom = prenom;
        this.mTel = tel;
        this.mAge = age;
        this.mSexe = sexe;
        this.mPays = pays;
        this.mAdresse = adresse;
        this.mMail = mail;
        this.mImage = image;
        this.mNomUtilisateur = nomUtilisateur;
        this.mMotDePasse = motDePasse;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getNom() {
        return mNom;
    }

    public void setNom(String nom) {
        this.mNom = nom;
    }

    public String getPrenom() {
        return mPrenom;
    }

    public void setPrenom(String prenom) {
        this.mPrenom = prenom;
    }

    public int getTel() {
        return mTel;
    }

    public void setTel(int tel) {
        this.mTel = tel;
    }

    public String getSexe() {
        return mSexe;
    }

    public void setSexe(String sexe) {
        this.mSexe = sexe;
    }

    public String getNomUtilisateur() {
        return mNomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.mNomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return mMotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.mMotDePasse = motDePasse;
    }

    public String getPays() {
        return mPays;
    }

    public void setPays(String pays) {
        this.mPays = pays;
    }

    public String getAdresse() {
        return mAdresse;
    }

    public void setAdresse(String adresse) {
        this.mAdresse = adresse;
    }

    public String getImage() { return mImage; }

    public void setImage(String image) {
        this.mImage = image;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }
}
