package com.example.android1.adminusertypelogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String dummy_email = "k@gmail.com";
    String dummy_password = "12345";
    String TAG = "LoginActivity";
    String admin_dummy_email = "admin@gmail.com";
    String admin_dummy_password = "admin";

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    String email, password;


    private RadioGroup radioUserTypeGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        radioUserTypeGroup = (RadioGroup) findViewById(R.id.radioTypeGroup);

        editTextEmail = (EditText) findViewById(R.id.edittextemail);
        editTextPassword = (EditText) findViewById(R.id.edittextpassword);

        buttonLogin = (Button) findViewById(R.id.buttonlogin);
        buttonLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonlogin:
                loginMethod();

        }
    }

    private void loginMethod() {
        hideKeyboard();
        int selectedId = radioUserTypeGroup.getCheckedRadioButtonId();


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.loginlayout);
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        int flag = 1;
        if (email.isEmpty()) {
            flag = 0;
            editTextEmail.setError("email can not blank");
        }

        if (password.isEmpty()) {
            flag = 0;
            editTextPassword.setError("email can not blank");
        }

        if (flag == 1) {
            if (selectedId == R.id.radiobuttonUser) {
                Log.d(TAG, "type user");

                if (password.equals(dummy_password))
                    if (email.equals(dummy_email)) {
                        Snackbar.make(linearLayout, "Successfully Login", Snackbar.LENGTH_LONG).show();
                        Intent in = new Intent(LoginActivity.this, HomeActivity.class);
                        in.putExtra("type", "user");
                        startActivity(in);
                        finish();
                    } else {
                        Snackbar.make(linearLayout, "Invalid username or password", Snackbar.LENGTH_LONG).show();
                    }
                else {
                    Snackbar.make(linearLayout, "Invalid username or password", Snackbar.LENGTH_LONG).show();
                }


            } else if (selectedId == R.id.radiobuttonAdmin) {
                Log.d(TAG, "type Admin");

                if (email.equals(admin_dummy_email) && password.equals(admin_dummy_password)) {
                    Snackbar.make(linearLayout, "Successfully Login", Snackbar.LENGTH_LONG).show();
                    Intent in = new Intent(LoginActivity.this, HomeActivity.class);
                    in.putExtra("type", "admin");
                    startActivity(in);
                    finish();
                } else {
                    Snackbar.make(linearLayout, "Invalid username or password", Snackbar.LENGTH_LONG).show();
                }

            } else {

                Snackbar.make(linearLayout, "Please Select User type", Snackbar.LENGTH_LONG).show();

            }
        }
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
