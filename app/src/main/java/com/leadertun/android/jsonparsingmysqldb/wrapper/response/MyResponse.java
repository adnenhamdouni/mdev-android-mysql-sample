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
        @SerializedName("name")
        private String mName;
        @SerializedName("age")
        private int mAge;
        @SerializedName("phone")
        private int mPhone;
        @SerializedName("mail")
        private String mMail;
        @SerializedName("username")
        private String mUsername;
        @SerializedName("password")
        private String mPassword;

        public UserResponse(int id, String name, int age, int phone,
                           String mail, String username, String password) {

            this.mId = id;
            this.mName = name;
            this.mAge = age;
            this.mPhone = phone;
            this.mMail = mail;
            this.mUsername = username;
            this.mPassword = password;
        }

        public int getmId() {
            return mId;
        }

        public void setmId(int mId) {
            this.mId = mId;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public int getmAge() {
            return mAge;
        }

        public void setmAge(int mAge) {
            this.mAge = mAge;
        }

        public int getmPhone() {
            return mPhone;
        }

        public void setmPhone(int mPhone) {
            this.mPhone = mPhone;
        }

        public String getmMail() {
            return mMail;
        }

        public void setmMail(String mMail) {
            this.mMail = mMail;
        }

        public String getmUsername() {
            return mUsername;
        }

        public void setmUsername(String mUsername) {
            this.mUsername = mUsername;
        }

        public String getmPassword() {
            return mPassword;
        }

        public void setmPassword(String mPassword) {
            this.mPassword = mPassword;
        }
    }
}
