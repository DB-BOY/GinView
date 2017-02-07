package com.gin.ginview.autoplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.gin.ginview.R;
import com.gin.ginview.threeD.ThreeDSlid;

import java.util.ArrayList;


public class AutoPlayDemoActivity extends Activity {
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoplay);
        
        AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.autoGallery);
        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.tuijian_001));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_002));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_003));
        ImageAdapter adapter = new ImageAdapter(this, drawables);
        g.setAdapter(adapter);
    }


    public static Intent getIntent(Context context){
        return new Intent(context,AutoPlayDemoActivity.class);
    }

}