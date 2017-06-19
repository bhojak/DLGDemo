package com.bhupen.dlgdemo.Shared.CustomViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Bhupen on 18/06/2017.
 */

public class BhupenTextView02 extends AppCompatTextView {

    public BhupenTextView02(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans_500.ttf"));
    }
}
