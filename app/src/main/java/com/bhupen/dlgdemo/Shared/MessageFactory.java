package com.bhupen.dlgdemo.Shared;

import android.content.Context;

import com.bhupen.dlgdemo.R;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class MessageFactory {

    private Context ctx;

    public MessageFactory(Context ctx) {
        this.ctx = ctx;
    }

    //REGISTER
    public String invalidEmailError() {return ctx.getString(R.string.registerEmailInvalidError);}

    public String emailExitsError() {return ctx.getString(R.string.registerEmailExistsError);}

    public String invalidPasswordError() {return ctx.getString(R.string.registerPasswordError01);}

    public String invalidPasswordMatch() {return ctx.getString(R.string.registerPasswordError02);}

}
