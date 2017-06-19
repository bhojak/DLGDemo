package com.bhupen.dlgdemo.Features.Register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bhupen.dlgdemo.R;
import com.bhupen.dlgdemo.Shared.CustomViews.BhupenTextView01;
import com.bhupen.dlgdemo.Shared.CustomViews.MainAppCompatButton;
import com.bhupen.dlgdemo.Shared.MessageFactory;
import com.bhupen.dlgdemo.Shared.Validation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterViewInterface {

    @Bind(R.id.register_rootView)
    ViewGroup rootView;

    @Bind(R.id.register_toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbarHeaderTV)
    BhupenTextView01 toolbarHeaderTV;

    @Bind(R.id.register_emailET)
    EditText register_emailET;

    @Bind(R.id.register_passwordET1)
    EditText register_passwordET1;

    @Bind(R.id.register_passwordET2)
    EditText register_passwordET2;

    @Bind(R.id.register_tick0)
    ImageView register_tick0;

    @Bind(R.id.register_tick1)
    ImageView register_tick1;

    @Bind(R.id.register_eye1)
    ImageView register_eye1;

    @Bind(R.id.register_tick2)
    ImageView register_tick2;

    @Bind(R.id.register_eye2)
    ImageView register_eye2;

    @Bind(R.id.txt_EmailErorMessage)
    BhupenTextView01 EmailErrorMessage;

    @Bind(R.id.txt_PasswordErorMessage01)
    BhupenTextView01 PasswordErrorMessage01;

    @Bind(R.id.txt_PasswordErorMessage02)
    BhupenTextView01 PasswordErrorMessage02;

    @Bind(R.id.txt_RegPasswordInfoMessage)
    BhupenTextView01 PasswordInfoMessage;

    @Bind(R.id.btn_next)
    MainAppCompatButton button;

    private RegisterPresenterImpl presenter;
    private Validation validation;
    private MessageFactory messageFactory;

    boolean hide1 = true;
    boolean hide2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUI();
    }

    private void setupUI() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        validation = new Validation();
        messageFactory = new MessageFactory(this);
        presenter = new RegisterPresenterImpl(this,validation, messageFactory );
        setupToolbar();
        setupTouchListener();
        button.setAlpha(.3f);
        button.setClickable(false);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbarHeaderTV.setText(getResources().getString(R.string.create_account));

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setupTouchListener() {

        register_emailET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("click", "onEmail");
                        clearAllErrorMsg();
                }
                return false;
            }
        });

        register_passwordET1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("click", "onPassword01");
                        presenter.usersFinishedEnteringEmail();
                }
                return false;
            }
        });

        register_passwordET2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("click", "onPassword02");
                        presenter.usersFinishedEnteringPassword01();

                        button.setAlpha(1.0f);
                        button.setClickable(true);
                }
                return false;
            }
        });
    }

    private void clearAllErrorMsg() {
        EmailErrorMessage.setVisibility(View.GONE);

        PasswordErrorMessage01.setVisibility(View.GONE);

        PasswordErrorMessage02.setVisibility(View.GONE);

        PasswordInfoMessage.setVisibility(View.VISIBLE);

    }

    @OnClick(R.id.register_eye1)
    void onRegisterPasswordEye1Clicked(){

        if(hide1) {
            register_passwordET1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            register_passwordET1.setSelection(register_passwordET1.length());
            register_eye1.setBackgroundResource(R.drawable.eye_2);

            hide1 = false;
        } else {
            register_passwordET1.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            register_passwordET1.setSelection(register_passwordET1.length());
            register_eye1.setBackgroundResource(R.drawable.eye_1);

            hide1 = true;
        }
    }

    @OnClick(R.id.register_eye2)
    void onRegisterPasswordEye2Clicked(){

        if(hide1) {
            register_passwordET2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            register_passwordET2.setSelection(register_passwordET2.length());
            register_eye2.setBackgroundResource(R.drawable.eye_2);

            hide2 = false;
        } else {
            register_passwordET2.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            register_passwordET2.setSelection(register_passwordET2.length());
            register_eye2.setBackgroundResource(R.drawable.eye_1);

            hide2 = true;
        }
    }




    // Interface Methods


    @Override
    public void invalidEmail(String message) {
        EmailErrorMessage.setText(message);
        EmailErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void invalidPassword(String message) {
        register_tick1.setVisibility(View.INVISIBLE);
        PasswordErrorMessage01.setText(message);
    }

    @Override
    public void passwordNotMatching(String message) {
        register_tick2.setVisibility(View.INVISIBLE);
        PasswordErrorMessage02.setText(message);
    }

    @Override
    public void validPassword01() {
        register_tick1.setVisibility(View.VISIBLE);

    }

    @Override
    public void validPassword02() {
        register_tick2.setVisibility(View.VISIBLE);
    }

    @Override
    public void validEmail() {
        register_tick0.setVisibility(View.VISIBLE);
    }

    @Override
    public void sendUserEmailToLogic() {
        presenter.receiveUserEmailFromView(
                register_emailET.getText().toString());
    }

    @Override
    public void sendUserPassword01ToLogic() {
        presenter.receiveUserPassword01FromView(
                register_passwordET1.getText().toString());
    }

    @Override
    public void sendUserPassword02ToLogic() {
        presenter.receiveUserPassword02FromView(
                register_passwordET2.getText().toString());
    }

    @Override
    public void userSuccessfullyRegisteredDisplayToastCloseScreenAndEnableNextButton(String message) {

    }
}
