package com.nblagonravova.polyglotchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.OnClickListener;

public class SignInActivity extends AppCompatActivity{

    private static final String TAG = SignInActivity.class.getSimpleName();

    private EditText mEmail;
    private EditText mPassword;

    private Button mButtonSignIn;

    private TextView mButtonRegistration;
    private TextView mButtonForgotPassword;

    private ImageView mButtonSignInTwitter;
    private ImageView mButtonSignInFacebook;
    private ImageView mButtonSignInGooglePlus;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEmail = (EditText) findViewById(R.id.input_email);
        mPassword = (EditText) findViewById(R.id.input_password);
        mButtonSignIn = (Button) findViewById(R.id.button_sign_in);
        mButtonRegistration = (TextView) findViewById(R.id.button_registration);
        mButtonForgotPassword = (TextView) findViewById(R.id.button_forgot_password);
        mButtonSignInTwitter = (ImageView) findViewById(R.id.button_sign_in_twitter);
        mButtonSignInFacebook = (ImageView) findViewById(R.id.button_sign_in_facebook);
        mButtonSignInGooglePlus = (ImageView) findViewById(R.id.button_sign_in_google_plus);

        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_sign_in:
                        String email  = mEmail.getText().toString();
                        String password = mPassword.getText().toString();
//                      userSignIn(email, password);
                        break;
                    case R.id.button_registration:
                        Intent intent = SignUpActivity.newIntent(SignInActivity.this);
                        startActivity(intent);
                        break;
                    case R.id.button_forgot_password:
                        break;
                    case R.id.button_sign_in_twitter:
//                      twitterSignIn();
                        break;
                    case R.id.button_sign_in_facebook:
//                      facebookSignIn();
                        break;
                    case R.id.button_sign_in_google_plus:
//                      googleSignIn();
                        break;
                    default:
                        break;

                }
            }
        };

        mButtonSignIn.setOnClickListener(onClickListener);
        mButtonRegistration.setOnClickListener(onClickListener);
        mButtonForgotPassword.setOnClickListener(onClickListener);
        mButtonSignInTwitter.setOnClickListener(onClickListener);
        mButtonSignInFacebook.setOnClickListener(onClickListener);
        mButtonSignInGooglePlus.setOnClickListener(onClickListener);

    }
}
