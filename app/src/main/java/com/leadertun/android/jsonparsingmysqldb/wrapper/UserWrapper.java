package com.leadertun.android.jsonparsingmysqldb.wrapper;

import java.io.Serializable;

/**
 * Created by adnen on 15/01/16.
 */
public class UserWrapper implements Serializable {

    private int mId;
    private String mEmail;
    private String mPassword;

    public UserWrapper() {}

    public UserWrapper(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}
