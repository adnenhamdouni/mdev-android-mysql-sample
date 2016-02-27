package com.leadertun.android.jsonparsingmysqldb.wrapper.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by adnen on 15/01/16.
 */
public class MyResponse {

    public class User {

        @SerializedName("success")
        private int mSuccess;

        @SerializedName("message")
        private String mMessage;

        @SerializedName("users")
        private ArrayList<UserResponse> mUsers;

        public User(int success, String message) {
            super();
            this.mSuccess = success;
            this.mMessage = message;
        }

        public int getSuccess() {
            return mSuccess;
        }

        public void setSuccess(int success) {
            this.mSuccess = success;
        }

        public String getMessage() {
            return mMessage;
        }

        public void setMessage(String message) {
            this.mMessage = message;
        }

        public ArrayList<UserResponse> getUsers() {
            return mUsers;
        }

        public void setUsers(ArrayList<UserResponse> mUsers) {
            this.mUsers = mUsers;
        }

    }



    public class UserResponse {

        @SerializedName("id")
        private int mId;
        @SerializedName("email")
        private String mEmail;
        @SerializedName("password")
        private String mPassword;

        public UserResponse(int id, String email, String password) {

            this.mId = id;
            this.mEmail = email;
            this.mPassword = password;
        }

        public int getmId() {
            return mId;
        }

        public void setmId(int mId) {
            this.mId = mId;
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
}
