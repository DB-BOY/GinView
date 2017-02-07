package com.gin.ginview.circleview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gin.ginview.R;

/**
 * Created by wang.lichen on 16/11/11.
 */

public class CircleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
    }
    public static Intent getIntent(Context context){
        return new Intent(context,CircleActivity.class);
    }
}
