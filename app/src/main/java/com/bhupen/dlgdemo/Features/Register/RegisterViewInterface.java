package com.bhupen.dlgdemo.Features.Register;

/**
 * Created by Bhupen on 18/06/2017.
 */

public interface RegisterViewInterface {

    void invalidEmail(String message);

    void invalidPassword(String message);

    void passwordNotMatching(String message);

    void validPassword01();

    void validPassword02();

    void validEmail();

    void sendUserEmailToLogic();

    void sendUserPassword01ToLogic();

    void sendUserPassword02ToLogic();

    void userSuccessfullyRegisteredDisplayToastCloseScreenAndEnableNextButton(String message);
}
