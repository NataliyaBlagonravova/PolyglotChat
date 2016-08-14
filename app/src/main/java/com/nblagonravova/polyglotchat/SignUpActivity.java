package com.nblagonravova.polyglotchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends AppCompatActivity{

    private static final String TAG = SignUpActivity.class.getSimpleName();

    EditText mFullName;
    EditText mEmail;
    EditText mPassword;

    Button mSignUpButton;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFullName = (EditText) findViewById(R.id.input_full_name);
        mEmail = (EditText) findViewById(R.id.input_email);
        mPassword = (EditText) findViewById(R.id.input_password);
        mSignUpButton = (Button) findViewById(R.id.button_sign_up);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email  = mEmail.getText().toString();
                String password = mPassword.getText().toString();
//              userSignUp(email, password);

            }
        });
    }

}
