package com.bhupen.dlgdemo.Features.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bhupen.dlgdemo.Features.Register.RegisterActivity;
import com.bhupen.dlgdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class MainActivity extends AppCompatActivity implements MainViewInterface{


    private  MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this);
        presenter.viewReady();

    }

    @OnClick(R.id.btn_register)
    void onRegisterClicked(){

       presenter.sendUserToRegisterScreen();
    }

    @Override
    public void FinishMainActivityAndStartRegisterAppScreen() {
        finish();
        startActivity(new Intent(getApplication(), RegisterActivity.class));
    }

    @Override
    public void userClickedCreateAnAccount() {
        presenter.receiveClickFromUser();
    }
}
