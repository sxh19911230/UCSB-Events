package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 1;
    private static final int RESULT_LOGIN = 565;

    EditText _username;
    EditText _passwordText;
    Button _loginButton;
    Button _cancelButton;
    TextView _signupLink;
    User u = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _username=(EditText) findViewById(R.id.input_username);
        _passwordText=(EditText) findViewById(R.id.input_password);
        _loginButton=(Button) findViewById(R.id.btn_login);
        _cancelButton=(Button) findViewById(R.id.btn_cancel);
        _signupLink=(TextView) findViewById(R.id.link_signup);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public  void onClick(View v){
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String username = _username.getText().toString();
        String password = _passwordText.getText().toString();

        class SendRequest extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String t = CS185Connector.sendRequest(params[0]);

                return t;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (result.compareTo("FAILED") != 0) {
                    String[] user = result.split(" ");
                    u = new User(Integer.parseInt(user[0]),user[1],user[2],user[3],user[4]);
                }

            }
        }

        SendRequest sendRequest = new SendRequest();
        sendRequest.execute("activity=login&user_name=" + username + "&user_password=" + password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if (u != null) {
                            onLoginSuccess();

                        } else {
                            onLoginFailed();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("id", data.getIntExtra("id",-1));
                resultIntent.putExtra("username", data.getStringExtra("username"));
                resultIntent.putExtra("name", data.getStringExtra("name"));
                resultIntent.putExtra("email", data.getStringExtra("email"));
                resultIntent.putExtra("password", data.getStringExtra("password"));
                setResult(RESULT_OK, resultIntent);

                this.finish();
            } else if (resultCode == RESULT_CANCELED) {
                setResult(RESULT_CANCELED, null);
                finish();
            } else if (resultCode == RESULT_LOGIN) {

            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("id", u.getID());
        resultIntent.putExtra("username", u.getUsername());
        resultIntent.putExtra("name", u.getShownname());
        resultIntent.putExtra("email", u.getEmail());
        resultIntent.putExtra("password", u.getPassword());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = _username.getText().toString();
        String password = _passwordText.getText().toString();

        if (username.isEmpty() ) {
            _username.setError("enter a valid username");
            valid = false;
        } else {
            _username.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("enter a valid password");
            valid = false;
        } else {

            _passwordText.setError(null);
        }

        return valid;
    }
}