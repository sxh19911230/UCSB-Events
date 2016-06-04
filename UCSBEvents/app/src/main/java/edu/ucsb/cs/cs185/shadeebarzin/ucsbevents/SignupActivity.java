package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

/**
 * Created by Forrest on 2016/6/2.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    EditText _username;
    EditText _nameText;
    EditText _emailText;
    EditText _passwordText;
    Button _signupButton;
    Button _cancelButton;
    TextView _loginLink;

    User u = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _username= (EditText) findViewById(R.id.input_username);
        _nameText = (EditText) findViewById(R.id.input_name);
        _emailText= (EditText) findViewById(R.id.input_email);
        _passwordText=(EditText) findViewById(R.id.input_password);
        _signupButton=(Button) findViewById(R.id.btn_signup);
        _cancelButton=(Button) findViewById(R.id.btn_cancel);
        _loginLink=(TextView) findViewById(R.id.link_login);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
        _cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String username = _username.getText().toString();
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
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
                    if (result.compareTo("Error:") != 0)
                        u = new User(Integer.parseInt(user[0]),user[1],user[2],user[3],user[4]);

                    else
                        Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
                }

            }
        }

        SendRequest sendRequest = new SendRequest();
        try {
            sendRequest.execute("activity=register&user_name="+ URLEncoder.encode(username, "utf-8")+"&user_password="+URLEncoder.encode(password, "utf-8")+"&email_address="+URLEncoder.encode(email, "utf-8")+"&shown_name="+URLEncoder.encode(name, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        if (u != null) {
                            onSignupSuccess();
                        } else {
                            onSignupFailed();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("id", u.getID());
        resultIntent.putExtra("username", u.getUsername());
        resultIntent.putExtra("name", u.getShownname());
        resultIntent.putExtra("email", u.getEmail());
        resultIntent.putExtra("password", u.getPassword());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = _username.getText().toString();
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (username.isEmpty()) {
            _username.setError("enter a valid username");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (name.isEmpty()) {
            _nameText.setError("enter a valid name");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
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
