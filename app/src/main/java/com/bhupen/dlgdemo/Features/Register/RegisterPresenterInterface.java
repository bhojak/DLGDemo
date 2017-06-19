package com.bhupen.dlgdemo.Features.Register;

/**
 * Created by Bhupen on 18/06/2017.
 */

public interface RegisterPresenterInterface {

    void usersFinishedEnteringEmail();

    void usersFinishedEnteringPassword01();

    void usersFinishedEnteringPassword02();

    void receiveUserEmailFromView(String email);

    void receiveUserPassword01FromView(String password1);

    void receiveUserPassword02FromView(String password2);


}
