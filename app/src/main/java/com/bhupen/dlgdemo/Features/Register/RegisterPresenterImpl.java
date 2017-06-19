package com.bhupen.dlgdemo.Features.Register;

import com.bhupen.dlgdemo.Shared.MessageFactory;
import com.bhupen.dlgdemo.Shared.Validation;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class RegisterPresenterImpl implements RegisterPresenterInterface {

    private RegisterViewInterface view;
    private Validation validation;
    private MessageFactory messageFactory;
    private  boolean validEmail = false;
    private  boolean validPassword01 = false;
    private  boolean validPassword02 = false;

    public RegisterPresenterImpl(RegisterViewInterface view, Validation validation, MessageFactory messageFactory) {
        this.view = view;
        this.validation = validation;
        this.messageFactory = messageFactory;
    }

    // Interface methods


    @Override
    public void usersFinishedEnteringEmail() {
        view.sendUserEmailToLogic();
    }

    @Override
    public void usersFinishedEnteringPassword01() {
        view.sendUserPassword01ToLogic();
    }

    @Override
    public void usersFinishedEnteringPassword02() {
        view.sendUserPassword02ToLogic();
    }

    @Override
    public void receiveUserEmailFromView(String email) {
        if(!validation.checkForValidEmail(email)) {
            view.invalidEmail(messageFactory.invalidEmailError());
        } else {
            validEmail = true;
            view.validEmail();
        }
    }

    @Override
    public void receiveUserPassword01FromView(String password1) {
        if(!validation.checkForValidPassword(password1)) {
            view.invalidEmail(messageFactory.invalidPasswordError());
        } else {
            validPassword01 = true;
        }
    }

    @Override
    public void receiveUserPassword02FromView(String password2) {
        if(!validation.checkForValidPassword(password2)) {
            view.invalidEmail(messageFactory.invalidPasswordError());
        } else {
            validPassword01 = true;
        }
    }

    private void saveRegistrationData() {

    }
}
