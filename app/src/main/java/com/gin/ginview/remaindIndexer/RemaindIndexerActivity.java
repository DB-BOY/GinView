package com.gin.ginview.remaindIndexer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gin.ginview.R;

/**
 * Created by wang.lichen on 2016/11/17.
 */

public class RemaindIndexerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexer);
        
        
    }
    
    public static Intent getIntent(Context context){
        return new Intent(context,RemaindIndexerActivity.class);
                
    }
}
