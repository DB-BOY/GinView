package com.gin.ginview.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gin.ginview.circleview.CircleActivity;

/**
 * Created by wang.lichen on 2017/2/7.
 */

public class BannerViewActivity extends Activity {
    @Override
    public void onCreate( Bundle savedInstanceStatee) {
        super.onCreate(savedInstanceStatee);

    }
    public static Intent getIntent(Context context){
        return new Intent(context,BannerViewActivity.class);
    }
}
