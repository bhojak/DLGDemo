package com.bhupen.dlgdemo.Shared.CustomViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class MainAppCompatButton extends AppCompatButton {

    public MainAppCompatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans_300.ttf"));
}
}
