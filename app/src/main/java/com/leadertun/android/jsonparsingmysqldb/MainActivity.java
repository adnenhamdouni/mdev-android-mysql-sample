package com.leadertun.android.jsonparsingmysqldb;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.leadertun.android.jsonparsingmysqldb.wrapper.response.MyResponse.UserResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leadertun.android.jsonparsingmysqldb.helper.MyHelper;
import com.leadertun.android.jsonparsingmysqldb.wrapper.UserWrapper;
import com.leadertun.android.jsonparsingmysqldb.wrapper.response.MyResponse.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public final static String TAG = "MainActivity";

    private ProgressDialog pDialog;
    private UserWrapper mUserWrapper;

    private User mUserResponse;


    boolean mResult = false;

    private ArrayList<UserWrapper> ReceiveUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        updateListUsers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateListUsers() {
        new listUsersAsyncTask().execute();

    }

    private class listUsersAsyncTask extends
            AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Connexion...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
            // progress_status = 0;

        }

        @Override
        protected Void doInBackground(Void... params) {

            String data = MyHelper
                    .UserData(null, "users");


            Log.v(TAG, "data = "+data);

            Gson gson = new GsonBuilder().create();
            mUserResponse = gson.fromJson(data,
                    User.class);

            if (mUserResponse.getSuccess() == 1) {
                Log.v(TAG, "chargement réussite");

                ReceiveUsers = new ArrayList<UserWrapper>();

                mResult = true;

                for (UserResponse user : mUserResponse
                        .getUsers()) {

                    mUserWrapper = new UserWrapper();

                    mUserWrapper.setId(user.getmId());
                    mUserWrapper.setEmail(user.getEmail());
                    mUserWrapper.setPassword(user.getPassword());

                    ReceiveUsers.add(mUserWrapper);

                    Log.v(TAG, "nom emplacement ="
                            + mUserWrapper.getEmail());

                }
            }

            else {
                mResult = false;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            pDialog.dismiss();

            runOnUiThread(new Runnable() {
                public void run() {

                    Log.v(TAG, "success = "
                            + mUserResponse.getSuccess());

                    if (mResult == true) {
                        Log.v(TAG, "chargement réussite");

                        showUsersList();

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "probleme de chargement", Toast.LENGTH_SHORT)
                                .show();

                        Log.v(TAG, "probleme de chargement");
                    }

                }

            });

        }
    }

    private void showUsersList() {
        ReceiveUsers.get(0);
        for (UserWrapper userWrapper :ReceiveUsers) {

            Log.v(TAG, "ReceiveUsers => userWrapper name ="
                    + userWrapper.getEmail());

        }
    }
}
