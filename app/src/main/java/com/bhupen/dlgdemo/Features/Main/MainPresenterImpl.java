package com.bhupen.dlgdemo.Features.Main;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class MainPresenterImpl implements MainPresenterInterface {

    private MainViewInterface view;


    public MainPresenterImpl(MainViewInterface view) {
        this.view = view;
    }


    //INTERFACE METHODS


    @Override
    public void viewReady() {

    }

    @Override
    public void receiveClickFromUser() {
        view.userClickedCreateAnAccount();
    }

    @Override
    public void sendUserToRegisterScreen() {

        view.FinishMainActivityAndStartRegisterAppScreen();
    }
}
