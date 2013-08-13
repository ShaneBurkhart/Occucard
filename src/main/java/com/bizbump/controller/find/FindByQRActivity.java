package com.bizbump.controller.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

import com.bizbump.R;
import com.bizbump.view.fragment.share.ShareByQR;
import com.bizbump.libs.zxing.IntentIntegrator;
import com.bizbump.libs.zxing.IntentResult;

/**
 * Created by Shane on 8/12/13.
 */
public class FindByQRActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if container exists
        if(findViewById(R.id.fragment_container) != null){
            //Now add some fragment.
            //Return if already opened or something like that.
            if(savedInstanceState != null){
                return;
            }
            //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ShareByQR()).commit();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Launch QR scanner
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);

        setTitle("Find By QR Code");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String contents = scanResult.getContents();
            if(contents != null)
                Log.d("Scan Result", contents);
            else
                finish();
        }else
            finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
