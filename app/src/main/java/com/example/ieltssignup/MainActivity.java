package com.example.ieltssignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.Info_Txt);
        info.setText(" With 15 IELTS test venues around New Zealand, " +
                " it's easy to find an IELTS test in a location that suits you. " +
                "Find your closest IELTS test centre by entering your suburb. " +
                "You can further narrow your search using the filters to search" +
                " for computer-delivered or paper-based IELTS.");
    }

    public void OnBooking(View view) {

        Intent intent = new Intent ( this,BookingProcess.class);
        startActivity(intent);
    }

    public void OnVideoView(View view) {
        Intent vVIntent = new Intent ( this, VideoViewDemo.class);
        startActivity(vVIntent);
    }

    public void OnCall(View view) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        //callIntent.setData(Uri.parse("tel : 123456"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
        }
        else
        {
            startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel : 123456")));
        }
    }

    public void OnEmail(View view) {
        String[] TO = {"test@gmail.com"};
        String[] CC = {""};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "test subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi How are you?");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

    public void OnSMS(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","123456",null)));
    }

    public void OnMap(View view) {
        Intent mapIntent = new Intent(this,IELTS_Map.class);
        startActivity(mapIntent);
    }
}
