package com.gin.ginview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gin.ginview.autoplay.AutoPlayDemoActivity;
import com.gin.ginview.banner.BannerViewActivity;
import com.gin.ginview.circleview.CircleActivity;
import com.gin.ginview.remaindIndexer.RemaindIndexerActivity;
import com.gin.ginview.threeD.ThreeDSlid;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view) {
        Intent intent;

        switch (view.getId()) {

            case R.id.d3:
                intent = ThreeDSlid.getIntent(MainActivity.this);
                break;
            case R.id.index:
                intent = RemaindIndexerActivity.getIntent(MainActivity.this);
                break;
            case R.id.circle:
                intent = CircleActivity.getIntent(MainActivity.this);
                break;
            case R.id.banner:
                intent = BannerViewActivity.getIntent(MainActivity.this);
                break;
            case R.id.autoplay:
                intent = AutoPlayDemoActivity.getIntent(MainActivity.this);
                break;
            default:
                intent = ThreeDSlid.getIntent(MainActivity.this);
                break;
        }

        startActivity(intent);
    }
}
