package com.leadertun.android.jsonparsingmysqldb;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leadertun.android.jsonparsingmysqldb.helper.MyHelper;
import com.leadertun.android.jsonparsingmysqldb.wrapper.UserWrapper;
import com.leadertun.android.jsonparsingmysqldb.wrapper.response.MyResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mInscription;

    private String mEmail;
    private String mPassword;


    private ProgressDialog pDialog;

    boolean mResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        initView();




    }

    private void initView() {
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etPassword);

        mInscription = (Button) findViewById(R.id.btnInscription);
        mInscription.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.btnInscription) {

            inscription();
        }

    }

    private void inscription() {
        mEmail = mEtEmail.getText().toString();
        mPassword = mEtPassword.getText().toString();

        insertUser();


    }

    private void insertUser() {
        new insertUserAsyncTask().execute();

    }

    private class insertUserAsyncTask extends
            AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(InsertActivity.this);
            pDialog.setMessage("Connexion...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
            // progress_status = 0;

        }

        @Override
        protected Void doInBackground(Void... params) {

            String data = MyHelper
                    .insertUser(mEmail, mPassword);


            Log.v(MainActivity.TAG, "data = " + data);

            //Gson gson = new GsonBuilder().create();
            //mUserResponse = gson.fromJson(data,
            //        MyResponse.User.class);

            //if (mUserResponse.getSuccess() == 1) {
                //Log.v(TAG, "chargement réussite");

                mResult = true;

                //for (MyResponse.UserResponse user : mUserResponse
                //        .getUsers()) {

                //    mUserWrapper = new UserWrapper();

                //    mUserWrapper.setId(user.getmId());
                //    mUserWrapper.setEmail(user.getEmail());
                //    mUserWrapper.setPassword(user.getPassword());

                //    receiveUsers.add(mUserWrapper);

                //    Log.v(TAG, "nom emplacement ="
                //            + mUserWrapper.getEmail());

                //}
            //}

            //else {
             //   mResult = false;
            //}

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            pDialog.dismiss();

            runOnUiThread(new Runnable() {
                public void run() {

                    //Log.v(TAG, "success = "
                    //        + mUserResponse.getSuccess());

                    if (mResult == true) {
                        Log.v(MainActivity.TAG, "chargement réussite");

                        //showUsersList();
                        //mAdapter.notifyDataSetChanged();
                        finish();


                    } else {
                        Toast.makeText(getApplicationContext(),
                                "probleme de chargement", Toast.LENGTH_SHORT)
                                .show();

                        Log.v(MainActivity.TAG, "probleme de chargement");
                    }

                }

            });

        }
    }
}

