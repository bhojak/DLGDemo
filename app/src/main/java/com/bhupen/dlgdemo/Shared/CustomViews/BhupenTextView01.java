package com.bhupen.dlgdemo.Shared.CustomViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;


/**
 * Created by Bhupen on 18/06/2017.
 */

public class BhupenTextView01 extends AppCompatTextView {

    public BhupenTextView01(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans_300.ttf"));
    }
}
